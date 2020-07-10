import React,{Component} from 'react';
import {
  BrowserRouter as Router,
  Route,
  Switch
} from 'react-router-dom';
import './App.css';
import './index.css';

import HomePage from './pages/HomePage';
import CreateQuiz from './pages/CreateQuiz';
import UserLogin from './pages/UserLogin';
import SolveQuiz from './pages/SolveQuiz';
import NavBar from './NavBar';
import NotFoundPage from './pages/NotFoundPage';

class App extends Component {
  render(){
  return (
    <Router>
      <div className="App">
      <NavBar />
      <div id="page-body">
      <Switch>
        <Route path="/" component={HomePage} exact/>
        <Route path="/login" component={UserLogin} />
        <Route path="/createQuiz" component={CreateQuiz} />
        <Route path="/solveQuiz" component={SolveQuiz} />
        <Route component={NotFoundPage} />
      </Switch>
      </div>
      </div>
    </Router>
  );
  }
}

export default App;
