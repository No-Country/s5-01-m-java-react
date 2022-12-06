import React, { useEffect, useState } from 'react';
import axios from "axios";
import './Button.css';

const Buttons = ({ filterItem, setItem, menuItems }) => {

  const [lista, setLista] = useState([]);
  useEffect(() => {
    axios({
      url: "https://s5-01-m-java-react-production.up.railway.app/api/projects",
    })
      .then((response) => {
        setLista(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [setLista]);


  return (
    <>
      <div className='text-filtrar'>
        <p>FILTRAR POR:</p>
      </div>
      <div className="d-flex margin-btn">
        {menuItems.map((Val, id) => {
          return (
            <button
              className="btn-black text mx-4 padding-btn btn"
              onClick={() => filterItem(Val)}
              key={id}>
              <p>{Val}</p>
            </button>
          );
        })}
        <button
          className="btn-black text mx-4 padding-btn btn"
          onClick={() => setItem(lista)}>
          <p>All</p>
        </button>
      </div>
    </>
  );
};

export default Buttons;
