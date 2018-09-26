package com.masglobal.employeesapi.service.impl;

import com.masglobal.employeesapi.model.EmployeeDTO;
import com.masglobal.employeesapi.model.EmployeeResponse;
import com.masglobal.employeesapi.repository.EmployeeRepository;
import com.masglobal.employeesapi.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void getAllEmployees() {
        // Given
        List<EmployeeResponse> employeesResponse = getEmployees();

        when(employeeRepository.findAll()).thenReturn(employeesResponse);

        // When
        List<EmployeeDTO> result = employeeService.getAllEmployees();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertNotNull(result.get(0).getAnnualSalary());

    }

    @Test
    public void getEmployeeById() {
        // Given
        List<EmployeeResponse> employeesResponse = getEmployees();

        when(employeeRepository.findAll()).thenReturn(employeesResponse);

        // When
        EmployeeDTO result = employeeService.getEmployeeById(1);

        // Then
        assertNotNull(result);
        assertNotNull(result.getAnnualSalary());
        assertEquals(Double.valueOf(120d * 60000d * 12d), result.getAnnualSalary());
    }

    private List<EmployeeResponse> getEmployees() {

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