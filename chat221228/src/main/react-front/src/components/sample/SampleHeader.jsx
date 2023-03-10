import React from 'react'

const SampleHeader = (props) => {
  console.log('SampleHeader : ' + props.num)

  return (
    <>
      <div style={{border: `3px solid yellowgreen` , width:`300px`}}>
          SampleHeader페이지 영역 <br/>
          <h2>{props.num}</h2>
      </div>
    </>
  )
}

export default SampleHeader
