package com.masglobal.employeesapi.repository;

import com.masglobal.employeesapi.model.EmployeeResponse;

import java.util.List;

public interface EmployeeRepository {

    List<EmployeeResponse> findAll();
}
