## 某公司工资计算系统

#### 题目内容

某公司有三种类型的雇工， 不同类型的员工有不同的工资计算方式， 具体如下。 另外该公司有一种福利，如果该月员工过生日，则公司会额外奖励100元。

* 固定工资的员工，每月固定工资为6000元。
* 小时工，每小时薪资为35元。每月工作160小时，超出部分薪资按照1.3倍发放。
* 销售人员， 基础工资为每月3000，每月基础销售额应为20000，如果销售额为20000-30000，则超出部分（超出20000部分）提成率为5%，如果销售额为30000及以上，则超出部分（超出20000部分）提成率为8%。
请注意，员工的固定工资，时薪，提成率和底薪都可能会调整。


#### 思路
* 读取XML文件中的数据
* 定义员工实体类和员工类型的枚举类
* 各个员工类型实现接口的形式,来创建属于各个不同类型员工的工资计算方法
* 各个员工类型的工资计算方法中,定义为常量,去掉代码中的魔法值也便于修改
* 定义员工生日计算方法
* 最后计算所得总数四舍五入保留两位小数


#### 员工数据
请设计程序解析以下xml数据，并计算9月和10月份，公司应支付员工工资总额。最终结果应该四舍五入为两位小数。
```
<department>

              <month value="9">

                             <employee name="xiao wang" type="salary" birthday="1990-10-11" /> 

                             <employee name="xiao zhang" type="hour" workingHours="170.5" birthday="1990-11-11"/>           

                             <employee name="xiao hong" type="sale" amount ="34100.8" birthday="1990-12-11"/>

              </month>

              <month value="10">

                             <employee name="xiao wang" type="salary" birthday="1990-10-11" />

                             <employee name="xiao zhang" type="hour" workingHours ="155.75" birthday="1990-11-11"/>

                             <employee name="xiao hong" type="sale" amount ="23500.7" birthday="1990-12-11"/>

<employee name="xiao liu" type=" hour " workingHours ="188.25" birthday="1989-10-11"/>

              </month>

</department>
```