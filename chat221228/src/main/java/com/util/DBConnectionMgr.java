package com.util;

import java.sql.*;

public class DBConnectionMgr {
  public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";// 오라클 안에 데이터가 들어있다...

  public static final String _URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
  public static String _USER = "banana";// 키위쓸때는 키위로 바꾸고 스캇쓸때는 스캇으로
  public static String _PW = "tiger";

  public DBConnectionMgr() {
  }
  // 파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자 제공 안된다.

  public DBConnectionMgr(String ID, String PW) {
    // static으로 선언된 변수는 this나 super같은 예약어를 사용 불가함.
    // this에 대한 어려움으로 리액트 훅(함수형 프로그래밍을 지향하는 방식 -> 자바 : 람다식 / 익명클래스 / 내부클래스 컨벤션 동일)
    // 새로운 방식 제안함 16.8번 18.2
    // 웹브라우저에서는 this가 왜 문제인가? - 캡쳐링 / 버블링효과
    _USER = ID;
    _PW = PW;
  }

  public Connection getConnection(String user, String pw) {
    _USER = user;
    _PW = pw;
    Connection con = null;
    try {
      Class.forName(_DRIVER);
      con = DriverManager.getConnection(_URL, _USER, _PW);
    } catch (ClassNotFoundException ce) {
      System.out.println("드라이버 클래스를 찾을 수 없습니다.");
    } catch (Exception e) {// 멀티 블럭 작성시 더 넓은 클래스가 뒤에 와야함
      System.out.println("오라클 서버와 커넥션 실패");
    }
    return con;
  }

  public Connection getConnection() {
    Connection con = null;
    try {
      Class.forName(_DRIVER);
      con = DriverManager.getConnection(_URL, _USER, _PW);
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 클래스를 찾을 수 없습니다.");
    } catch (Exception e) {// 가장 범위가 넓은 클래스를 가장 바깥에 적기. 에러중에 젤 큰애다.
      // 멀티 블럭 작성시 더 넓은 클래스가 뒤에 와야함
      System.out.println("오라클 서버와 커넥션 실패!");
    }
    return con;
  }
  // 사용한 자원을 반납하는 코드를 명시적으로 하는 것을 원칙으로 하고있음
  // 반납하는 순서는 생성된 역순으로 진행할 것-자바 튜닝팀 지적사항

  // 사용한 자원 반납하기 SELECT-커서 조작이 필요함
  public void freeConnection(Connection con, Statement stmt, ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }

  public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    if (pstmt != null) {
      try {
        pstmt.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
  // 사용한 자원 반납하기-INSET, UPDATE, DELETE

  public void freeConnection(Connection con, Statement stmt) {

    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }

  public static void main(String[] args) {
    DBConnectionMgr dbMgr = new DBConnectionMgr();
    Connection con = dbMgr.getConnection();
    System.out.println("con====>" + con);
  }

  public void freeConnection(Connection con, CallableStatement cstmt) {
    if (cstmt != null) {
      try {
        cstmt.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
