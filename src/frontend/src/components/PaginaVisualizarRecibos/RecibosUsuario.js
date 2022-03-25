import React, {useEffect, useState} from 'react'; 
import "../../css/recibosUsuario.css"
import axios from 'axios'; 
function RecibosUsuario(){
 
    const [recibos, setRecibos] = useState([]);
    useEffect(() => {
        const fetchData = async () => { 
            const recibosAPI = await  axios('http://localhost:8080/getRecibosByUserId?userId=' + 1);
            setRecibos(recibosAPI.data);
            console.log(recibosAPI.data);
        }
        fetchData();
    },[])
    
    function convertir(numeroMes) {
        var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
        return(meses[numeroMes - 1]);
}
    console.log(recibos);
    return(
        <> 
            <div class="recibos noshow" id="seccionRecibos">
                <h1>Mis Recibos</h1>
                <ul class="list-group mx-3">
                    {recibos.map(function(recibo){  
                        return(
                            
                            <a href={require("../../archivos/" + recibo.url )} target="_blank"><li class="list-group-item">{convertir(recibo.mes) + "  -  "  +  recibo.año}</li></a>
                        ) 
                    })}
                </ul>   
            </div>
        </>
            );
}


export default RecibosUsuario;