package com.company.wages.calculation.system.util;

import com.company.wages.calculation.system.domain.Employee;
import com.company.wages.calculation.system.domain.EmployeeTotal;
import com.company.wages.calculation.system.service.EmpTypeServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.company.wages.calculation.system.util.CommonUtils.doubleKeepTwoDecimalPlaces;

/**
 * 员工福利j计算工具类
 *
 * @author hy
 */
public class EmpWagesUtil {

    /**
     * 计算员工薪资方法
     * @param listMap
     * @return
     */
    public static double empWagesCount(List<EmployeeTotal> listMap) {
        double amount = 0;
        for (EmployeeTotal employeeTotal : listMap) {
            List<Employee> employeeList = employeeTotal.getEmployeeList();
            for (Employee employee : employeeList) {
                amount += EmpTypeServiceImpl.valueOf(employee.getType()).employeeTypeWageCalculation(employeeTotal.getMonth(), employee);
            }
        }
        return doubleKeepTwoDecimalPlaces(amount);
    }


    /**
     * 计算员工在数据中的生日福利
     *
     * @param month
     * @param date
     * @return
     */
    public static double birthdayWelfareUtilDate(Integer month, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        if (currentMonth == month) {
            return 100;
        }
        return 0;
    }

}
