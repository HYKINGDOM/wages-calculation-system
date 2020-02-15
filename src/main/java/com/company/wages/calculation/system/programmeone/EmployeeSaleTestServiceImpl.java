package com.company.wages.calculation.system.programmeone;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.constant.EmpSaleWageConstant.*;
import static com.company.wages.calculation.system.constant.EmpSaleWageConstant.FIXED_SALE_WAGES_ROYALTY_RATE_02;
import static com.company.wages.calculation.system.util.EmpWagesUtil.birthdayWelfareUtilDate;

public class EmployeeSaleTestServiceImpl implements EmployeeTestService {
    @Override
    public double caluWageEmp(Integer month, Employee employee) {
        double amountWage = birthdayWelfareUtilDate(month, employee.getBirthday());
        double amount = employee.getAmount();

        if (amount <= FIXED_SALE_VOLUME_WAGES_01) {
            amountWage = FIXED_SALE_BASE_WAGES;
        } else if (FIXED_SALE_VOLUME_WAGES_01 < amount && amount <= FIXED_SALE_VOLUME_WAGES_02) {
            amountWage = FIXED_SALE_BASE_WAGES + (amount - FIXED_SALE_VOLUME_WAGES_01) * FIXED_SALE_WAGES_ROYALTY_RATE_01;
        } else if (amount > FIXED_SALE_VOLUME_WAGES_02) {
            amountWage = FIXED_SALE_BASE_WAGES + (amount - FIXED_SALE_VOLUME_WAGES_01) * FIXED_SALE_WAGES_ROYALTY_RATE_02;
        }
        return amountWage;
    }
}
