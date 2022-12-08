import React from "react";
import FormRegister from "../../components/FormRegister";
import { Link } from 'react-router-dom'


const Register = () => {
    return (
        <>
        <Link to="/Home">
            <p className="linkForm">VOLVER</p>
        </Link>
        <div className="background">
            <FormRegister />
        </div>
        </>
    )
  }
  
  export default Register