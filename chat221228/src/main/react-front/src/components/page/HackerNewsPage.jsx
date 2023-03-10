import axios from 'axios'
import React from 'react'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import styled from 'styled-components'

const NewsListUL = styled.ul`
  background-color : gray;
  padding-top : 10px;
  padding-left : 6px;
  padding-right : 6px;
  padding-bottom : 18px;
`

const HackerNewsPage = ({authLogic}) => {
  const[newsList, setNewsList] = useState([])
  const NEWSURL = "https://api.hnpwa.com/v0/news/1.json";

  const navigate = useNavigate()

  const onLogout = () => {
    console.log('HomePage onLogout 호출')
    authLogic.logout()
  }
  
  useEffect(()=> {
    axios.get(NEWSURL).then(response => {
      console.log(response.data)
      setNewsList(response.data)
    })
  },[])


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
        <NewsListUL>
          {newsList.map((news, index) => (
            <li key = {news.id}>{news.title}</li>
            ))}
        </NewsListUL>
        
      <Bottom/>
    </>
  )
}

export default HackerNewsPage
