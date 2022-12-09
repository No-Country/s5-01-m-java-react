import React from "react";
import FormRegister from "../../components/FormRegister";
import { Link } from 'react-router-dom';
import BtnOutline from "../../components/buttons/BtnOutline";


const Register = () => {
    return (
        <>
        <Link to="/Home">
            <BtnOutline label='VOLVER' color='#F62223'/>
        </Link>
        <div className="background">
            <FormRegister />
        </div>
        </>
    )
  }
  
  export default Register