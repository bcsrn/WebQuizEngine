import React,{useState} from 'react';

const GetQuiz = ({id,setId,setformBody}) => {

    
    
    const fetchData = async () => {
        console.log(id);
        const result = await fetch(`/api/quizzes/${id}`);
        const body = await result.json();
        console.log(body);
        setformBody(body);
    }
        // console.log(formBody.title);
    return (
        <>
            <label> 
                Id:
                <input type="number" value={id} onChange={(event) => setId(event.target.value)}></input>
            </label>
            <button onClick = {() => fetchData()}>Get Quiz</button>
            
        </>
    );
}

export default GetQuiz;