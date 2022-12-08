import React from "react";
import FormLogin from "../../components/FormLogin";
import './forms.css';
import { Link } from 'react-router-dom'


const Login = () => {
    return (
        <>
        <Link to="/Home">
            <p className="linkForm">VOLVER</p>
        </Link>
        <div className="background">
            <FormLogin />
        </div>
        </>
    )
  }
  
  export default Login