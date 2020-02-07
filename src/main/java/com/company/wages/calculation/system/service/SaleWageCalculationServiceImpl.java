package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.util.EmpWelfareUtil.birthdayWelfareUtil;
import static com.company.wages.calculation.system.constant.SaleEmpWageConstant.*;

/**
 * 销售人员工资
 *
 * @author hy
 */
public class SaleWageCalculationServiceImpl implements WageCalculationService {

    @Override
    public double employeeWageCalculation(Employee employee) {
        double amountWage = birthdayWelfareUtil(employee.getBirthday());
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
