import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Headroom from "react-headroom";
import "bootswatch/dist/lux/bootstrap.min.css";
import ItemProjectList from './ItemProjectList';
import data from './proyectos.json';
import ItemRankingList from './ItemRankingList';
import axios from "axios";
import Slider from "react-slick";

export default function ItemProjectContainerRanking() {

  var settings = {
    dots: true,
    className: "center",
    centerMode: false,
    infinite: false,
    centerPadding: "30px",
    slidesToShow: 2.3,
    slidesToScroll: 2,
    speed: 500};

    const [listRanking, setList] = useState([]);
    useEffect(() => {
      axios({
        url: "https://s5-01-m-java-react-production.up.railway.app/api/topTen",
      })
        .then((response) => {
          setList(response.data);
          console.log(response.data)
        })
        .catch((error) => {
          console.log(error);
        });
    }, [setList]);


    return (
        <>
            <ItemRankingList data={ listRanking }/>
        </>
    )
}