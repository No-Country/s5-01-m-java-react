import React from 'react'
import Nav from '../../components/Nav'
import './home.css'
import title from '../../assets/img/title.png'
import rectangle from '../../assets/img/rectangle.png'
import "bootswatch/dist/lux/bootstrap.min.css";
import polygon from '../../assets/img/polygon.png'

const Home = () => {
  return (
    <div>
        <Nav />

      <header className='container mt-5 header'>
        <div>
          <h1 className='title'>LOREM IPSUM</h1>
          <p className='paragraph'>Lorem, ipsum dolor sit amet onsectetur adipisicing elit. Id, molestiae! ipsum dolor sit amet onsectetur adipisicing elit. Id, molestiae! ipsum dolor sit amet  ipsum dolor sit amet</p>
        </div>
        <div className='mx-5'>
          <img src={title} alt="Title" width="45px"/>
        </div>
        <div>
          <img src={rectangle} alt="Imagen" />
        </div>
      </header>

      <div className='container polygon mt-3'>
        <img src={polygon} alt="polygon" />
        <div>
          <button type="button" class="btn btn-primary btnCenter">CTA</button>
        </div>
      </div>



      <h1 className='titleCategories mt-5'>LOREM IPSUM</h1>
    </div>
  )
}

export default Home
