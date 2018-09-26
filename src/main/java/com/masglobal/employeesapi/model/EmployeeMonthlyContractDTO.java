package com.masglobal.employeesapi.model;

public class EmployeeMonthlyContractDTO extends EmployeeDTO{


    @Override
    public Double getAnnualSalary() {
        return getMonthlySalary() * 12;
    }
}
