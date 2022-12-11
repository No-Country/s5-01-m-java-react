import React from "react";
import { NavLink } from 'react-router-dom'
import Headroom from "react-headroom";
import "bootswatch/dist/lux/bootstrap.min.css";
import logo from '../assets/img/logoLarge.png'
import BtnOutline from "./buttons/BtnOutline";
import BtnRed from "./buttons/BtnRed";
import './nav.css'
import { useSelector } from 'react-redux'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faStar, faRightFromBracket} from '@fortawesome/free-solid-svg-icons'



export default function Nav() {
    const { list: user } = useSelector(state => state.user)
   // let userDataLocal = JSON.parse(localStorage.getItem('userDataLocal')) 


 

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
                                
                                {
                                     user != "" ? <><li className="nav-item"><h4 className="">{user.username}</h4></li></> :
                                    // user != "" ? <><li className="nav-item"><h4 className="">{userDataLocal.username}</h4></li><li> <FontAwesomeIcon icon={faRightFromBracket} className="text-black fs-2" onClick={logout}/></li></> :
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