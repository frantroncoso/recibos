import React, {useEffect, useState} from 'react'; 
import axios from 'axios';
import DatosEmpresa from '../components/PaginaVisualizarRecibos/DatosEmpresa';
import DatosUsuario from '../components/PaginaVisualizarRecibos/DatosUsuario';
function Visualizar(){

    
    const [usuario, setUsuario] = useState([]);

    useEffect(() => {
        const fetchData = async () => { 
            const usuarioAPI = await  axios('http://localhost:8080/getUserById?userId=' + 1);
            setUsuario(usuarioAPI.data); 
        }
        fetchData();
    },[])
    console.log(usuario);
    return(
        <>
            <DatosUsuario usuario = {usuario}/>  
            <DatosEmpresa usuario = {usuario}/>  
        </>
            );
}


export default Visualizar;