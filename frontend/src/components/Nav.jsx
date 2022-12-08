import React from "react";
import { NavLink } from 'react-router-dom'
import Headroom from "react-headroom";
import "bootswatch/dist/lux/bootstrap.min.css";
import logo from '../assets/img/logoLarge.png'
import BtnOutline from "./buttons/BtnOutline";
import BtnRed from "./buttons/BtnRed";
import './nav.css'


export default function Nav() {
    return (
        <>
            <Headroom>
                <nav className="navbar active navbar-expand-lg p-2" >
                    <div className="container-fluid  ">
                        <div className="container d-flex justify-content-between ">
                            <div>
                                <NavLink className="nav-link" to="/home"><img src={logo} alt="logo" width="40%" /></NavLink>
                            </div>

                            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon" />
                            </button>
                        </div>

                        <div className="collapse navbar-collapse bgNav" id="navbarTogglerDemo02">
                            <ul className="navbar-nav align-items-center">
                                <li className="nav-item">
                                    <NavLink to="/home" className="nav-link color ">Proyectos</NavLink>
                                </li>
                                {/* <li className="nav-item align-items-center">
                                    <NavLink to="/home" className="nav-link">Home</NavLink>
                                </li> */}
                                <li className="nav-item">
                                    <NavLink to="/detail" className="nav-link color detail">Detail</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink to="/login" className="nav-link"><BtnOutline label='Inicia Sesion' color='#F62223' width="145px"/></NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink to="/register" className="nav-link"><BtnRed label='Registrate' color='#F62223'/></NavLink>
                                </li>

                            </ul>

                        </div>
                    </div>
                </nav>
            </Headroom>


        </>
    )
}