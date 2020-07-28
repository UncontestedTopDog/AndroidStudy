package com.edu.lib;

public class Student implements Cloneable {

    // 对象引用
    private Subject subj;

    private String name;

    public Student(String s, String sub) {
        name = s;
        subj = new Subject(sub);
    }

    public Subject getSubj() {
        return subj;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    // /**
    //  *  重写clone()方法
    //  * @return
    //  */
    // public Object clone() {
    //     //浅拷贝
    //     try {
    //         // 直接调用父类的clone()方法
    //         return super.clone();
    //     } catch (CloneNotSupportedException e) {
    //         return null;
    //     }
    // }

    public Object clone() {
        Student s = new Student(name,subj.getName());
        return s;
    }
}