package com.masglobal.employeesapi.utils;

import com.masglobal.employeesapi.model.EmployeeDTO;
import com.masglobal.employeesapi.model.EmployeeHourlyContractDTO;
import com.masglobal.employeesapi.model.EmployeeMonthlyContractDTO;

public class EmployeeFactory {

    public static EmployeeDTO getEmployee(String contractTypeName) {
        if("HourlySalaryEmployee".equalsIgnoreCase(contractTypeName)) {
            return new EmployeeHourlyContractDTO();
        }
        if("MonthlySalaryEmployee".equalsIgnoreCase(contractTypeName)) {
            return new EmployeeMonthlyContractDTO();
        }
        return null;
    }
}
