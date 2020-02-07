package com.company.wages.calculation.system.type;

import com.company.wages.calculation.system.domain.Employee;

public interface EmployeeTypeService {

    /**
     * 计算员工类型方法
     * @param type
     * @return
     */
    double employeeTypeWageCalculation(String type, Employee employeeType);
}
