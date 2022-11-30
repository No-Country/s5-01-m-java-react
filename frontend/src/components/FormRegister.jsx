import React from "react";
import logo from '../assets/img/LOGO.png'
import '../pages/register/register.css';
import BtnRed from "./buttons/BtnRed";

export default function FormRegister() {
    return (
        <div className="containerRegister">

            <div>
                <img src={logo} alt="Logo" className="imageLogo" />
            </div>

            <div>
                <p className="textRegister">¿Eres nuevo por aquí?</p>
                <p className="data">Completa tus datos.</p>
            </div>

            <div className="containerForm">
                <label htmlFor="">nombre</label>
                <input type="text" className="margin" placeholder="John "/>
                <label htmlFor="">apellido</label>
                <input type="text" className="margin"placeholder="Doe"/>
                <label htmlFor="">portfolio</label>
                <input type="url" className="margin" placeholder="https://www.behance.net/johndoe"/>
                <label htmlFor="">lorem</label>
                <input type="text" className="margin"/>
                <label htmlFor="">lorem</label>
                <input type="text" className="margin"/>
                <label htmlFor="">lorem</label>
                <input type="text" className="margin"/>
                <label htmlFor="">e-mail</label>
                <input type="email" className="margin" placeholder="johndoe@gmail.com"/>
                <label htmlFor="">contraseña</label>
                <input type="password" />
                <div className="passwordRegister">
                    <p>La constraseña debe tener al menos 8 <br /> caracteres.</p> 
                </div>
                <label htmlFor="">repetir contraseña</label>
                <input type="password" className="margin"/>

                <div className='btnRed'>
                    <BtnRed label='REGISTRARSE' color='#F62223' width='160px'/>
                </div>
            </div>

        </div>
    )
}