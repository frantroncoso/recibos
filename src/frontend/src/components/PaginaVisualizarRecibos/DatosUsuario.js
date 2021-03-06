import React from 'react'; 

function DatosUsuario(caracteristicas){ 

    const calcularEdad  = (fechaNacimiento) => {
        const fechaActual = new Date();
        const anoActual = parseInt(fechaActual.getFullYear());
        const mesActual = parseInt(fechaActual.getMonth()) + 1;
        const diaActual = parseInt(fechaActual.getDate());
        
        const anoNacimiento = fechaNacimiento.getFullYear();
        const mesNacimiento = fechaNacimiento.getMonth() ;
        const diaNacimiento = fechaNacimiento.getDate() + 1;

        let edad = anoActual - anoNacimiento;
        if (mesActual < mesNacimiento) {
            edad--;
        } else if (mesActual === mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad--;
            }
        }
        return edad;
    };
     
    let fechaNacimiento = "";
    let edad = 0;

    if(caracteristicas.usuario.dni !=  null){ 
        const date = new Date(caracteristicas.usuario.fechaNac);
        edad = calcularEdad(date);
        date.setDate(date.getDate() + 1);    
        
        fechaNacimiento = new Intl.DateTimeFormat('es-ES', {day: 'numeric' ,month: 'long', year: 'numeric'}).format(date);
        const fechaActual = new Date();
    } 
    return(
        <>
            
            <div class="profile" id="seccionUsuario">
                <h1>Informacion Personal</h1>
                <h2>Full Name</h2>
                <p>{caracteristicas.usuario.apellido}, {caracteristicas.usuario.nombre}, {edad}</p>
                <h2>Birthday</h2>
                <p>July 12, 2000</p>
                <h2>Gender</h2>
                <p>Male<button class="btn">update</button></p>
                <h2>Document</h2>
                <p>42720030</p>
                <h2>Email </h2>
                <p>m4nuelcastellano@gmail.com </p>
                {/*<h1>{caracteristicas.usuario.apellido}, {caracteristicas.usuario.nombre}, {edad} años </h1>
                <p>Avenida Dr. Honorio Pueyrredón - Lote 206. 5500 Pilar Buenos Aires Argentina </p>
                <p>Documento: {caracteristicas.usuario.dni}</p>
                <p>Fecha Nacimiento: {fechaNacimiento}</p>
                <p>Nacionalidad: nacionalidad</p>
                <p>Estado Civil: {caracteristicas.usuario.estadoCivil}</p>
                <p>Mail: {caracteristicas.usuario.mail}</p>
            <p>Teléfono: {caracteristicas.usuario.telefono}</p>*/}
            </div>
             

             
        </>
    );
}


export default DatosUsuario;