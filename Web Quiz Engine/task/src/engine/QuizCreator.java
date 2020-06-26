package engine;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class QuizCreator implements QuizService{
    public static int id;
    public List<Quiz> quizStorage;

    public QuizCreator(){
        id = 0;
        this.quizStorage = new ArrayList<>();
    }
//
//    public Quiz createQuiz(String title, String text, String[] options, int answer){
//        Quiz newQuiz = new Quiz();
//        newQuiz.setId(id++);
//        newQuiz.setAnswer(answer);
//        newQuiz.setOptions(options);
//        newQuiz.setText(text);
//        newQuiz.setTitle(title);
//        return newQuiz;
//    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
//        if (quiz.getText() == null || quiz.getTitle() == null){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        else if ("".equals(quiz.getText()) || "".equals(quiz.getTitle()) || quiz.options.length < 2){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
        this.quizStorage.add(quiz);
        quiz.setId(id++);
        return quiz;
    }

    @Override
    public Quiz findQuizById(int id) {
        if (id < this.quizStorage.size()){
            return this.quizStorage.get(id);
        }else{
            throw new NoIdException();
        }


    }
}
