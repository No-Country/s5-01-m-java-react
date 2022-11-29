import React from 'react'

const BtnRed = (props) => {
  return (
    <>
      <button type="button" className="btn btn-danger m-0"  style={{backgroundColor: props.color}}>{props.label}</button>
    </>
  )
}

export default BtnRed
