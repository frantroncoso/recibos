import React from 'react'; 

function DatosEmpresa(caracteristicas){

    

    return(
        <>
            {/*
             <h2>INCREXA CHILE S.R.L.</h2>
             <p>numeroLegajo</p>
             <p>fechaIngreso</p>
             <p>Número de Legajo</p>
             <p>FechaIngreso: </p>
             <p>Desempeña tareas en INCREXA</p>
             <p>ubicacionEmpresa</p>
             <p>Ingreso: fechaIngreso</p>
    <p>Categoría: categoria</p>*/}
             <div class="empresa noshow" id="seccionEmpresa">
                <h1>Informacion Empresa</h1>
                <h2>Payment Method</h2>
                <p>Mastercard •••• •••• •••• 0000 <button class="btn">update</button></p>
                <h2>Billing Address</h2>
                <p>1234 Example Ave | Seattle, WA <button class="btn">change</button></p>
                <h2>Zipcode</h2>
                <p>999000</p>
                <h2>Billing History</h2>
                <p>2018<button class="btn">view</button></p>
                <h2>Redeem Gift Subscription </h2>
                <p><input type="text" placeholder="Enter Gift Code"></input> <button class="btn">Redeem</button></p>
                </div>
        </>
            );
}


export default DatosEmpresa;