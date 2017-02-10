package com.bwie.moon.bean;

/**
 * Created by lenovo on 2017/2/10.
 */

public class Titles {
    private Data data;
    private String message;
    private String status;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
