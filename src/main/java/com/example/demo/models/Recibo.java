package com.example.demo.models;

import com.example.demo.daos.ReciboDAO;
import com.example.demo.vo.ReciboVO;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.swing.text.Document;

@Entity
@Table(name="recibos")
public class Recibo {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecibo;
    private  int mes;
    private  int año;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    //@Lob
    private String url;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Recibo(){}
    public Recibo( String url, User user, int mes, int año){
        this.mes = mes;
        this.año = año;
        this.url = url;
        this.user = user;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void save() throws Exception {
        ReciboDAO.getInstancia().crearRecibo(this);
    }
    public void delete() throws Exception {
        ReciboDAO.getInstancia().eliminarRecibo(this);
    }
   public ReciboVO toVO(){
        return new ReciboVO(this.idRecibo, this.url, this.user.getUserId(), this.mes, this.año);
    }
}
