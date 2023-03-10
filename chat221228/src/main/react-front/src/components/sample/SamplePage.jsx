import React from 'react'
import SampleBottom from './SampleBottom'
import SampleHeader from './SampleHeader'
import SubPage from './SubPage'

const SamplePage = (props) => {
  console.log(":" + props.num)

  const handleAdd = (num) => {
    console.log('SamplePage handleApp : ' + num)
    props.handleAdd(num)
  }
  
  const handleMinus = (num) => {
    console.log('SamplePage handleApp : ' - num)
    props.handleMinus(num)
  }
  return (
    <>
      <SampleHeader num = {props.num} />
        <div style={{border:`3px solid pink`, width:`600px`, height : `300px`}}>
          <SubPage handleAdd = {handleAdd} handleMinus = {handleMinus}/>

        </div>
      <SampleBottom />
    </>
  )
}

export default SamplePage
