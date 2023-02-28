import React from 'react'
import Header from '../include/Header'
import Bottom from '../include/Bottom'
import { useParams } from 'react-router-dom'

//로그아웃 처리를 위해서 props에 authLogic주소번지를 받아온다
const Homepage = (authLogic) => {
    let {userId} = useParams()
    console.log(userId)
    const onLogout = () => {
      console.log('HomePage onLogout 호출')
      authLogic.logout()
    }
  return (
    <React.Fragment>
      <Header userId = {userId} onLogout = {onLogout} />
        <Header />
            <div>
              HomePage페이지입니다
            </div>
        <Bottom />
    </React.Fragment>
  )
}

export default Homepage
