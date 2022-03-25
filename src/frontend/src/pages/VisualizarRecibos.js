import React, {useEffect, useState} from 'react'; 
import axios from 'axios';
import DatosEmpresa from '../components/PaginaVisualizarRecibos/DatosEmpresa';
import DatosUsuario from '../components/PaginaVisualizarRecibos/DatosUsuario';
import RecibosUsuario from '../components/PaginaVisualizarRecibos/RecibosUsuario';
import '../css/style.css';
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

    function visualizarSeccion(idSeccion, idNavSeccion){
        let seccionMostrar = document.getElementById(idSeccion);          
        if (seccionMostrar.classList.contains('noshow')) {
            document.getElementById("seccionRecibos").classList.add('noshow');
            document.getElementById("seccionUsuario").classList.add('noshow');
            document.getElementById("seccionEmpresa").classList.add('noshow');
            seccionMostrar.classList.remove('noshow');
            document.getElementById("recibos").classList.remove('active');
            document.getElementById("profile").classList.remove('active');
            document.getElementById("empresa").classList.remove('active');
            document.getElementById(idNavSeccion).classList.add('active');
        }
    }
    return(
        <>
            <div class="container">
            <div id="logo"><h1 class="logo"></h1>
                <div class="CTA">
                <h1>Increxa</h1>
                </div>
            </div>
            <div class="leftbox">
                <nav>
                <a id="profile" class="active" onClick={()=>visualizarSeccion("seccionUsuario", "profile")}><i class="fa fa-user"></i></a>
                <a id="empresa" onClick={()=>visualizarSeccion("seccionEmpresa", "empresa")}><i class="fa fa-credit-card"></i></a>
                <a id="recibos" onClick={()=>visualizarSeccion("seccionRecibos", "recibos")}><i class="fa fa-tv"></i></a>
                 
                </nav>
            </div>
            <div class="rightbox">
                <DatosUsuario usuario = {usuario}/>  
                <DatosEmpresa usuario = {usuario}/>   
                <RecibosUsuario/>
            </div>
            
            </div>
            <footer>
                <p>made by <a href="https://blueup.com.ar/"> BlueUp</a></p>
            </footer>
        </>
            );
}


export default Visualizar;