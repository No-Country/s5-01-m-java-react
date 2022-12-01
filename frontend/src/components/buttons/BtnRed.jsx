import React from 'react'
import './btns.css'

const BtnRed = (props) => {
  return (
    <>
      <button type="button" className="btn btn-danger m-0"  style={{backgroundColor: props.color, width: props.width}}>{props.label}</button>
    </>
  )
}

export default BtnRed
