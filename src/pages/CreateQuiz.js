import React from 'react';
import ReactDOM from 'react-dom';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import {useFormik, FieldArray} from 'formik';


import 'bootstrap/dist/css/bootstrap.min.css';
import { blockStatement } from '@babel/types';
// import App from './App';


function CreateQuiz(){
    const formik = useFormik({
      initialValues: {
        title: '',
        text: '',
        options: '',
        answers: '',
      },
      onSubmit: values => {
        const url = "/api/quizzes"
        const data = {"title":formik.values.title,"text":formik.values.text,
      "options":formik.values.options.split(','),
      "answers":formik.values.answers.split(',').map(x=>+x)}
        // alert(JSON.stringify(values));
        fetch(url,
          {method: 'POST',      
          body: JSON.stringify(data),
        headers:{"Content-Type":"application/json"}})
        .then(res => {
        if (res.ok){        
          res.json();
          return alert("Success!");
        }else{
          return alert("something went wrong..");
        }
        })
        .catch(error => console.error('Error:',error))
        // .then(data => console.log);
  
      },
  
    });
      return (
  
  <div class = "Container">
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
  
    {/* <Form.Group as={Row} controlId="formBasicOptions">
    <Form.Label column sm={2}>Options</Form.Label>
    <Col sm={10}>
    <FieldArray
    id = "options" 
    name = "options"
    type="text" 
    onChange = {formik.handleChange}
    value = {formik.values.options}
    placeholder="Enter options" />
    </Col>
    </Form.Group>  */}
  
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
    onChange = {formik.handleChange}
    value = {formik.values.answers}  
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
  
  // </div>
  );
  }

export default CreateQuiz;