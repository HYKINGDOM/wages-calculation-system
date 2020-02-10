package com.company.wages.calculation.system;

import com.company.wages.calculation.system.domain.Employee;
import com.company.wages.calculation.system.domain.EmployeeTotal;
import com.company.wages.calculation.system.service.EmpTypeServiceImpl;
import com.company.wages.calculation.system.util.ReaderXmlFileUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.company.wages.calculation.system.util.CommonUtils.doubleKeepTwoDecimalPlaces;
import static com.company.wages.calculation.system.util.EmpWagesUtil.empWagesCount;

/**
 * 主类
 *
 * @author hy
 */
public class CalculationMain {


    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        ReaderXmlFileUtil readerXmlFileUtil = new ReaderXmlFileUtil();
        List<EmployeeTotal> listMap = readerXmlFileUtil.readerXmlFile();
        double empWagesCount = empWagesCount(listMap);
        System.out.println("9月和10月份，公司应支付员工工资总额为:" + empWagesCount);
    }
}
