package com.example.demo.restControllers;

import com.example.demo.controladores.ReciboController;
import com.example.demo.models.Recibo;
import com.example.demo.vo.ReciboVO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class ReciboRestController {

    private static ReciboRestController instancia;

    private  ReciboRestController(){}

    public static ReciboRestController getInstancia(){
        if (instancia == null){
            instancia = new ReciboRestController();
        }
        return instancia;
    }

    @RequestMapping("/getRecibosByUserId")
    public List<ReciboVO> getRecibosByUserId(@RequestParam(name="userId") int userId) throws Exception {
        return ReciboController.getInstancia().getTurnosByIdUser(userId);
    }

    @PostMapping("/crearRecibo")
    public void crearRecibo(@RequestParam(name="userId") int userId) throws Exception {

    }
}
