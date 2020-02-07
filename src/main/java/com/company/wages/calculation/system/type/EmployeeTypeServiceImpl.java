package com.company.wages.calculation.system.type;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.constant.HourEmpWageConstant.*;
import static com.company.wages.calculation.system.constant.HourEmpWageConstant.HOURLY_WAGE;
import static com.company.wages.calculation.system.constant.SalaryEmpWageConstant.FIXED_WAGES;
import static com.company.wages.calculation.system.constant.SaleEmpWageConstant.*;
import static com.company.wages.calculation.system.constant.SaleEmpWageConstant.FIXED_SALE_WAGES_ROYALTY_RATE_02;
import static com.company.wages.calculation.system.util.EmpWelfareUtil.birthdayWelfareUtil;

/**
 * 员工类型
 *
 * @author hy
 */
public enum EmployeeTypeServiceImpl implements EmployeeTypeService {

    /**
     * 固定工资员工
     */
    salary{
        @Override
        public double employeeTypeWageCalculation(String type, Employee employee) {
            return birthdayWelfareUtil(employee.getBirthday()) + FIXED_WAGES;
        }
    },

    /**
     * 小时工
     */
    hour{
        @Override
        public double employeeTypeWageCalculation(String type, Employee employee) {
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
    },
    /**
     * 销售人员
     */
    sale{
        @Override
        public double employeeTypeWageCalculation(String type, Employee employee) {
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
    };
}
