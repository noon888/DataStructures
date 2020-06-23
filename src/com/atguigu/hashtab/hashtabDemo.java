package com.atguigu.hashtab;

/**
 * @Author: Administrator
 * @DATE:2020/6/22 21:15
 */
public class hashtabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        hashTab.addEmp(new Emp(18, "小猫"));
        hashTab.addEmp(new Emp(2, "小猴"));
        hashTab.addEmp(new Emp(3, "小猴1"));
        hashTab.addEmp(new Emp(4, "小猴2"));
        hashTab.addEmp(new Emp(5, "小猴3"));
        hashTab.addEmp(new Emp(6, "小猴4"));
        hashTab.addEmp(new Emp(7, "小猴5"));
        hashTab.addEmp(new Emp(8, "小猴6"));
        hashTab.addEmp(new Emp(9, "小猴7"));
        hashTab.addEmp(new Emp(10, "小猴8"));
        hashTab.list();
        hashTab.findEmpByid(10);
        hashTab.delEmp(10);
        hashTab.delEmp(7);
        hashTab.delEmp(3);
        System.out.println("================================================================");
        hashTab.list();
    }
}
