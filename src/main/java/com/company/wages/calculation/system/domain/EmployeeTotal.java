package com.company.wages.calculation.system.domain;

import java.util.List;

/**
 * 员工按月统计总量
 *
 * @author hy
 */
public class EmployeeTotal {

    /**
     * 工资月份
     */
    private Integer month;

    /**
     *  员工数据
     */
    private List<Employee> employeeList;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
