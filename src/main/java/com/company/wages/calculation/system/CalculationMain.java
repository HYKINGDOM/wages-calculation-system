package com.company.wages.calculation.system;

import com.company.wages.calculation.system.domain.Employee;
import com.company.wages.calculation.system.util.EmployeeType;
import com.company.wages.calculation.system.util.ReaderXmlFileUtil;
import com.company.wages.calculation.system.service.HourWageCalculationServiceImpl;
import com.company.wages.calculation.system.service.SalaryWageCalculationServiceImpl;
import com.company.wages.calculation.system.service.SaleWageCalculationServiceImpl;
import com.company.wages.calculation.system.service.WageCalculationService;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.company.wages.calculation.system.util.CommonUtils.doubleKeepTwoDecimalPlaces;

/**
 * 主方法
 *
 * @author hy
 */
public class CalculationMain {

    public static void main(String[] args) {
        ReaderXmlFileUtil readerXmlFileUtil = new ReaderXmlFileUtil();
        Map<String, List<Employee>> listMap = readerXmlFileUtil.readerXmlFile();
        Set<Map.Entry<String, List<Employee>>> entries = listMap.entrySet();

        WageCalculationService saleWageCalculation = new SaleWageCalculationServiceImpl();
        WageCalculationService salaryWageCalculation = new SalaryWageCalculationServiceImpl();
        WageCalculationService hourWageCalculation = new HourWageCalculationServiceImpl();
        double amount = 0.00;
        for (Map.Entry<String, List<Employee>> entry : entries) {
            List<Employee> value = entry.getValue();
            for (Employee employee : value) {
                String type = employee.getType().trim();
                if (EmployeeType.sale.toString().equals(type)) {
                    amount = amount + saleWageCalculation.employeeWageCalculation(employee);
                } else if (EmployeeType.salary.toString().equals(type)) {
                    amount = amount + salaryWageCalculation.employeeWageCalculation(employee);
                } else if (EmployeeType.hour.toString().equals(type)) {
                    amount = amount + hourWageCalculation.employeeWageCalculation(employee);
                }
            }
        }
        System.out.println("9月和10月份，公司应支付员工工资总额为:" + doubleKeepTwoDecimalPlaces(amount));
    }
}
