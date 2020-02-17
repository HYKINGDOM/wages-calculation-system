package com.company.wages.calculation.system.demo.programmeone;

import com.company.wages.calculation.system.domain.Employee;

import static com.company.wages.calculation.system.constant.EmpSalaryWageConstant.FIXED_WAGES;
import static com.company.wages.calculation.system.util.EmpWagesUtil.birthdayWelfareUtilDate;

public class EmployeeSalayTestServiceImpl implements EmployeeTestService {
    @Override
    public double caluWageEmp(Integer month, Employee employee) {
        return birthdayWelfareUtilDate(month, employee.getBirthday()) + FIXED_WAGES;
    }
}
