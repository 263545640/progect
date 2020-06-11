package com.example.progect.commin;

public class ResultBean {

    private String msg;

    private Integer code;

    private Object data;

    private String Info;

    public ResultBean() {}

    public ResultBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(Integer code, String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
