import React from 'react'
import Header from '../../components/Header';
import "bootswatch/dist/lux/bootstrap.min.css";
import logo from '../../assets/img/LOGO.png'
import './detail.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStar } from '@fortawesome/free-regular-svg-icons'



const Detail = () => {
  return (
    <>
      <Header />
      <div className="container mt-5">
        <div className="row">
          <div className="col-2 d-flex justify-content-end">
            <h1 className='titulo'>JUNIORS</h1>
          </div>
          <div className="col-5 bg-primary border d-flex justify-content-center align-items-center">
            <img src={logo} alt="logo" width="100%" />

          </div>
          <div className="col-5 d-flex flex-column justify-content-between">
            <h1>Lorem, ipsum</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus, odit. Hic expedita vero porro cumque inventore, quo totam minima omnis repudiandae sed a maiores assumenda.</p>
            <div className='d-flex justify-content-between align-items-center'>
              <button type="button" className="btn btn-outline-primary">Primary</button>
              <div className='d-flex align-items-center'>
                <h1 className='mg m-0'>5</h1>

                <FontAwesomeIcon icon={faStar} className="fs-1" />
              </div>

            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Detail
