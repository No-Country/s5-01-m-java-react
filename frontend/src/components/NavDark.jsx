import React from "react";
import { NavLink } from 'react-router-dom'
import Headroom from "react-headroom";
import "bootswatch/dist/lux/bootstrap.min.css";
import logo from '../assets/img/LOGO-LARGE-BLACK.svg'
import BtnOutline from "./buttons/BtnOutline";
import BtnRed from "./buttons/BtnRed";
import { useSelector } from 'react-redux'
import './nav.css'


const NavDark = () => {
    const { list: user } = useSelector(state => state.user)
    // let userDataLocal = JSON.parse(localStorage.getItem('userDataLocal')) 
    
    
    return (
        <>
            <Headroom>
                <nav className="navbar navbar-expand-lg navbar-dark " >

                    <div className="container-fluid  ">
                        <div className="container d-flex justify-content-between ">
                            <div>
                                <NavLink className="nav-link" to="/home"><img src={logo} alt="logo" width="80%" /></NavLink>
                            </div>

                            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon" />
                            </button>
                        </div>

                        <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                            <ul className="navbar-nav align-items-center">
                                <li className="nav-item ">
                                    <NavLink to="/home" className="nav-link color fw-bold">Proyectos</NavLink>
                                </li>
                               


                                {
                                    user != ""  ? <li className="nav-item"><h4 className="text-white">{user.username}</h4></li> :
                                        <>
                                            <li className="nav-item">
                                                <NavLink to="/login" className="nav-link"><BtnOutline label='Inicia Sesion' color='#F62223' width='145px' /></NavLink>
                                            </li>
                                            <li className="nav-item">
                                                <NavLink to="/register" className="nav-link"><BtnRed label='Registrate' color='#F62223' /></NavLink>
                                            </li>
                                        </>
                                }
                            </ul>
                        </div>
                    </div>
                </nav>
            </Headroom>
        </>
    )
}

export default NavDark