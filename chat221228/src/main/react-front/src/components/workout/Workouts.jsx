import React, { useState } from 'react'
import AddForm from './AddForm';
import Workout from './Workout';

//props로 넘길 때 파라미터를 따로 작성하지 않아도 넘어감 - 동일한 함수 선언 불가
const Workouts = ({workouts, onIncrement, onDecrement, onDelete, onAdd}) => {
  // const [name, setName] = useState("default");
  // const [count, setCount] = useState(0);
  
  const handleIncrement = (item) => {
    console.log('Workouts ===>' + item);
      onIncrement(item);
  }
  const handleDecrement = (item) => {
    console.log('Workouts ===>' + item);
    onDecrement(item)
  }
  const handleDelete = (item) => {
    onDelete(item)
  }

  const handleAdd = (name) => {
    onAdd(name)
  }

  return (
        <>
          <div className='habits'>
            <AddForm onAdd={handleAdd} />
          <ul>
            {workouts.map((item, index) => (
              <Workout key = {index} workout={item} onIncrement={handleIncrement} onDecrement = {handleDecrement} onAdd={handleAdd} onDelete={handleDelete} />
            ))}
          </ul>
          </div>
        </>
  )
}

export default Workouts
