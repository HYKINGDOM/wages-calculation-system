package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

/**
 * 工资计算接口
 * @author hy
 */
public interface WageCalculationService {

    /**
     * 计算工资
     * @param employee
     * @return
     */
    double employeeWageCalculation(Employee employee);
}
