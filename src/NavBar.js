import React from 'react';
import {Link} from 'react-router-dom';

const NavBar = () => (
    <nav>
        <ul>
            <li>
                <Link to="/">Home</Link>
            </li>
            <li>
                <Link to="/login">User Login</Link>
            </li>
            <li>
                <Link to="createQuiz">Create a quiz!</Link>
            </li>
            <li>
                <Link to="/solveQuiz">Solve a quiz!</Link>
            </li>            
        </ul>
    </nav>

);

export default NavBar;