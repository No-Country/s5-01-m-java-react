import React from "react";
import { NavLink } from 'react-router-dom'
import Headroom from "react-headroom";
import "bootswatch/dist/lux/bootstrap.min.css";
import logo from '../assets/img/LOGO-LARGE-BLACK.svg'


export default function NavDark() {
    return (
        <>
            <Headroom>
                <nav className="navbar navbar-expand-lg navbar-dark bg-transparent" >
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
                                <li className="nav-item align-items-center">
                                    <NavLink to="/home" className="nav-link">Proyectos</NavLink>
                                </li>
                                <li className="nav-item align-items-center">
                                    <NavLink to="/home" className="nav-link">Home</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink to="/detail" className="nav-link">Detail</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink to="/login" className="nav-link">Inicia Sesion</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink to="/register" className="nav-link">Registrate</NavLink>
                                </li>

                            </ul>

                        </div>
                    </div>
                </nav>
            </Headroom>


        </>
    )
}