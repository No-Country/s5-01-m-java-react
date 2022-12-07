import React from "react";
import logo from '../assets/img/LOGO.png'
import '../pages/register/register.css';
import BtnRed from "./buttons/BtnRed";
import axios from "axios";
import { useState } from "react";

export default function FormRegister() { 
    const url = 'https://s5-01-m-java-react-production.up.railway.app/auth/signup'
    const [data, setData] = useState({
        email:"",
        password:"",
        name:"",
        lastname:"",
        profile:"",
        stack:"",
        portfolio:"",
        experience:""
    })

    function submit(e){
        e.preventDefault();
        axios.post(url,{
            email:data.email,
            password:data.password,
            name:data.name,
            lastname:data.lastname,
            profile:data.profile,
            stack:data.stack,
            portfolio:data.portfolio,
            experience:data.experience
        })
        .then(res =>{
            console.log(res.data)
        })
    }

    function handle(e){
        const newData= {...data}
        newData[e.target.id] = e.target.value
        setData(newData)
        console.log(newData)
    }
    

    return (
        <div className="containerRegister">

            <div>
                <img src={logo} alt="Logo" className="imageLogo" />
            </div>

            <div>
                <p className="textRegister">¿Eres nuevo por aquí?</p>
                <p className="data">Completa tus datos.</p>
            </div>
        <form onSubmit={(e) => submit(e)}>
            <div className="containerForm">
                <label htmlFor="">nombre</label>
                <input onChange={(e)=>handle(e)} id="name" value={data.name} type="text" className="margin" placeholder="John " />
                <label htmlFor="">apellido</label>
                <input onChange={(e)=>handle(e)} id="lastname" value={data.lastname}  type="text" className="margin"placeholder="Doe"/>
                <label htmlFor="">portfolio</label>
                <input onChange={(e)=>handle(e)} id="portfolio" value={data.portfolio} type="url" className="margin" placeholder="https://www.behance.net/johndoe"/>
                <label htmlFor="">perfil</label>
                <input onChange={(e)=>handle(e)} id="profile" value={data.profile} type="text" className="margin"/>
                <label htmlFor="">experiencia</label>
                <input onChange={(e)=>handle(e)} id="experience" value={data.experience} type="text" className="margin"/>
                <label htmlFor="">stack de tecnologias</label>
                <input onChange={(e)=>handle(e)} id="stack" value={data.stack} type="text" className="margin"/>
                <label htmlFor="">e-mail</label>
                <input onChange={(e)=>handle(e)} id="email" value={data.email}  type="email" className="margin" placeholder="johndoe@gmail.com"/>
                <label htmlFor="">contraseña</label>
                <input onChange={(e)=>handle(e)} id="password" value={data.password} type="password" />
                <div className="passwordRegister">
                    <p>La constraseña debe tener al menos 8 <br /> caracteres.</p> 
                </div>
                <label htmlFor="">repetir contraseña</label>
                <input onChange={(e)=>handle(e)} id="password" value={data.password}  type="password" className="margin"/>

                <div className='btnRed'>
                    <BtnRed label='REGISTRARSE' color='#F62223' width='160px' />
                </div>
            </div>
        </form>

        </div>

    )
}