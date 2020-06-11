package com.net.entity;

public class InstruUsers {
    private Integer id;
    private Integer usersId;

    private String usersname;

    private String pwd;

    private Integer role;

    private String tel;

    private Integer sex;

    private String userscreate_time;

    private String stopstate;

    private Integer instruid;
    private String instruname;//仪器或零件名称
    private String instrucreate_time;//创建时间
    private String wastage;//损耗度
    private Integer count;//数量
    private String state;//零件仪器：0：零件，1：仪器
    private Integer employ;//总调用
    private Integer beingused;//正在调用数量
    private String yesno;//是否调用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public String getUserscreate_time() {
        return userscreate_time;
    }

    public void setUserscreate_time(String userscreate_time) {
        this.userscreate_time = userscreate_time;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getStopstate() {
        return stopstate;
    }

    public void setStopstate(String stopstate) {
        this.stopstate = stopstate;
    }

    public Integer getInstruid() {
        return instruid;
    }

    public void setInstruid(Integer instruid) {
        this.instruid = instruid;
    }

    public String getInstruname() {
        return instruname;
    }

    public void setInstruname(String instruname) {
        this.instruname = instruname;
    }

    public String getInstrucreate_time() {
        return instrucreate_time;
    }

    public void setInstrucreate_time(String instrucreate_time) {
        this.instrucreate_time = instrucreate_time;
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

    public String getYesno() {
        return yesno;
    }

    public void setYesno(String yesno) {
        this.yesno = yesno;
    }
}
