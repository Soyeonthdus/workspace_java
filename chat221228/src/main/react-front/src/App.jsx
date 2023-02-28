import { Route, Routes } from 'react-router-dom';
import './App.css';
import DeptPage from './components/page/DeptPage';
import Homepage from './components/page/Homepage';
import FireDeptPage from './components/page/FireDeptPage';
import Loginpage from './components/login/Loginpage';
import EmpPage from './components/page/EmpPage';
//index.js에서 브라우저 라우터로 감싸진 App태그 속성값으로 넘어온 주소번지를 갖는다
const App = ({authLogic}) => {
  //사용자 정의 컴포넌트에서 return다음에 오는 코드가 element의 집합(=component) 
  //return 이후가 렌더링이 되는 구간
  //Router를 이용하면 SPA(Single Page Application)누릴 수 있다
  return (
  <>
<Routes>
    <Route path='/' exact={true} element={<Loginpage authLogic={authLogic}/>}/>
    <Route path='/home/:userId' exact={true} element={<Homepage authLogic={authLogic} />}/>
    <Route path='/dept/:id' exact={true} element={<DeptPage/>}/>
    <Route path='/emp' exact={true} element={<EmpPage/>}/>
    <Route path='/dept/:id' exact={true} element={<FireDeptPage/>}/>
  </Routes>
  </>
  );
}

export default App;
