import React from 'react'; 
import DatosEmpresa from '../components/PaginaVisualizarRecibos/DatosEmpresa';
import DatosUsuario from '../components/PaginaVisualizarRecibos/DatosUsuario';
function Visualizar(){
    return(
        <>
            <DatosUsuario/>  
            <DatosEmpresa/>  

             
        </>
            );
}


export default Visualizar;