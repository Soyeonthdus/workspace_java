import React, { useState } from 'react'
import SamplePage from './components/sample/SamplePage' 

const SampleApp = () => {
  const [num, setNum] = useState(0)

  const handleAdd = () =>{
    console.log('SampleApp handle 호출')
    setNum(num+1)
  }
  
  const handleMinus = () =>{
    console.log('SampleApp handle 호출')
    setNum(num-1)
  }
  
  
  return (
    <>
        {/* 여기에서 SamplePage를 연다 */ }
        <SamplePage num = {num} handleAdd={handleAdd} handleMinus = {handleMinus}/>
    </>
  )
}

export default SampleApp
