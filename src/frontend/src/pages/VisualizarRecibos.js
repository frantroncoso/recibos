import React, {useEffect, useState} from 'react'; 
import axios from 'axios';
import DatosEmpresa from '../components/PaginaVisualizarRecibos/DatosEmpresa';
import DatosUsuario from '../components/PaginaVisualizarRecibos/DatosUsuario';
import RecibosUsuario from '../components/PaginaVisualizarRecibos/RecibosUsuario';
function Visualizar(){

    
    const [usuario, setUsuario] = useState([]);
    useEffect(() => {
        const fetchData = async () => { 
            const usuarioAPI = await  axios('http://localhost:8080/getUserById?userId=' + 1);
            setUsuario(usuarioAPI.data); 
           /* const recibosAPI = await  axios('http://localhost:8080/getRecibosByUserId?userId=' + 1);
            setRecibos(recibosAPI.data); */
            axios.get('http://localhost:8080/getRecibosByUserId?userId=' + 1)
            .then((res) => {
                /*const myBlob = res.data[1];
                
                const myFile = new File([myBlob], 'carlos.png', {
                    type: "image/png",
                });
                console.log(res.data[1]);
                const imagenElement = document.getElementById("imagen");
                const imag = URL.createObjectURL(myFile);
                console.log(myBlob instanceof Blob) 
               
                console.log(imag);
                 
                 imagenElement.setAttribute("src", imag);*/

                //const imagenElement = document.getElementById("imagen");  
               
                //imagenElement.setAttribute("src", "../Captura.PNG"); 
            }) 
            
             
            
        }
        fetchData();
    },[])
    return(
        <>
            <DatosUsuario usuario = {usuario}/>  
            <DatosEmpresa usuario = {usuario}/>  
            <img src={require("../archivos/Captura.PNG").default} class="img-fluid" alt=""/>
            <RecibosUsuario/>
            
        </>
            );
}


export default Visualizar;