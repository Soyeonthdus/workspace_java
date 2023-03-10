import React from 'react'

const AddForm = (props) => {
  //브라우저에서 DOM요소에 접근해서 그 요소에 값이나 클릭이벤트 등록했던것 처럼
  //createRef는 리액트에서 바로 DOM요소에 접근하지 않고 필요할 때 createRef 이용해서
  //멤버변수 정의한 다음 것을 원하는 해당하는 컴포넌트에 ref로 연결하면 된다
  //전변 선언시 접미어에 Ref를 붙여서 표시해준다
  const formRef = React.createRef()
  const inputRef = React.createRef()

  const onSubmit = (event) => {
    //이벤트 버블링 이슈 해결하기 위해 반드시 추가할 것 -  onSubmit 이슈
    event.preventDefault()
    const name = inputRef.current.value
    name && props.onAdd(name)
    formRef.current.reset()
  }

  return (
      <form ref={formRef} className="add-for" onSubmit={onSubmit}>
      <input
          ref={inputRef}//이렇게 하면 7번에 선언된 전역변수와 연결됨.
          type="text" className="add-input" placeholder="Workout"/>
      <button className="add-button">Add</button>
  </form>
  )
}

export default AddForm
