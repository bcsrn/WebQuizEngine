import React,{useState, useEffect} from 'react';
import ReactDOM from 'react-dom';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import {useFormik, FieldArray} from 'formik';


import 'bootstrap/dist/css/bootstrap.min.css';
import { blockStatement } from '@babel/types';
// import App from './App';
import GetQuiz from '../components/GetQuiz';


const SolveQuiz = ({match}) => {

  const id = match.params.id;
  const [formBody,setformBody] = useState({
    title: '',
      text: '',
      options: '',
      answers: '',
    
  });

  const [formanswers,setfromanswer] = useState('');

  const onSubmit = async () => {
    console.log(id);
    const data =  {title :formBody.title,text:formBody.text,
    options:formBody.options,
    answers:formanswers.split(',').map(x=>+x)}
    // alert(JSON.stringify(data))
    const result = await fetch(`/api/quizzes/solve/${id}`,{
      method: 'post',
      body: JSON.stringify(data),
      headers:{"Content-Type":"application/json"}
    });
    const body = await result.json();
    console.log(body);
    // setformBody(body);
}
return(
  <>
    <GetQuiz id={id} setformBody={setformBody} />
    <label>
      Title: 
      <input type="text" value = {formBody.title}></input>
    </label>
    <label>
      Text: 
      <input type="text" value = {formBody.text}></input>
    </label>
    <label>
      Options: 
      <input type="text" value = {formBody.options}></input>
    </label>
    <label>
      Answers: 
      <input type="text" value={formanswers} onChange={(event) => setfromanswer(event.target.value)}></input>
    </label>
    <button onClick = {() => onSubmit()}>Submit</button>

    </>
  );
}

    

export default SolveQuiz;