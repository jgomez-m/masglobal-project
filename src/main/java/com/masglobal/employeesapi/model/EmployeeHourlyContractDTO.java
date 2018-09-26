package com.masglobal.employeesapi.model;

public class EmployeeHourlyContractDTO extends EmployeeDTO{


    @Override
    public Double getAnnualSalary() {
        return 120 * getHourlySalary() * 12;
    }
}
