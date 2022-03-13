import React, {useState, useEffect} from 'react';
import axios from 'axios';

function ListaNombresUsuarios(){
    const [usuarios, setUsuarios] = useState([]);
    useEffect(() => {
        const fetchData = async () => { 
            const usuariosAPI = await  axios('http://localhost:8080/getAllUsuarios');
            setUsuarios(usuariosAPI.data);
        }
        fetchData();
    },[])
    
    function cambioSelect(){
        //var usuarioSeleccionado = document.getElementById("nombreUsuario");
        //var strUser = usuarioSeleccionado.options[usuarioSeleccionado.selectedIndex].text;
         
    }    
    
    return(     

        <select id="nombreUsuario" class="form-select" aria-label="Default select example" onChange={cambioSelect}>
            <option value="-1"selected  >Seleccione el empleado</option>

            {usuarios.map(function(usuario){
                return(
                    <option value={usuario.id} label={usuario.apellido + ", " + usuario.nombre}>{usuario.apellido + ", " + usuario.nombre}</option>
                )
            })}

        </select>

     );
}


export default ListaNombresUsuarios;