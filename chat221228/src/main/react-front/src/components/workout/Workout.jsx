import React, { useState } from 'react'

//const Workout = (props) => {} props에 props 자체를 받아오면
//const {workout, onIncrement, onDecrement} = props 라는 코드를 적어줘야한다 =  구조분해 할당
const Workout = ({workout, onIncrement, onDecrement, onDelete }) => {
  console.log(workout)

  //App에서 받아오니까 필요없어지는 함수
  //const [name, setName] = useState("");
  //const [count, setCount] = useState(); 

  const handleIncrement = () => {
    //이벤트처리가 되어있지 않고 상위 컴포넌트의 함수를 호출중
    //상위 컴포넌트의 함수는 props를 통해서 접근가능함
    //1. 상태값이 바뀌거나 2. props가 바뀌거나 3. 부모값이 바뀌면 재렌더링 발생
    //재렌더링이란 return값이 다시 나가는 것
    //props를 통해서 우리는 주소번지를 받아온다
    //상위 함수를 호출할 때 파라미터도 넘어 간다
    onIncrement(workout);
  }

  const handleDecrement = () => {
    onDecrement(workout);
  }

  const handleDelete = () => {
    onDelete(workout);
  }




  return (
        <>
          <li className='habit'>
            <span className='habit-name'>{workout.name}</span>
            <span className='habit-count'>{workout.count}</span>
          <button className="habit-button habit-increase" onClick={handleIncrement}>
              <i className="fas fa-plus-square"></i>
          </button>
          <button className="habit-button habit-decrease" onClick={handleDecrement}>
              <i className="fas fa-minus-square"></i>
          </button>
          <button className="habit-button habit-delete" onClick={handleDelete}>
              <i className="fas fa-trash"></i>
          </button>
          </li>
        </>
  )
}

export default Workout
