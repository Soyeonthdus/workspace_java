import React from 'react'
import { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const YouTubePage = ({authLogic}) => {
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
        YouTubePage
      <Bottom/>
    </>
  )
}

export default YouTubePage
