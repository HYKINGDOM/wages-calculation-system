package com.company.wages.calculation.system.programmeone;

import com.company.wages.calculation.system.programmeone.demo.*;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorEmpFactory {

    static Map<String, EmployeeTestService> employeeTestServiceMap = new HashMap<>();

    static {
        employeeTestServiceMap.put("sale", new EmployeeSaleTestServiceImpl());
        employeeTestServiceMap.put("hour", new EmployeeHourTestServiceImpl());
        employeeTestServiceMap.put("salary", new EmployeeSalayTestServiceImpl());
    }


    public static EmployeeTestService getEmpWage(String optional) {
        return employeeTestServiceMap.get(optional);
    }

//    static Map<String, EmployeeTestService> operationMap = new HashMap<>();
//
//    static {
//        operationMap.put("hour", new EmployeeHourTestServiceImpl());
//        operationMap.put("salay", new EmployeeSalayTestServiceImpl());
//        operationMap.put("sale", new EmployeeSaleTestServiceImpl());
//    }
//
//    public static Optional<EmployeeTestService> getOperation(String operation) {
//        return Optional.ofNullable(operationMap.get(operation));
//    }
}
