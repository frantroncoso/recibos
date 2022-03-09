import React from 'react'; 

function Carga(){
    return(
        <>
            <div class="m-3"> 
                <input class="form-control mb-3" type="file" id="formFile"/>
                <select class="form-select  mb-3" aria-label=".form-select-lg example">
                <option selected>Open this select menu</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            
            <button type="button" class="btn btn-outline-primary">Cargar</button>
            </div>
            
        </>
    );
}


export default Carga;