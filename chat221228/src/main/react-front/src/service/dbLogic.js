import axios from "axios";

/* 톰캣서버와 연결하기 위한 */
export const jsonDeptList = (params) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_CHAT221228_IP + "dept/jsonDeptList.st1",
        params: params,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};
/* rafce 단축키 - arrow function export default */
