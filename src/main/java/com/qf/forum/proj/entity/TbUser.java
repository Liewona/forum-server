package com.qf.forum.proj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author FPF
 * @since 2020-11-03
 */
@TableName("TB_USER")
public class TbUser extends Model<TbUser> {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId("ID")
    private Integer id;

    /**
     * 用户昵称
     */
    @TableField("UNAME")
    private String uname;

    /**
     * 手机号
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 注册时间
     */
    @TableField("REGISTER_TIME")
    private String registerTime;

    /**
     * 年龄
     */
    @TableField("AGE")
    private Integer age;

    /**
     * 性别
     */
    @TableField("SEX")
    private String sex;

    /**
     * 图片地址
     */
    @TableField("IMG")
    private String img;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbUser{" +
        "id=" + id +
        ", uname=" + uname +
        ", phone=" + phone +
        ", registerTime=" + registerTime +
        ", age=" + age +
        ", sex=" + sex +
        ", img=" + img +
        "}";
    }
}
