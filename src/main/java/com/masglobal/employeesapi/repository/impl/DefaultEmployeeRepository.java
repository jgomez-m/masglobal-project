package com.masglobal.employeesapi.repository.impl;

import com.masglobal.employeesapi.model.EmployeeDTO;
import com.masglobal.employeesapi.model.EmployeeResponse;
import com.masglobal.employeesapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class DefaultEmployeeRepository implements EmployeeRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<EmployeeResponse> findAll() {
        //EmployeeDTO[] response = restTemplate.getForObject(
        //"http://masglobaltestapi.azurewbsites.net/api/employees", EmployeeDTO[].class);
        EmployeeResponse emp1 = new EmployeeResponse();
        emp1.setId(1);
        emp1.setName("Juan");
        emp1.setContractTypeName("HourlySalaryEmployee");
        emp1.setRoleId(1);
        emp1.setRoleName("Admin");
        emp1.setHourlySalary(60000D);
        emp1.setMonthlySalary(80000D);
        EmployeeResponse emp2 = new EmployeeResponse();
        emp2.setId(2);
        emp2.setName("Sebastian");
        emp2.setContractTypeName("MonthlySalaryEmployee");
        emp2.setRoleId(2);
        emp2.setRoleName("Contractor");
        emp2.setHourlySalary(60000D);
        emp2.setMonthlySalary(80000D);
        return Arrays.asList(emp1, emp2);
    }
}
