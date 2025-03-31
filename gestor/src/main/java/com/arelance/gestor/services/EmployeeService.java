package com.arelance.gestor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arelance.gestor.entities.Employee;
import com.arelance.gestor.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    
    public Optional<Employee> findById(Long id){ //Optional<Employee> => para avisar de que puede ser nulo o no encontrar nada
        return Optional.ofNullable(employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el empleado con id: " + id)));
    }

    public Employee update(Employee employeeDetails, Long id){
        
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employee2 = employee.get();
            employee2.setName(employeeDetails.getName());
            employee2.setDni(employeeDetails.getDni());
            employee2.setEmail(employeeDetails.getEmail());
            employee2.setAddress(employeeDetails.getAddress());

            employeeRepository.save(employee2);

            System.out.println("SE HA ACTUALIZADO" );

        } 
        System.out.println("NO SE HA ACTUALIZADO" );

        return null;
    }

}
