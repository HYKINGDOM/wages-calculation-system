package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

/**
 * @author hy
 */
public interface EmpTypeService {

    /**
     * 根据不同胡员工类型计算员工薪资
     * @param month
     * @param employeeType
     * @return
     */
    double employeeTypeWageCalculation(Integer month, Employee employeeType);
}
