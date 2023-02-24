import React from 'react'

const DeptRow = (props) => {
    console.log(props)
    const{deptno, dname, loc} = props.dept;
  return (
    <>
          <tr>
                <td>{deptno}</td>
                <td>{dname}</td>
                <td>{loc}</td>
          </tr>
    </>
  )
}

export default DeptRow
