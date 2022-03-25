import React, {useState} from 'react'; 
import axios from 'axios';
import ListaNombresUsuarios from '../components/PaginaCargaRecibos/ListaNombresUsuarios';
function Carga(){

    const [usuarioSeleccionado, setUsuarioSeleccionado] = useState(-1);

    const submitForm = () => {
        
        console.log("G");
        const formData = new FormData();
        formData.append("name", "hola");
        var config = { headers: {'Content-Type': 'multipart/form-data'} };
        var selectedFile = document.getElementById("formFile").files[0];
        formData.append("file", selectedFile);
        //axios.post("http://localhost:8080/subirRecibo?file="+ selectedFile)
        if(usuarioSeleccionado != -1){
        axios
          .post(' http://localhost:8080/subirRecibo?userId=' + usuarioSeleccionado, formData, config)
          .then((res) => {
            alert("File Upload success");
          })
          .catch((err) => alert("File Upload Error"));
       
       
        console.log(formData.get('file')) ;
      }
        /*fetch('/subirRecibo',{
          method: 'POST',
          body: formData,
        })*/
        /*const imagenElement = document.getElementById("imagen");
        const imag = URL.createObjectURL(formData.get('file'));
        imagenElement.setAttribute("src", imag);
        const url = URL.createObjectURL(formData.get('file'));
        console.log(url);*/
      };
      console.log(usuarioSeleccionado);
    return(
        <>{/*
            <form method="post" th:action="@{/upload}" enctype="multipart/form-data" id="fileUploadForm" class="container">
              <div class="form-group">
                <label class="custom-file" id="customFile">
                  <input type="file" class="custom-file-input" name='file' aria-describedby='fileHelp'></input>
                  <span class= "custom-file-control form-control-file"></span>
                </label>
              </div>
              <div>
                <button type='submit' class="btn btn-success">Enviar</button>
              </div>
            </form>*/}
            <div class="m-3"> 
                <input class="form-control mb-3" type="file" id="formFile" name="file" on/>
              
            <ListaNombresUsuarios setUsuarioSeleccionado = {setUsuarioSeleccionado}/>
            {/*<img id="imagen"></img>*/}
            <button  type="button" class="btn btn-outline-primary mt-3" onClick={submitForm}>Cargar</button>
            </div>
            
        </>
    );
}


export default Carga;