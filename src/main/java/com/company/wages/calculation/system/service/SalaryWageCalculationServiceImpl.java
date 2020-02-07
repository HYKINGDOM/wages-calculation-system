package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.util.EmpWelfareUtil.birthdayWelfareUtil;
import static com.company.wages.calculation.system.constant.SalaryEmpWageConstant.FIXED_WAGES;

/**
 *
 * 计算固定工资的员工工资
 * @author hy
 */
public class SalaryWageCalculationServiceImpl implements WageCalculationService {

    @Override
    public double employeeWageCalculation(Employee employee) {
        return birthdayWelfareUtil(employee.getBirthday()) + FIXED_WAGES;
    }
}
