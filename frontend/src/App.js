import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import { useLocalState } from './util/useLocalStorage';
import { Route,Routes } from 'react-router-dom';
import Dashboard from './Dashboard';
import PrivateRoute from './PrivateRoute';

function App() {
  const [jwt,setJwt]= useLocalState("","jwt")
  useEffect(()=>{

    if(!jwt){
      const reqBody={
        "username":"yash1",
        "password":"hello"
      }
      console.log("Hello")
      fetch('api/auth/login',{
        headers:{
          "Content-Type":"application/json"
        },
        method:"post",
        body:JSON.stringify(reqBody)
      }).then((response)=>Promise.all([response.json(),response.headers]))
      .then(([body,headers])=>{
        setJwt(headers.get("authorization"));
        console.log(jwt);
        // console.log(body);
      }); 
    }

  },[])

    

  return (
    <>
      <div className="App">
      <div>You are in home page</div>
      <Routes>
        
        <Route path="/dashboard" element={<PrivateRoute><Dashboard/></PrivateRoute>} />

      </Routes>
    </div>
    </>
    
  );
}

export default App;
