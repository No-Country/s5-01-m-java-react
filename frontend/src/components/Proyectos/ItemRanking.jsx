import React from 'react';
import "bootswatch/dist/lux/bootstrap.min.css";
import './ItemProject.css';
import star from '../../assets/img/Star 1 (roja).svg'

export default function ItemRanking({ proyecto }) {

    return (
        <>
            <div className='cuadro'>
                <div className="card imagen">
                    <img src={proyecto.image} className="card-img-top max-image" height="350" alt="..." />
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
        </>
    )
}