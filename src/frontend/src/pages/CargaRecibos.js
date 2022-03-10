import React from 'react'; 
import axios from 'axios';
function Carga(){

    const submitForm = () => {
        
        console.log("G");
        const formData = new FormData();
        formData.append("name", "hola");
        
        var selectedFile = document.getElementById("formFile").files[0];
        formData.append("file", selectedFile);
        axios
          .post('http://localhost:8080/crearRecibo', formData)
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
                <select class="form-select  mb-3" aria-label=".form-select-lg example">
                <option selected>Open this select menu</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            {/*<img id="imagen"></img>*/}
            <button type="button" class="btn btn-outline-primary" onClick={submitForm}>Cargar</button>
            </div>
            
        </>
    );
}


export default Carga;