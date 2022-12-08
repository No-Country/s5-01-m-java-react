import React from "react";
import FormProjects from "../../components/FormProjects";
import { Link } from 'react-router-dom'


const Projects = () => {
    return (
        <>
        <Link to="/Home">
            <p className="linkForm">VOLVER</p>
        </Link>
        <div className="background">
            <FormProjects/>
        </div>
        </>
    )
  }
  
  export default Projects