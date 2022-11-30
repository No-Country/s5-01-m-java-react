import './App.css';
import React from 'react';
import { Navigate } from 'react-router-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/home/Home';
import Detail from './pages/detail/Detail';
import Login from './pages/login/Login';
import Register from './pages/register/Register';
import Projects from './pages/projects/Projects';



function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Navigate to="/home" />}
        />
        <Route
          path="/home"
          element={<Home />}
        />
        <Route
          path="/detail"
          element={<Detail />}
        />
        <Route
          path="/login"
          element={<Login />}
        />
        <Route
          path="/register"
          element={<Register />}
        />
        <Route
          path="/projects"
          element={<Projects />}
        />
      </Routes>
    </BrowserRouter>
  );
}


export default App;