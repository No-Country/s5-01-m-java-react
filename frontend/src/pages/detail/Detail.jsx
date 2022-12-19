import React, { useState } from 'react'
import "bootswatch/dist/lux/bootstrap.min.css";
import './detail.css'
import NavDark from '../../components/NavDark';
import starLine from '../../assets/img/Star-line.svg'
import starRed from '../../assets/img/Star-red.svg'
import star1 from '../../assets/img/Star1.svg'
import imagenDetail from '../../assets/img/imagenDetail.png'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import BtnOutline from "../../components/buttons/BtnOutline";
import { Rating } from 'react-simple-star-rating'
import { useSelector } from 'react-redux'
import axios from 'axios';
const baseURL = "https://s5-01-m-java-react-production.up.railway.app/api/projects/";



const Detail = () => {
  //const { list: proyect } = useSelector(state => state.proyect)
  const { list: user } = useSelector(state => state.user)
  const [post, setPost] = React.useState(null);
  const [ready, setReady] = React.useState(false);
  // const proyId = proyect?.id;
  const proyTeam = post?.team;
  
  


  let ProyectID = JSON.parse(localStorage.getItem('setProyectID'))

  React.useEffect(() => {
    axios.get(baseURL + ProyectID).then((response) => {

      setPost(response.data);
      //console.log(response.data)
      setReady(true);

    });
  }, []);



  const [rating, setRating] = useState(0)
  var settings = {
    dots: true,
    infinite: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    pauseOnHover: true
  };

  // const handleRating = (rate) => {
  //   console.log(rate)
  //   axios.post(`https://s5-01-m-java-react-production.up.railway.app/api/projects/${ProyectID}/rating`, {
  //     "rating": 2.5,


  //   })
  //     .then(function (response) {
  //       // console.log(response.data.username);
  //       setRating(rate);

  //       alert("Calificacion registrada!")

  //     })
  //     .catch(function (err) {
  //       console.log("error")
  //       // if (!err?.response) {
  //       //     setErrMsg("No Server Response");
  //       // } else if (err.response?.status === 400) {
  //       //     setErrMsg("Missing Username or Password");
  //       // } else if (err.response?.status === 401) {
  //       //     setErrMsg("Unauthorized");
  //       // } else {
  //       //     setErrMsg("Datos incorrectos");
  //       // }
  //       // errRef.current.focus();
  //     });



  //   //   // other logic
  // }
  // const onPointerEnter = () => console.log('Enter')
  // const onPointerLeave = () => console.log('Leave')
  // const onPointerMove = (value: number, index: number) => console.log(value, index)

  const handleRating = (rate) => {

    const headers = {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + user.token
    };
    console.log(headers.Authorization)

    const data = {
      rating: rate
    };
   

    axios.post(`https://s5-01-m-java-react-production.up.railway.app/api/projects/${ProyectID}/rating`, data, {
      headers: headers
    }).then(response => alert("gracias por su calificación"))
    .catch(error=>{
      //console.log(error.response.status)
      if(error.response.status == 400){
        alert("no puedes calificar tus propios proyectos")
      }else{
        console.log(error)
      }

    } )

  };



  return (
    <>
      <NavDark />

      {
        ready ? <div className="container">
          <section className='seccion pb-4'>
            <div className="container">
              <div className="row my-3 d-none d-md-flex">
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
                <div className="col-1 justify-content-center d-none d-md-flex">
                  <h1 className='titulo titulo-rojo'>JUNIOR</h1>
                </div>
                <div className="col-12 col-md-5 d-flex justify-content-center align-items-center p-0">
                  <img src={post?.image} alt="logo" className='w-100' />


                </div>
                <div className="col-12 col-md-5 d-flex flex-column  d-flex justify-content-between ps-4">
                  <h1 className='text-white text-center text-md-start mt-3'>{post?.name}</h1>
                  <p className='text-white text-center text-md-start'>{post?.description}</p>
                  <div className='row justify-content-between align-items-center text-center'>
                    <div className='col-12 col-lg-6 px-0 mt-2  d-flex justify-content-center'>
                      <BtnOutline label="LABEL" />
                    </div>
                    <div className='col-12 col-lg-6 mt-2 d-flex justify-content-center justify-content-lg-start align-items-bottom'>
                      <h1 className='text-white calificationNumber'>{post?.rating}</h1>
                      {/* <FontAwesomeIcon icon={faStar} className="fs-1 mg me-2" /> */}
                      <img src={star1} alt="logo" className='ms-2 calificationStar' />
                    </div>


                  </div>
                </div>
                <div className="col-1 justify-content-center d-none d-md-flex">
                  <h1 className='titulo titulo-invertido'>JUNIOR</h1>
                </div>
              </div>
              <div className="row  my-3 d-none d-md-flex">
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
            <div className="row justify-content-center">
              <div className="col d-flex flex-column align-items-center">
                <h1 className='text-center text-white my-4'>Califica este proyecto</h1>
                <Rating
                  size={50}
                  allowFraction={true}
                  onClick={handleRating}
                  transition={true}
                  fillColor={'#F84E4F'}
                // onPointerEnter={onPointerEnter}
                // onPointerLeave={onPointerLeave}
                // onPointerMove={onPointerMove}
                //Available Props
                />
              </div>
            </div>
          </section>
          <section className='seccion py-5'>
            <div className="container">
              <h1 className='text-center text-white'>INTEGRANTES</h1>

              <Slider {...settings} className="mt-5 d-flex" >
                {

                  proyTeam.map((e) => 
                    
                    <div className='cuadro'>
                      <div className="cuadro-rojo p-3 d-flex flex-column align-items-center mx-4 text-center w-50">
                        <h2 className='text-center text-white mb-3 text-uppercase'>{e.profile}</h2>
                        <h3 className='text-center text-white mb-3'>{e.name} {e.lastname}</h3>
                        <a href="#" className='link-portfolio'>{e.portfolio}</a>
                      </div>
                    </div>

                  )

                }
              </Slider>
            </div>
          </section>
          <section className='seccion py-5'>
            <div className="container">
              <h1 className='text-center text-white'>STACK DEL PROYECTO</h1>
              <div className="mt-4 ">
                <div className="row">
                  <div className="d-none d-md-flex col-1"><img src={starLine} alt="logo" /></div>
                  <div className="col-10">
                    <div className="row">

                      <div className="col-12 col-md-4 d-flex justify-content-center mt-2"><BtnOutline label={post?.stack.tech1} /></div>
                      <div className="col-12 col-md-4 d-flex justify-content-center mt-2"><BtnOutline label={post?.stack.tech2} /></div>

                    </div>
                  </div>
                  <div className="d-none d-md-flex col-1"><img src={starLine} alt="logo" /></div>
                </div>
              </div>
            </div>
          </section>
          <section className='seccion py-5'>
            <div className="container">
              <h1 className='text-center text-white'>MIRÁ EL PROYECTO ACÁ</h1>
              <div className="mt-4 ">
                <div className="row">
                  <div className="d-none d-md-flex col-1"><img src={starLine} alt="logo" /></div>
                  <div className="col-12 col-md-10 d-flex justify-content-center">
                    <a href={post?.link} className='link-portfolio'>{post?.link}</a>
                  </div>
                  <div className="d-none d-md-flex col-1"><img src={starLine} alt="logo" /></div>
                </div>
              </div>
            </div>
          </section>
        </div>
          :
          <h1>Cargando...</h1>
      }
    </>
  )
}

export default Detail
