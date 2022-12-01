import React from 'react';
import "bootswatch/dist/lux/bootstrap.min.css";
import './ItemProject.css';

export default function ItemProject({ proyecto }) {

    return (
        <>
            <div className="col">
                <div className="card imagen">
                    <img url={proyecto.image} className="card-img-top" alt="..." />
                    <div className="card-body">
                        <div>
                            <h5 className="card-title">{proyecto.titulo}</h5>
                        </div>
                        <div className='margin-tecno'>
                            <p>{proyecto.tecnologias.tecno1}</p>
                            <p>{proyecto.tecnologias.tecno2}</p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}