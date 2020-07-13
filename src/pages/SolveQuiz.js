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


const SolveQuiz = () => {

  const [formBody,setformBody] = useState({
    title: '',
      text: '',
      options: '',
      answers: '',
    
  });

  const [formanswers,setfromanswer] = useState('');

  const [id,setId] = useState('');

  const resetState = {
    title : '',
    text : '',
    options: '',
    answers: ''
  }


  const formik = useFormik({
    enableReinitialize:true,
    initialValues: {
      title: formBody.title,
      text: formBody.text,
      options: formBody.options,
      answers: '',
    },
    onSubmit: async (values) => {
      const url = `/api/quizzes/solve/${id}`
      const data = {"title":formik.values.title,"text":formik.values.text,
    "options":formik.values.options,
    "answers":formanswers.split(',').map(x=>+x)}
      // alert(JSON.stringify(values));
      const result = await fetch(url,
        {method: 'POST',      
        body: JSON.stringify(data),
      headers:{"Content-Type":"application/json"}});
      const body = await result.json();
      console.log(body);
      alert(JSON.stringify(body));
      formik.resetForm({values:''});
      setformBody(resetState);
      setfromanswer('');
      setId('');
    },

  });
    return (

<div class = "Container">
<GetQuiz id={id} setId = {setId} setformBody={setformBody} />
<Form class = "Actual-Form" onSubmit={formik.handleSubmit}>
  <Form.Group as={Row} controlId="formBasicTitle">
    <Form.Label column sm={2}>Title</Form.Label>
    <Col sm={10}>
    <Form.Control 
      id = "title" 
      name = "title"
      type="text" 
      onChange = {formik.handleChange}
      value = {formik.values.title}
      placeholder="Enter title of Quiz" 
      /> 
    </Col>   
  </Form.Group>

  <Form.Group as={Row} controlId="formBasicText">
    <Form.Label column sm={2}>Text</Form.Label>
    <Col sm={10}>
    <Form.Control 
    id = "text" 
    name = "text"
    type="text" 
    onChange = {formik.handleChange}
    value = {formik.values.text}
    placeholder="Enter question" />
    </Col>
  </Form.Group>

  <Form.Group as={Row} controlId="formBasicOptions">
  <Form.Label column sm={2}>Options</Form.Label>
  <Col sm={10}>
  <Form.Control 
  id = "options" 
  name = "options"
  type="text" 
  onChange = {formik.handleChange}
  value = {formik.values.options}
  placeholder="Enter options" />
  </Col>
  </Form.Group>

  <Form.Group as={Row}  controlId="formBasicAnswers">
  <Form.Label column sm={2}>Answers</Form.Label>
  <Col sm={10}>
  <Form.Control 
  id = "answers" 
  name = "answers"
  type="text" 
  onChange = {(event) => setfromanswer(event.target.value)}
  value = {formanswers}  
  placeholder="Enter answers" />
  </Col>
  </Form.Group>

  <Form.Group as={Row}>
    <Col sm={{ span: 10, offset: 2 }}>
      <Button type="submit">Submit</Button>
    </Col>
  </Form.Group>
</Form>
</div>
  );
}

    

export default SolveQuiz;