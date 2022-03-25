package com.example.demo.vo;

import com.example.demo.models.User;

import javax.swing.text.Document;

public class ReciboVO {

    private Integer idRecibo;
    private String url;
    private Integer userId;
    private  int mes;
    private  int año;

    public ReciboVO(Integer idRecibo, String url, Integer userId, int mes, int año){
        this.idRecibo = idRecibo;
        this.url = url;
        this.userId = userId;
        this.mes = mes;
        this.año = año;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Integer idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getRecibo() {
        return url;
    }

    public void setRecibo(String url) {
        this.url = url;
    }
}
