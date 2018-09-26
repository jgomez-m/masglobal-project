package com.masglobal.employeesapi.service.impl;

import com.masglobal.employeesapi.model.EmployeeDTO;
import com.masglobal.employeesapi.model.EmployeeResponse;
import com.masglobal.employeesapi.repository.EmployeeRepository;
import com.masglobal.employeesapi.service.EmployeeService;
import com.masglobal.employeesapi.utils.EmployeeFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeResponse> responseList = employeeRepository.findAll();
        List<EmployeeDTO> result = new ArrayList<>();
        for(EmployeeResponse emp : responseList) {
            EmployeeDTO dto = EmployeeFactory.getEmployee(emp.getContractTypeName());
            dto.setName(emp.getName());
            dto.setId(emp.getId());
            dto.setContractTypeName(emp.getContractTypeName());
            dto.setRoleId(emp.getRoleId());
            dto.setRoleName(emp.getRoleName());
            dto.setRoleDescription(emp.getRoleDescription());
            dto.setHourlySalary(emp.getHourlySalary());
            dto.setMonthlySalary(emp.getMonthlySalary());
            dto.setAnnualSalary(dto.getAnnualSalary());
            result.add(dto);
        }
        return result;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        return getAllEmployees().stream().filter(emp -> emp.getId().equals(id))
                .findAny().orElse(null);
    }
}
