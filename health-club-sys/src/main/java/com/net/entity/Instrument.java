package com.net.entity;

public class Instrument {
    private Integer id;
    private String name;//仪器或零件名称
    private String create_time;//创建时间
    private String wastage;//损耗度
    private Integer count;//数量
    private String state;//零件仪器：0：零件，1：仪器
    private Integer employ;//总调用
    private Integer beingused;//正在调用数量
    private Integer usersId;//用户id
    private String yesno;//是否调用
    private Integer tranId;//关联表id
    private String msg;//提示

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTranId() {
        return tranId;
    }

    public void setTranId(Integer tranId) {
        this.tranId = tranId;
    }

    public String getYesno() {
        return yesno;
    }

    public void setYesno(String yesno) {
        this.yesno = yesno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getWastage() {
        return wastage;
    }

    public void setWastage(String wastage) {
        this.wastage = wastage;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getEmploy() {
        return employ;
    }

    public void setEmploy(Integer employ) {
        this.employ = employ;
    }

    public Integer getBeingused() {
        return beingused;
    }

    public void setBeingused(Integer beingused) {
        this.beingused = beingused;
    }
}
