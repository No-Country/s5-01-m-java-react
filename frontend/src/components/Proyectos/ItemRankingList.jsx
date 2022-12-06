import React, { useEffect, useState } from 'react';
import ReactPaginate from "react-paginate";
import "bootswatch/dist/lux/bootstrap.min.css";
import ItemProject from './ItemProject';
import './ItemProjectList.css';
import ItemRanking from './ItemRanking';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import './ItemProjectList.css';


export default function ItemList(props) {
    const { data } = props;

    var settings = {
        dots: true,
        className: "center",
        centerMode: false,
        infinite: false,
        centerPadding: "30px",
        slidesToShow: 2.3,
        slidesToScroll: 2,
        speed: 500};

    return (
        <>
            <section className='py-5-ranking'>
                <div className="container">
                    <Slider {...settings} className="mt-5" >
                        {data.map(proyecto => {
                            return (
                                <>
                                    <ItemRanking proyecto={proyecto} key={proyecto.id} />
                                </>
                            );
                        })}

                    </Slider>
                </div>
            </section>
        </>
    );

}