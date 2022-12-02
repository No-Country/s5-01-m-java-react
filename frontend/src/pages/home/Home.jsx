import React from 'react'
import Nav from '../../components/Nav'
import './home.css'
import title from '../../assets/img/heroTitle1.svg'
import rectangle from '../../assets/img/box-image.svg'
import "bootswatch/dist/lux/bootstrap.min.css";
import BtnRed from '../../components/buttons/BtnRed'
import { Link } from 'react-router-dom'
import ItemProjectContainer from '../../components/Proyectos/ItemProjectContainer'

const Home = () => {
  return (
    <>
      <div className='Color-Header'>
        <Nav />
        <header className='container-fluid'>
          <div className='header'>
            <div>
              <h1 className='title'>Muestra tu Proyecto!</h1>
              <p className='paragraph'>Muestra tu proyecto en la comunidad y califica los proyectos de otros Juniors.</p>
            </div>
            <div className='title-image'>
              <img src={title} alt="Title" width="54" />
            </div>
            <div>
              <img src={rectangle} alt="Imagen" height="400" />
            </div>
          </div>
          <div className='align-projects'>
            <Link to="/Projects">
              <BtnRed color='#F62223' width="200px" label='Sube tu Proyecto' />
            </Link>
          </div>
        </header>
      </div>
      <div>
        <h1>Proyectos</h1>
      </div>
      <div>
      <h2>Proyectos Destacados</h2>

      </div>
      <div>
          <ItemProjectContainer/>
      </div>
    </>
  )
}

export default Home
