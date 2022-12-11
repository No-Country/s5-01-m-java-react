import React, {useState} from 'react';
import "bootswatch/dist/lux/bootstrap.min.css";
import './ItemProject.css';
import star from '../../assets/img/Star 1 (roja).svg'
import { useDispatch } from 'react-redux'
import Detail from '../../pages/detail/Detail';
import { Navigate } from 'react-router-dom';
import { setProyect } from '../../store/slices/proyect/index'

export default function ItemProject({ proyecto }) {

    const dispatch = useDispatch()
    const [success, setSuccess] = useState(false);

    const verDetalle = (e) => {
        e.preventDefault();
        dispatch(setProyect(proyecto));
       
        localStorage.setItem('setProyectID', JSON.stringify(proyecto.id))
        setSuccess(true)


    }


    return (
        <>
            {
                success ? (<Navigate to="/detail" />) :
                    <div className="col" onClick={verDetalle}>
                        <div className="card imagen">
                            <img src={proyecto.image} className="card-img-top" height="300" alt="..." />
                            <div className="card-body">
                                <div className='margin-title'>
                                    <h5 className="card-title">{proyecto.name}</h5>
                                </div>
                                <div className='data-body'>
                                    <div className='margin-tecno'>
                                        <p>{proyecto.stack.tech1}</p>
                                        <p>{proyecto.stack.tech2}</p>
                                    </div>
                                    <div className='puntuacion'>
                                        <h3>{proyecto.rating}</h3>
                                    </div>
                                    <div className='star'>
                                        <img src={star}></img>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            }

        </>
    )
}