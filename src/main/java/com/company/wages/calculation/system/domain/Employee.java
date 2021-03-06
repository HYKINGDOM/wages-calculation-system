package com.company.wages.calculation.system.domain;

import java.util.Date;

/**
 * 员工实体类
 * @author hy
 */
public class Employee {

    /**
     *  员工姓名
     */
    private String name;

    /**
     * 员工类型
     */
    private String type;

    /**
     * 员工工时
     */
    private double workingHours;

    /**
     * 销售总额
     */
    private double amount;

    /**
     *  员工生日
     */
    private Date birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
