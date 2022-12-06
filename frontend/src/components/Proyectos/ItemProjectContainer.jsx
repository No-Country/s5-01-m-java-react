import React, { useEffect, useState } from 'react';
import "bootswatch/dist/lux/bootstrap.min.css";
import ItemProjectList from './ItemProjectList';
import axios from "axios";
import Buttons from "./Buttons";
import { List } from 'react-bootstrap-icons';



export default function ItemProjectContainer() {

  const [list, setList] = useState([]);
  useEffect(() => {
    axios({
      url: "https://s5-01-m-java-react-production.up.railway.app/api/projects",
    })
      .then((response) => {
        setList(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);


  const menuItems = [...new Set(list.map((Val) => Val.type))];

  const filterItem = async (curcat) => {
    const newItem = list.filter((newVal) => {
      return newVal.type === curcat;
    });
    setList(newItem);
  };


  return (
    <>
        <div className="row">
          <Buttons
            filterItem={filterItem}
            setItem={setList}
            menuItems={menuItems}
          />
        </div>
      <ItemProjectList data={list} />
    </>
  )
}