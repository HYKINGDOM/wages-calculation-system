package com.company.wages.calculation.system.service;

import com.company.wages.calculation.system.domain.Employee;

/**
 * @author hy
 */
public interface EmpTypeService {

    /**
     * 根据不同胡员工类型计算员工薪资
     * @param month 工资月份
     * @param employeeType 员工数据
     * @return 返回工资
     */
    double employeeTypeWageCalculation(Integer month, Employee employeeType);
}
