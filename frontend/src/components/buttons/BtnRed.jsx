import React from 'react'
import './btns.css'

const BtnRed = (props) => {
  return (
    <>
      <button className="btn btn-danger m-0"  type={props.type} style={{backgroundColor: props.color, width: props.width}}>{props.label}</button>
    </>
  )
}

export default BtnRed
