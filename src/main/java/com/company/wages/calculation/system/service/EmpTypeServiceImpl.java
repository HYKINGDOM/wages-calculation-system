package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.constant.EmpHourWageConstant.*;
import static com.company.wages.calculation.system.constant.EmpHourWageConstant.HOURLY_WAGE;
import static com.company.wages.calculation.system.constant.EmpSalaryWageConstant.FIXED_WAGES;
import static com.company.wages.calculation.system.constant.EmpSaleWageConstant.*;
import static com.company.wages.calculation.system.constant.EmpSaleWageConstant.FIXED_SALE_WAGES_ROYALTY_RATE_02;
import static com.company.wages.calculation.system.util.EmpWagesUtil.birthdayWelfareUtilDate;

/**
 * 员工类型
 *
 * @author hy
 */
public enum EmpTypeServiceImpl implements EmpTypeService {

    /**
     * 固定工资员工
     */
    salary {
        /**
         *  固定工资人员计算
         * @param month 工资月份
         * @param employee  固定工资人员
         * @return 计算所得工资
         */
        @Override
        public double employeeTypeWageCalculation(Integer month, Employee employee) {
            return birthdayWelfareUtilDate(month, employee.getBirthday()) + FIXED_WAGES;
        }
    },

    /**
     * 小时工
     */
    hour {
        /**
         * 小时工工资计算
         * @param month 工资月份
         * @param employee 小时工人员
         * @return 计算所的工资
         */
        @Override
        public double employeeTypeWageCalculation(Integer month, Employee employee) {
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
    },
    /**
     * 销售人员
     */
    sale {
        /**
         *  销售人员工资计算
         * @param month 工资月份
         * @param employee 销售人员
         * @return 计算所的工资
         */
        @Override
        public double employeeTypeWageCalculation(Integer month, Employee employee) {
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
    };
}
