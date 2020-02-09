package com.company.wages.calculation.system.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 员工福利j计算工具类
 *
 * @author hy
 */
public class EmpWelfareUtil {

    /**
     * 计算员工生日福利类
     *
     * @param date
     * @return
     */
    public static double birthdayWelfareUtil(Date date) {
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        if (currentMonth == month) {
            return 100.00;
        }
        return 0;
    }

    /**
     * 计算员工正确的生日福利
     * @param month
     * @param date
     * @return
     */
    public static double birthdayWelfareUtilDate(String month, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        if (currentMonth == Integer.parseInt(month)) {
            return 100.00;
        }
        return 0;
    }
}
