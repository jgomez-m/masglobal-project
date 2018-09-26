package com.masglobal.employeesapi.service;

import com.masglobal.employeesapi.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Integer id);
}
