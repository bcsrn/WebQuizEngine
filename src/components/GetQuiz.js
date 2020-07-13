import React from 'react';

const GetQuiz = ({id, setformBody}) => {
    
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
            <button onClick = {() => fetchData()}>Get Quiz</button>
            
        </>
    );
}

export default GetQuiz;