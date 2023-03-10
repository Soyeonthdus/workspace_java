import React from 'react'
import { Button } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link } from 'react-router-dom';

const Header = ({userId, onLogout}) => {
  //const {userId , onLogout} = props;
  return (
    <React.Fragment>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Link to ="/" className="nav-link">Home</Link>
              <Link to ="/board" className="nav-link">게시판</Link>
              <Link to ="/workout" className="nav-link">홈트</Link>
              <Link to ="/youtube" className="nav-link">유튜브</Link>
            </Nav>
            {onLogout && <Button variant='primary' onClick={onLogout}>Logout</Button>}
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </React.Fragment>
  )
}

export default Header