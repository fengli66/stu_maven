package com.lifeng.pojo;

import java.io.Serializable;

/**
 * student实体类
 *
 * @author fengli
 * @version 1.0
 * @date 2020/11/05
 */
public class Student implements Serializable {
    private Integer id; //学生id
    private String name;//学生姓名
    private byte sex;//学生性别
    private double score;//分数
    private String image;//图片

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
