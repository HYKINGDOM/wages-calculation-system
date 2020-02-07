package com.company.wages.calculation.system.util;

import com.company.wages.calculation.system.domain.Employee;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.text.ParseException;
import java.util.*;

import static com.company.wages.calculation.system.util.CommonUtils.SIMPLE_DATE_FORMAT;

/**
 * 读取XML文件工具类
 *
 * @author hy
 */
public class ReaderXmlFileUtil {

    /**
     * 读取XML文件,组装返回读取数据
     *
     * @return
     */
    public Map<String, List<Employee>> readerXmlFile() {
        SAXReader saxReader = new SAXReader();
        Map<String, List<Employee>> listMap = new HashMap<>();
        try {
            //读取xml文件，并生成document对象 现可通过document来操作文档
            Document document = saxReader.read("src/main/resources/department.xml");
            Element rootElement = document.getRootElement();
            //获取子节点列表
            Iterator it = rootElement.elementIterator();
            while (it.hasNext()) {
                Element fistChild = (Element) it.next();
                //获取节点的属性值
                String valueMonth = fistChild.attribute("value").getValue();
                //获取子节点的下一级节点
                Iterator iterator = fistChild.elementIterator();
                List<Employee> employeeList = new ArrayList<>();
                while (iterator.hasNext()) {
                    Employee employee = new Employee();
                    Element element = (Element) iterator.next();
                    employee.setName(element.attributeValue("name"));
                    employee.setBirthday(SIMPLE_DATE_FORMAT.parse(element.attributeValue("birthday")));
                    String type = element.attributeValue("type");
                    employee.setType(type);
                    if (EmployeeType.sale.toString().equals(type)) {
                        employee.setAmount(Double.parseDouble(element.attributeValue("amount")));
                    }
                    if (EmployeeType.hour.toString().equals(type)) {
                        employee.setWorkingHours(Double.parseDouble(element.attributeValue("workingHours")));
                    }
                    employeeList.add(employee);
                }
                listMap.put(valueMonth, employeeList);
            }
        } catch (DocumentException | ParseException e) {
            e.printStackTrace();
        }
        return listMap;
    }
}
