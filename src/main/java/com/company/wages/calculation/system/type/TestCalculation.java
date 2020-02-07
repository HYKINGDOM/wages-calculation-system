package com.company.wages.calculation.system.type;

import com.company.wages.calculation.system.domain.Employee;
import com.company.wages.calculation.system.util.ReaderXmlFileUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.company.wages.calculation.system.util.CommonUtils.doubleKeepTwoDecimalPlaces;


/**
 * 进阶版的计算方法
 * @author hy
 */
public class TestCalculation {

    public static void main(String[] args) {
        ReaderXmlFileUtil readerXmlFileUtil = new ReaderXmlFileUtil();
        Map<String, List<Employee>> listMap = readerXmlFileUtil.readerXmlFile();
        Set<Map.Entry<String, List<Employee>>> entries = listMap.entrySet();
        double amount = 0.00;

        for (Map.Entry<String, List<Employee>> entry : entries) {
            List<Employee> value = entry.getValue();
            for (Employee employee : value) {
                String type = employee.getType().trim();
                amount = amount + EmployeeTypeServiceImpl.valueOf(type).employeeTypeWageCalculation(type, employee);
            }
        }
        System.out.println("9月和10月份，公司应支付员工工资总额为:" + doubleKeepTwoDecimalPlaces(amount));
    }
}
