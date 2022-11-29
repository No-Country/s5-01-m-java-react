import React, { useState } from 'react'
import "bootswatch/dist/lux/bootstrap.min.css";
import './detail.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStar } from '@fortawesome/free-regular-svg-icons'
import NavDark from '../../components/NavDark';
import starLine from '../../assets/img/Star-line.svg'
import starRed from '../../assets/img/Star-red.svg'
import imagenDetail from '../../assets/img/imagenDetail.png'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import BtnOutline from "../../components/buttons/BtnOutline";
import { Rating } from 'react-simple-star-rating'



const Detail = () => {
  const [rating, setRating] = useState(0)
  var settings = {
    dots: true,
    infinite: true,
    slidesToShow: 3,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    pauseOnHover: true
  };

  const handleRating = (rate: number) => {
    setRating(rate)

    // other logic
  }
  // const onPointerEnter = () => console.log('Enter')
  // const onPointerLeave = () => console.log('Leave')
  // const onPointerMove = (value: number, index: number) => console.log(value, index)



  return (
    <>
      <NavDark />
     <div className="container">
     <section className='seccion pb-4'>
        <div className="container">
          <div className="row mx-2 my-3 d-none d-md-flex">
            <div className="col-6 d-flex justify-content-lg-between">
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
            <div className="col-1 justify-content-end d-none d-md-flex">
              <h1 className='titulo titulo-rojo'>JUNIOR</h1>
            </div>
            <div className="col-12 col-md-5 d-flex justify-content-center align-items-center p-0">
              <img src={imagenDetail} alt="logo" className='w-100' />

            </div>
            <div className="col-12 col-md-5 d-flex flex-column  d-flex justify-content-between ps-4">
              <h1 className='text-white'>4JUNIORS</h1>
              <p className='text-white'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus, odit. Hic expedita vero porro cumque inventore, quo totam minima omnis repudiandae sed a maiores assumenda.</p>
              <div className='row justify-content-between align-items-center text-center'>
                <div className='col-12 col-lg-6 px-0 mt-2  d-flex justify-content-center'>
                  <BtnOutline label="LABEL" />
                </div>
                <div className='col-12 col-lg-6 mt-2 d-flex justify-content-center justify-content-lg-start'>
                  <Rating
                  size= {30}
                  allowFraction= {true}
                    onClick={handleRating}
                  // onPointerEnter={onPointerEnter}
                  // onPointerLeave={onPointerLeave}
                  // onPointerMove={onPointerMove}
                  //Available Props
                  />
                  {/* <FontAwesomeIcon icon={faStar} className="fs-1 mg me-2" /> */}
                </div>

              </div>
            </div>
            <div className="col-1 justify-content-end d-none d-md-flex">
              <h1 className='titulo titulo-invertido'>JUNIOR</h1>
            </div>
          </div>
          <div className="row mx-2 my-3 d-none d-md-flex">
            <div className="col-6 d-flex align-items-center">
              <img src={starLine} alt="logo" />
              <h1 className='titulo-abajo ms-4'>MADE</h1>
            </div>
            <div className="col-6  d-flex justify-content-lg-between">
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
          <Slider {...settings} className="mt-5" >
            <div>
              <div className="cuadro-rojo p-3 d-flex flex-column align-items-center mx-4 text-center">
                <h2 className='text-center text-white mb-3'>FRONTEND</h2>
                <h3 className='text-center text-white mb-3'>Flor</h3>
                <a href="#" className='link-portfolio'>Ver portfolio</a>
              </div>
            </div>
            <div>
              <div className="cuadro-rojo p-3 d-flex flex-column align-items-center mx-4 text-center">
                <h2 className='text-center text-white mb-3'>DISEÑO</h2>
                <h3 className='text-center text-white mb-3'>Joaquín</h3>
                <a href="#" className='link-portfolio'>Ver portfolio</a>
              </div>
            </div>
            <div>
              <div className="cuadro-rojo p-3 d-flex flex-column align-items-center mx-4 text-center">
                <h2 className='text-center text-white mb-3'>BACKEND</h2>
                <h3 className='text-center text-white mb-3'>Los pibes</h3>
                <a href="#" className='link-portfolio'>Ver portfolio</a>
              </div>
            </div>
            <div>
              <div className="cuadro-rojo p-3 d-flex flex-column align-items-center mx-4 text-center">
                <h2 className='text-center text-white mb-3'>TESTING</h2>
                <h3 className='text-center text-white mb-3'>Pamela</h3>
                <a href="#" className='link-portfolio'>Ver portfolio</a>
              </div>
            </div>


            {/* <div className="cuadro-rojo p-3 d-flex flex-column align-items-center">
                    <h2 className='text-center text-white mb-3'>DISEÑO DE PRODUCTO</h2>
                    <h3 className='text-center text-white mb-3'>Joaquín Accorsi</h3>
                    <a href="#" className='link-portfolio'>Ver portfolio</a>
                  </div> */}
          </Slider>


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
                  <div className="col-4 d-flex justify-content-center"><BtnOutline label="LABEL" /></div>
                  <div className="col-4 d-flex justify-content-center"><BtnOutline label="LABEL" /></div>
                  <div className="col-4 d-flex justify-content-center"><BtnOutline label="LABEL" /></div>

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
     </div>

    </>
  )
}

export default Detail
