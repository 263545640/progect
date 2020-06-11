package com.example.progect.commin;

public class ResultBeanFactory {

    private final static int FAIL = 0;

    private final static int SUCCESS = 1;

    private final static int UNLOGIN = -200;

    private final static String FAIL_MSG = "fail";

    private final static String SUCCESS_MSG = "success";

    public static ResultBean success() {
        return new ResultBean(SUCCESS, SUCCESS_MSG);
    }

    public static ResultBean success(Object data) {return new ResultBean(SUCCESS, SUCCESS_MSG, data);}

    public static ResultBean success(String msg) {
        return new ResultBean(SUCCESS, msg, null);
    }

    public static ResultBean success(String msg, Object data) {
        return new ResultBean(SUCCESS, msg, data);
    }

    public static ResultBean fail() {
        return new ResultBean(FAIL, FAIL_MSG);
    }

    public static ResultBean fail(String msg) {
        return new ResultBean(FAIL, msg, null);
    }

    public static ResultBean unlogin(String msg) {
        return new ResultBean(UNLOGIN, msg, null);
    }
}
