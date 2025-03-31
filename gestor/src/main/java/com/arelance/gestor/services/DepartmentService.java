package com.arelance.gestor.services;

import com.arelance.gestor.entities.Department;
import com.arelance.gestor.exceptions.DepartmentNotFoundException;
import com.arelance.gestor.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll (){
        return departmentRepository.findAll();
    }

    public Department findById(Long id){
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    public Department create( @RequestBody @Valid Department department) {

        // Comprobar si el nombre del departamento ya existe
        if (departmentRepository.existsByName(department.getName())) {
            throw new IllegalArgumentException("Department already exists");
        }

        return departmentRepository.save(department);
    }

    public Department update(@RequestBody @Valid Department departmentDetails, Long id) {
        // Buscar el departamento y lanzar excepción si no existe
        Department department = findById(id);
        // verificar si el nombre del departamento ya existe
        if (!department.getName().equals(departmentDetails.getName()) &&
            departmentRepository.existsByName(departmentDetails.getName())) {
            throw new IllegalArgumentException("Department name already exists");
        }

        // Actualizar el nombre del departamento
        department.setName(departmentDetails.getName());

        // Guardar los cambios en la base de datos
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        // Comprobar si existe el departamento con el id
        Department department = findById(id);

        departmentRepository.delete(department);
    }
}
