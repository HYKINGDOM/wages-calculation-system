package com.company.wages.calculation.system.type;

import com.company.wages.calculation.system.domain.Employee;

public interface EmployeeTypeService {

    /**
     * 计算员工类型方法
     * @param month
     * @return
     */
    double employeeTypeWageCalculation(String month, Employee employeeType);
}
