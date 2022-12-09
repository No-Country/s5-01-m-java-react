import React from "react";
import logo from '../assets/img/LOGO.png'
import '../pages/projects/projects.css';
import BtnRed from "./buttons/BtnRed";

export default function FormProjects() {
    return (
        <div className="containerRegister">

            <div>
                <img src={logo} alt="Logo" className="imageLogo" />
            </div>

            <div>
                <p className="textRegister">¿Quieres mostrar tu proyecto?</p>
                <p className="data ">Completa los datos del proyecto.</p>
            </div>

            <div className="containerForm">
                <label htmlFor="">nombre del proyecto</label>
                <input type="text" className="margin" placeholder="4JUNIORS "/>
                <label htmlFor="">tipo de proyecto</label>
                <select className="margin">
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                </select>
                <label htmlFor="">stack del proyecto</label>
                <select className="margin">
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                    <option value=""></option>
                </select>
                <label htmlFor="">e-mails de integrantes</label>
                <input type="text" className="margin" placeholder="johndoe@gmail.com" required/>
                <label htmlFor="">descripcion</label>
                <textarea type="text" className="margin" placeholder="¿Qué busca solucionar tu proyecto o cuál es su objetivo?"/>
                <label htmlFor="">link al deploy del proyecto</label>
                <input type="text" className="margin" placeholder="https://www.vercel.com/4juniors"/>
                <label htmlFor="">cargar imagen del proyecto</label>
                <input type="file" className="margin"/>

                <div className='btnRed'>
                    <BtnRed label='SUBE TU PROYECTO' color='#F62223' width='180px'/>
                </div>
            </div>

        </div>
    )
}