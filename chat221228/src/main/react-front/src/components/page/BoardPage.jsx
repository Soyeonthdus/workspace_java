import React, { useEffect } from 'react'
import {useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const BoardPage = ({authLogic}) => {
  //Single Page Application 컨벤션을 위한 훅
  const navigate = useNavigate()
  const onLogout = () => {
    console.log('HomePage onLogout 호출')
    authLogic.logout()
  }
  useEffect(() => {
    authLogic.onAuthChange(user => {
      if(!user){
        navigate("/")
      }
    })
  })
  
  return (
    
    <>
        <Header onLogout={onLogout}/>
            BoardPage
        <Bottom/>
    </>
    
    
  )
}

export default BoardPage




