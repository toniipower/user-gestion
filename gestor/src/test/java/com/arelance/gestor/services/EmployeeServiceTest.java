package com.arelance.gestor.services;

import com.arelance.gestor.entities.Employee;
import com.arelance.gestor.entities.Role;
import com.arelance.gestor.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    
    @InjectMocks
    private EmployeeService employeeService;
    
    @Test
    void testCreateEmployee() {
        // Arrange
        Employee employee = new Employee();
        employee.setName("Alvaro");
        employee.setLastname("Mero");
        employee.setDni("12345678A");
        employee.setEmail("Alvaro@mero.com");
        employee.setPassword("123456");
        
        when(employeeRepository.existsByEmail("Alvaro@mero.com")).thenReturn(false);
        when(employeeRepository.existsByDni("12345678A")).thenReturn(false);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        
        // Act
        Employee created = employeeService.create(employee);
        
        // Assert
        assertNotNull(created);
        assertEquals("Alvaro", created.getName());
        assertEquals("Mero", created.getLastname());
        assertEquals("12345678A", created.getDni());
        assertEquals("Alvaro@mero.com", created.getEmail());
    }
    
    @Test
    void testCreateEmployeeWithExistingEmail() {
        // Arrange
        Employee employee = new Employee();
        employee.setEmail("Alvaro@mero.com");
        
        when(employeeRepository.existsByEmail("Alvaro@mero.com")).thenReturn(true);
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            employeeService.create(employee);
        });
    }
    
    @Test
    void testCreateEmployeeWithExistingDni() {
        // Arrange
        Employee employee = new Employee();
        employee.setDni("12345678A");
        
        when(employeeRepository.existsByEmail(any())).thenReturn(false);
        when(employeeRepository.existsByDni("12345678A")).thenReturn(true);
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            employeeService.create(employee);
        });
    }
} 