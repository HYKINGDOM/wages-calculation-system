package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.util.EmpWelfareUtil.birthdayWelfareUtil;
import static com.company.wages.calculation.system.constant.HourEmpWageConstant.*;

/**
 * 小时工工资计算
 *
 * @author hy
 */
public class HourWageCalculationServiceImpl implements WageCalculationService {
    @Override
    public double employeeWageCalculation(Employee employee) {
        double amount = birthdayWelfareUtil(employee.getBirthday());
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
