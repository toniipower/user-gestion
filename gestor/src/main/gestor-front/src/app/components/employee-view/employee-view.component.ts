import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

interface Employee {
  id: number;
  name: string;
  lastname: string;
  email: string;
  dni: string;
  address: string;
  role: {
    erole: string;
  };
}

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {
  employees: Employee[] = [];
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(
    private employeeService: EmployeeService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadEmployees();
  }

  loadEmployees() {
    this.isLoading = true;
    this.errorMessage = '';
    
    this.employeeService.getEmployees().subscribe({
      next: (data) => {
        this.employees = data;
        this.isLoading = false;
      },
      error: (error) => {
        this.errorMessage = 'Error al cargar los empleados';
        console.error('Error loading employees:', error);
        this.isLoading = false;
      }
    });
  }

  isAdmin(): boolean {
    return this.authService.getRole() === 'ADMIN';
  }

  addEmployee() {
    this.router.navigate(['/add-employee']);
  }

  editEmployee(employee: Employee) {
    this.router.navigate(['/edit-employee', employee.id]);
  }

  deleteEmployee(employeeId: number) {
    if (confirm('¿Estás seguro de que quieres eliminar este empleado?')) {
      this.employeeService.deleteEmployee(employeeId).subscribe({
        next: () => {
          this.employees = this.employees.filter(emp => emp.id !== employeeId);
        },
        error: (error) => {
          this.errorMessage = 'Error al eliminar el empleado';
          console.error('Error deleting employee:', error);
        }
      });
    }
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
