package com.example.demo.vo;

import javax.swing.text.Document;

public class ReciboVO {

    private Integer idRecibo;
    private Document recibo;

    public ReciboVO(Integer idRecibo, Document recibo){
        this.idRecibo = idRecibo;
        this.recibo = recibo;
    }

    public Integer getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Integer idRecibo) {
        this.idRecibo = idRecibo;
    }

    public Document getRecibo() {
        return recibo;
    }

    public void setRecibo(Document recibo) {
        this.recibo = recibo;
    }
}
