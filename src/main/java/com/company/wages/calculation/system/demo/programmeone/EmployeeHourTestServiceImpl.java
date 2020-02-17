package com.company.wages.calculation.system.demo.programmeone;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.constant.EmpHourWageConstant.*;
import static com.company.wages.calculation.system.constant.EmpHourWageConstant.HOURLY_WAGE;
import static com.company.wages.calculation.system.util.EmpWagesUtil.birthdayWelfareUtilDate;

public class EmployeeHourTestServiceImpl implements EmployeeTestService {
    @Override
    public double caluWageEmp(Integer month, Employee employee) {
        double amount = birthdayWelfareUtilDate(month, employee.getBirthday());
        double workingHours = employee.getWorkingHours();
        double exceedingTime = workingHours - FIXED_HOURLY_WAGE;
        if (exceedingTime > 0) {
            amount = FIXED_HOURLY_WAGE * HOURLY_WAGE + exceedingTime * (HOURLY_WAGE * EXCEED_HOURLY_WAGE);
        } else if (exceedingTime <= 0) {
            amount = workingHours * HOURLY_WAGE;
        }
        return amount;
    }
}
