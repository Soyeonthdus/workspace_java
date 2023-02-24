import { Route, Routes } from 'react-router-dom';
import './App.css';
import DeptPage from './components/page/DeptPage';
import Homepage from './components/page/Homepage';
import FireDeptPage from './components/page/FireDeptPage';

function App() {
  return (
  <>
  <Routes>
    <Route path='/' exact={true} element={<Homepage/>}/>
    <Route path='/dept/:id' exact={true} element={<FireDeptPage/>}/>
  </Routes>
  </>
  );
}

export default App;
