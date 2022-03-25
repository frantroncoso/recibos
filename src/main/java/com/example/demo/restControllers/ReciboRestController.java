package com.example.demo.restControllers;

import com.example.demo.controladores.ReciboController;
import com.example.demo.controladores.UserController;
import com.example.demo.models.Recibo;
import com.example.demo.service.UploadFileService;
import com.example.demo.vo.ReciboVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.print.Doc;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class ReciboRestController {

    private static ReciboRestController instancia;
    @Autowired
    private UploadFileService uploadFileService = new UploadFileService();

    private  ReciboRestController(){}

    public static ReciboRestController getInstancia(){
        if (instancia == null){
            instancia = new ReciboRestController();
        }
        return instancia;
    }

    @RequestMapping("/getRecibosByUserId")
    public List<ReciboVO> getRecibosByUserId(@RequestParam(name="userId") int userId) throws Exception {
        return ReciboController.getInstancia().getRecivosByIdUser(userId);
    }

    @PostMapping("/subirRecibo")
    public void subirRecibo(@RequestParam("file")MultipartFile file, @RequestParam(name="userId") int userId) throws Exception {
        if(!file.isEmpty()){


           try {
                String url = uploadFileService.saveFile(file);
                int mes = LocalDate.now().getMonthValue();
                int año = LocalDate.now().getYear();
                ReciboController.getInstancia().crearRecibo(url, userId, mes, año);
            }
           catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
