import React, { useState } from 'react'
import Nav from '../../components/Nav'
import './home.css'
import title from '../../assets/img/heroTitle1.svg'
import rectangle from '../../assets/img/box-image.svg'
import "bootswatch/dist/lux/bootstrap.min.css";
import BtnRed from '../../components/buttons/BtnRed'
import { Link } from 'react-router-dom'
import ItemProjectContainer from '../../components/Proyectos/ItemProjectContainer'
import ItemProjectContainerRanking from '../../components/Proyectos/ItemProjectContainerRanking'
import Modal from '../../components/Modal';

const Home = () => {
  const [openModal, setOpenModal] = useState(false);
  return (
    <>
      <div className='Color-Header'>
        <Nav />
        <header className='container-fluid'>
          <div className='header'>
            <div>
              <h1 className='title'>MUESTRA TU PROYECTO!</h1>
              <p className='paragraph'>muestra tu proyecto en la comunidad y califica los proyectos de otros Juniors.</p>
            </div>
            <div className='title-image'>
              <img src={title} alt="Title" />
            </div>
            <div className='rectangle'>
              <img src={rectangle} alt="Imagen"/>
            </div>
          </div>
          <div className='align-projects'>
            {/* <Link to="/Projects"> */}
            <BtnRed  color='#F62223' width="150px" label='SUBE TU PROYECTO'
              onClick={() => setOpenModal(true)} />
            {/* </Link> */}
            <Modal open={openModal} onClose={() => setOpenModal(false)} />
          </div>
        </header>
      </div>
      <div className='Title-Project'>
        <h2>Proyectos</h2>
      </div>
      <div className='Border-Destacados'>
        <div className='Title-Destacados'>
          <h3>Proyectos destacados</h3>
          <ItemProjectContainerRanking />
        </div>
      </div>
      <div>
        <ItemProjectContainer />
      </div>
    </>
  )
}

export default Home
