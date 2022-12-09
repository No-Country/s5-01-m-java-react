import React from "react";
import BtnOutline from "./buttons/BtnOutline";
import BtnRed from "./buttons/BtnRed";
import CloseButton from "../assets/img/CloseButton.png"
import './modal.css'
import { NavLink } from 'react-router-dom'

const Modal = ({ open, onClose }) => {
    if (!open) return null
    return (

        <div className="overlay">
            <div className="modalContainer">
                <div className="closeButtonContainer">
                    <img className="imgCloseButton" src={CloseButton} alt="" onClick={onClose} />
                </div>
                <p className="modalP">¡Ingresa para mostrar <br />tu proyecto y calificar el <br /> de otros juniors!</p>
                <div className="row">
                    <NavLink to="/login" className="nav-link col-6 "><BtnOutline label='Inicia Sesion' color='#F62223' width='145px' /></NavLink>
                    <NavLink to="/register" className="nav-link col-6"><BtnRed label='Registrate' color='#F62223' /></NavLink>
                </div>
            </div>
        </div>

    )
}

export default Modal;