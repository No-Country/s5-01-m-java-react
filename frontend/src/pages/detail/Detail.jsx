import React from 'react'

import "bootswatch/dist/lux/bootstrap.min.css";
import logo from '../../assets/img/LOGO.png'
import './detail.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStar } from '@fortawesome/free-regular-svg-icons'
import NavDark from '../../components/NavDark';
import starLine from '../../assets/img/Star-line.svg'
import starRed from '../../assets/img/Star-red.svg'
import imagenDetail from '../../assets/img/imagenDetail.png'



const Detail = () => {
  return (
    <>
      <NavDark />
      <section className='seccion pb-4'>
        <div className="container">
          <div className="row mx-2 my-3">
            <div className="col-6 d-flex justify-content-between">
              <img src={starLine} alt="logo" />
              <img src={starLine} alt="logo" />
              <img src={starLine} alt="logo" />
              <img src={starLine} alt="logo" />
            </div>
            <div className="col-6 d-flex flex-row-reverse">
              <img src={starRed} alt="logo" />
              <h1 className='titulo-horizontal  me-4'>MADE</h1>
            </div>
          </div>
          <div className="row">
            <div className="col-1 d-flex justify-content-end">
              <h1 className='titulo titulo-rojo'>JUNIOR</h1>
            </div>
            <div className="col-5 d-flex justify-content-center align-items-center p-0">
              <img src={imagenDetail} alt="logo" className='w-100' />

            </div>
            <div className="col-5 d-flex flex-column justify-content-between ps-4">
              <h1 className='text-white'>4JUNIORS</h1>
              <p className='text-white'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus, odit. Hic expedita vero porro cumque inventore, quo totam minima omnis repudiandae sed a maiores assumenda.</p>
              <div className='d-flex justify-content-between align-items-center'>
                <button type="button" className="btn btn-outline-danger m-0">LABEL</button>
                <div className='d-flex align-items-center'>
                  <h1 className='mg m-0 '>5</h1>

                  <FontAwesomeIcon icon={faStar} className="fs-1 mg me-2" />
                </div>

              </div>
            </div>
            <div className="col-1 d-flex justify-content-end">
              <h1 className='titulo titulo-invertido'>JUNIOR</h1>
            </div>
          </div>
          <div className="row mx-2 my-3">
            <div className="col-6 d-flex align-items-center">
              <img src={starLine} alt="logo" />
              <h1 className='titulo-abajo ms-4'>MADE</h1>
            </div>
            <div className="col-6  d-flex justify-content-between">
              <img src={starRed} alt="logo" />
              <img src={starRed} alt="logo" />
              <img src={starRed} alt="logo" />
              <img src={starRed} alt="logo" />
            </div>
          </div>
        </div>
      </section>
      <section className='seccion py-5'>
        <div className="container">
          <h1 className='text-center text-white'>INTEGRANTES</h1>
          <div className="mt-4 ">
            <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="true">
              <div className="carousel-inner">
                <div className="carousel-item active">
                  <div className="row justify-content-center">
                    <div className="col-6 cuadro-rojo p-3 d-flex flex-column align-items-center">
                      <h2 className='text-center text-white mb-3'>DISEÑO DE PRODUCTO</h2>
                      <h3 className='text-center text-white mb-3'>Joaquín Accorsi</h3>
                      <a href="#" className='link-portfolio'>Ver portfolio</a>
                    </div>
                  </div>
                </div>
                <div className="carousel-item">
                  <div className="row justify-content-center">
                    <div className="col-lg-6 cuadro-rojo p-3 d-flex flex-column align-items-center">
                      <h2 className='text-center text-white mb-3'>FRONTEND</h2>
                      <h3 className='text-center text-white mb-3'>FLOR</h3>
                      <a href="#" className='link-portfolio'>Ver portfolio</a>
                    </div>
                  </div>
                </div>
                <div className="carousel-item">
                  <div className="row justify-content-center">
                    <div className="col-lg-6 cuadro-rojo p-3 d-flex flex-column align-items-center">
                      <h2 className='text-center text-white mb-3'>BACKEND</h2>
                      <h3 className='text-center text-white mb-3'>LOS PIBES</h3>
                      <a href="#" className='link-portfolio'>Ver portfolio</a>
                    </div>
                  </div>
                </div>
              </div>
              <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true" />
                <span className="visually-hidden">Previous</span>
              </button>
              <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true" />
                <span className="visually-hidden">Next</span>
              </button>
            </div>







          </div>
        </div>
      </section>
      <section className='seccion py-5'>
        <div className="container">
          <h1 className='text-center text-white'>STACK DEL PROYECTO</h1>
          <div className="mt-4 ">
            <div className="row">
              <div className="col-1"><img src={starLine} alt="logo" /></div>
              <div className="col-10">
                <div className="row">
                  <div className="col-4 d-flex justify-content-center"><button type="button" className="btn btn-outline-danger m-0">LABEL</button></div>
                  <div className="col-4 d-flex justify-content-center"><button type="button" className="btn btn-outline-danger m-0">LABEL</button></div>
                  <div className="col-4 d-flex justify-content-center"><button type="button" className="btn btn-outline-danger m-0">LABEL</button></div>

                </div>
              </div>
              <div className="col-1"><img src={starLine} alt="logo" /></div>
            </div>
          </div>
        </div>
      </section>
      <section className='seccion py-5'>
        <div className="container">
          <h1 className='text-center text-white'>MIRÁ EL PROYECTO ACÁ</h1>
          <div className="mt-4 ">
            <div className="row">
              <div className="col-1"><img src={starLine} alt="logo" /></div>
              <div className="col-10 d-flex justify-content-center">
                <a href="#" className='link-portfolio'>www.heroku.com/4juniors</a>
              </div>
              <div className="col-1"><img src={starLine} alt="logo" /></div>
            </div>
          </div>
        </div>
      </section>

    </>
  )
}

export default Detail
