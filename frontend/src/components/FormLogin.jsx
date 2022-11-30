import React from "react";
import logo from '../assets/img/LOGO.png'
import '../pages/login/login.css';
import BtnRed from "./buttons/BtnRed";

export default function FormLogin() {
    return (
        <div className="containerLogin">

            <div>
                <img src={logo} alt="Logo" className="imageLogo" />
            </div>

            <div>
                <p className="textLogin">¿De vuelta por aquí?</p>
                <p className="data">Ingresa con tus datos.</p>
            </div>

            <div className="containerForm">
                <label htmlFor="">e-mail</label>
                <input type="email" className="margin" placeholder="johndoe@gmail.com"/>
                <label htmlFor="">contraseña</label>
                <input type="password" />
                <div className="passwordLogin">
                    <p>¿Perdiste tu contraseña?</p> 
                    <a href="#">TOCA AQUI</a>
                </div>

                <div className='btnRed'>
                    <BtnRed label='INGRESAR' color='#F62223' width='140px'/>
                </div>
            </div>

        </div>
    )
}