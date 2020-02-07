package com.company.wages.calculation.system.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * 公共方法工具类
 * @author hy
 */
public class CommonUtils {

    /**
     * 格式化时间
     */
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * double 四舍五入保留两位小数
     * @return
     */
    public static double doubleKeepTwoDecimalPlaces(double amount){
        BigDecimal bigDecimal = new BigDecimal(amount);
        amount = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return amount;
    }
}
