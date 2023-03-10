import { Route, Routes } from 'react-router-dom';
import './App.css';
import DeptPage from './components/page/DeptPage';
import Homepage from './components/page/Homepage';
import FireDeptPage from './components/page/FireDeptPage';
import Loginpage from './components/login/Loginpage';
import EmpPage from './components/page/EmpPage';
import BoardPage from './components/page/BoardPage';
import WorkoutPage from './components/page/WorkoutPage';
import HackerNewsPage from './components/page/HackerNewsPage';
import YouTubePage from './components/page/YouTubePage';
import "bootstrap/dist/css/bootstrap.css";
import { useEffect, useState } from 'react';

//index.js에서 <BrowserRouter>로 감싸진 App태그 속성값으로 넘어온 주소번지를 갖는다
const App = ({authLogic}) => {
  console.log('App호출');

  //상수값 -> axios(node.Js, React -> 모듈화 시켜서 사용), fetch(바닐라스크립트 -> 브라우저 지원) 그래도 둘 다 비동기 처리방식임
      const[items, setItems] = useState([
        {id:1, name:"벤치프레스", count:0},
        {id:2, name:"랫풀다운", count:0},
        {id:3, name:"스쿼트", count:0}
      ]);

      useEffect (() => {console.log('effect호출')},[])
      //첫번째 파라미터는 콜백함수이다
      //두번째 파라미터는 의존성 배열이다 -  Dependency Array
      //의존성 배열이 비어있으면 최초 App컴포넌트가 렌더링 될 때(어떤게? 언제?) 딱 한번만 실행된다
      //재렌더링이 되는 대상은 return안에 있는 코드들이다
      //만일 items가 변경되면 그때는 재렌더링 일어난다 - 상태값이 바뀐것이므로

      const handleIncrement = (item) => {
        const index = items.indexOf(item);
        items[index].count +=1;
        setItems([...items])
      }

      const handleDecrement = (item) => {
        const index = items.indexOf(item);
        items[index].count -=1;
        setItems([...items])
      }
      
      const handleDelete = (item) => {
        const index = items.indexOf(item);
        items[index].count = 0;
        setItems([...items])
      }

      const handleAdd = (name) => {
        //AddForm화면에서 사용자가 입력한 운동이름을 받아온다
        //세번째 파라미터는 0으로 초기화
        //스프레드 연산자를 활용하여 기존 배열에 한개의 객체를 추가하는 코드
        const workouts = [...items, {id:Date.now(), name, count:0}]
        //상태 훅에 반영 - 스프레드 연산자를 활용하여 새로운 주소번지가 채번되도록 처리해야 함
        //상태값이 변경되었다는 사실을 리액트에서 인지할 수 있다
        setItems([...workouts])
      }


      return (
        //사용자 정의 컴포넌트에서 return다음에 오는 코드가 element의 집합(=component) 
        //return 이후가 렌더링이 되는 구간
        //Router를 이용하면 SPA(Single Page Application)누릴 수 있다
      <>
    <Routes>
        <Route path='/' exact={true} element={<Loginpage authLogic={authLogic}/>}/>
        <Route path='/home/:userId' exact={true} element={<Homepage authLogic={authLogic} />}/>
        <Route path='/board' exact={true} element={<BoardPage authLogic={authLogic}/>}/>
        <Route path='/workout' exact={true} element={<WorkoutPage  authLogic={authLogic} workouts={items}
          onIncrement = {handleIncrement} onDecrement = {handleDecrement} onAdd={handleAdd} onDelete = {handleDelete}  /> } />
        <Route path='/hackernews' exact={true} element={<HackerNewsPage  authLogic={authLogic}/>}/>
        <Route path='/youtube' exact={true} element={<YouTubePage  authLogic={authLogic}/>}/>
        <Route path='/dept/:id' exact={true} element={<FireDeptPage/>}/>
        <Route path='/emp' exact={true} element={<EmpPage/>}/>
      </Routes>
      </>
      );
}

export default App;
