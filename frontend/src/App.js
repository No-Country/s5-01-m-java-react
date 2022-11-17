import './App.css';
import React from 'react';
import { Navigate } from 'react-router-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/home/Home';
import Detail from './pages/detail/Detail';



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
      </Routes>
    </BrowserRouter>
  );
}


export default App;