import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { LoginComponent } from './components/auth/login.component';
// import { RegisterComponent } from './components/auth/register.component';
// import { EmployeeViewComponent } from './components/employees/employee-view.component';
import { AuthGuard } from './guards/auth.guard';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { EmployeeViewComponent } from './components/employee-view/employee-view.component';
import { DepartmentViewComponent } from './components/department-view/department-view.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'employee', component: EmployeeViewComponent, canActivate: [AuthGuard] },
  { path: 'department', component: DepartmentViewComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
