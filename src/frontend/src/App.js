import logo from './logo.svg';
import './App.css';
import React from 'react';
import Carga from './pages/CargaRecibos';
import Visualizar from './pages/VisualizarRecibos';
import {
  BrowserRouter as Router,
  Routes,
  Route
  
} from "react-router-dom";
function App() {
  return (
    <Router >
            <Routes>
              <Route exact path="/carga"  element={<Carga />}/>
          
              <Route path = "/visualizar" element={<Visualizar />} exact/>
               
            </Routes>
        </Router >
  );
}

export default App;
