import React from "react";
import FormLogin from "../../components/FormLogin";
import './forms.css';
import { Link } from 'react-router-dom'
import BtnOutline from "../../components/buttons/BtnOutline";


const Login = () => {
    return (
        <>
        <Link to="/Home">
            <BtnOutline label='VOLVER' color='#F62223'/>
        </Link>
        <div className="background">
            <FormLogin />
        </div>
        </>
    )
  }
  
  export default Login