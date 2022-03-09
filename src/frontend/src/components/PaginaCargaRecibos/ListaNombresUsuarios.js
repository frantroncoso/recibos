import React, {useState, useEffect} from 'react';
import axios from 'axios';

function ListaNombresUsuarios(caracteristicas){
    const [tiposEstudios, setTiposEstudios] = useState([]);

    useEffect(() => {
        const fetchData = async () => { 
            //const tiposTurnosAPI = await  axios('http://localhost:8080/getAllTiposEstudio');
            setTiposEstudios(tiposTurnosAPI.data);
        }
        fetchData();
    },[])
    
    function cambioSelect(){
        var tipoTurno = document.getElementById("nombreUsuario");
        var strUser = tipoTurno.options[tipoTurno.selectedIndex].text;
        /*if(!caracteristicas.esAdmin){
            caracteristicas.setNombreAnalisis(strUser);
            caracteristicas.setTipoAnalisis(tipoTurno.value);
        }*/
    }    
    
    return(     

        <select id="nombreUsuario" class="form-select" aria-label="Default select example" onChange={cambioSelect}>
            <option value="-1"selected  >Seleccione el tipo de estudio</option>

            {tiposEstudios.map(function(tipoTurno){
                return(
                    <option value={tipoTurno.id} label={tipoTurno.nombre}>{tipoTurno.nombre}</option>
                )
            })}

        </select>

     );
}


export default ListaNombresUsuarios;