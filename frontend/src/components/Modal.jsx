import React from "react";
import BtnRed from "./buttons/BtnRed";
import CloseButton from "../assets/img/CloseButton.png"
import './modal.css'
import { Link } from 'react-router-dom'

const Modal = ({open, onClose}) =>{
    if(!open) return null
    return(

        <div className="overlay">
            <div className="modalContainer">
            <div className="closeButtonContainer">
                <img className="imgCloseButton"  src={CloseButton} alt="" onClick={onClose}/>
            </div>
            <p className="closeButtonP">¡Registrate para mostrar <br />tu proyecto y calificar el <br /> de otros juniors!</p>
            <Link to="/Projects">
                <BtnRed color='#F62223' width="200px" label='REGISTRATE' />
            </Link>
            </div>
        </div>

    )
}

export default Modal;