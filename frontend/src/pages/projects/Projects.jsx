import React from "react";
import FormProjects from "../../components/FormProjects";
import { Link } from 'react-router-dom'
import BtnOutline from "../../components/buttons/BtnOutline";


const Projects = () => {
    return (
        <>
        <Link to="/Home">
            <BtnOutline label='VOLVER' color='#F62223'/>
        </Link>
        <div className="background">
            <FormProjects/>
        </div>
        </>
    )
  }
  
  export default Projects