import React from 'react'
import './btns.css'

const BtnOutline = (props) => {
  return (
    <>
      <button type="button" className="btn btn-outline-danger m-0" style={{color: props.color, borderColor: props.color, width: props.width}} onClick={props.onclick}>{props.label}</button>
    </>
  )
}

export default BtnOutline
