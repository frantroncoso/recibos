import React from 'react'; 
import axios from 'axios';
import ListaNombresUsuarios from '../components/PaginaCargaRecibos/ListaNombresUsuarios';
function Carga(){

    const submitForm = () => {
        
        console.log("G");
        const formData = new FormData();
        formData.append("name", "hola");
        
        var selectedFile = document.getElementById("formFile").files[0];
        formData.append("file", selectedFile);
        axios
          .post('http://localhost:8080/', formData)
          .then((res) => {
            alert("File Upload success");
          })
          .catch((err) => alert("File Upload Error"));
        
        console.log(formData.get('file')) ;
        /*const imagenElement = document.getElementById("imagen");
        const imag = URL.createObjectURL(formData.get('file'));
        imagenElement.setAttribute("src", imag);
        const url = URL.createObjectURL(formData.get('file'));
        console.log(url);*/
      };

    return(
        <>
            <div class="m-3"> 
                <input class="form-control mb-3" type="file" id="formFile" on/>
                
            <ListaNombresUsuarios/>
            {/*<img id="imagen"></img>*/}
            <button type="button" class="btn btn-outline-primary mt-3" onClick={submitForm}>Cargar</button>
            </div>
            
        </>
    );
}


export default Carga;