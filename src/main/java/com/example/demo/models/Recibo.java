package com.example.demo.models;

import com.example.demo.daos.ReciboDAO;
import com.example.demo.vo.ReciboVO;

import javax.persistence.*;
import javax.swing.text.Document;

@Entity
@Table(name="recibos")
public class Recibo {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecibo;
    private Document recibo;

    /*@ManyToOne()
    @JoinColumn(name = "userId")*/

    public Recibo(){}
    public Recibo(Integer idRecibo, Document  recibo){
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

    public void save() throws Exception {
        ReciboDAO.getInstancia().crearRecibo(this);
    }
    public void delete() throws Exception {
        ReciboDAO.getInstancia().eliminarRecibo(this);
    }
    public ReciboVO toVO(){
        return new ReciboVO(this.idRecibo, this.recibo);
    }
}
