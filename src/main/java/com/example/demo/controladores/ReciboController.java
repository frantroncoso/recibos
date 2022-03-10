package com.example.demo.controladores;

import com.example.demo.daos.ReciboDAO;
import com.example.demo.daos.UserDAO;
import com.example.demo.models.Recibo;
import com.example.demo.models.User;
import com.example.demo.vo.ReciboVO;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class ReciboController {
    private  static  ReciboController instancia;

    private ReciboController(){}

    public static ReciboController getInstancia(){
        if (instancia == null){
            instancia = new ReciboController();
        }
        return instancia;
    }

    public  void  crearRecibo(int idRecibo, Document pdfRecibo) throws Exception{
        Recibo recibo = new Recibo(idRecibo, pdfRecibo);
        recibo.save();
    }

    public void eliminarRecibo(int idRecibo) throws Exception {
        Recibo recibo = ReciboDAO.getInstancia().getReciboById(idRecibo);
        recibo.delete();
    }

    public List<ReciboVO> getTurnosByIdUser(int idUser) throws Exception {
        User user = UserDAO.getInstancia().getUserById(idUser);
        List<Recibo> recibos = user.getMisRecibos();
        List<ReciboVO> recibosVO = new ArrayList<ReciboVO>();
        for (Recibo recibo : recibos){
            recibosVO.add(recibo.toVO());
        }
        return recibosVO;
    }

}
