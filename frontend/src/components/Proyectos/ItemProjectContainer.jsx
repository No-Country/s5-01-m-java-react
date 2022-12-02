import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Headroom from "react-headroom";
import "bootswatch/dist/lux/bootstrap.min.css";
import ItemProjectList from './ItemProjectList';
import data from './proyectos.json'

export default function ItemProjectContainer() {

    const [projects, setprojects] = useState([]);
    const { categoria } = useParams();


    return (
        <>
            <ItemProjectList data={data}/>
        </>
    )
}