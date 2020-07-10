package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizCreator implements QuizService{
    public static Long id;
    public List<Quiz> quizStorage;

    @Autowired
    private QuizRepository quizRepository;

    public QuizCreator(){
        id = 0L;
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
        System.out.println(quiz);
        return quizRepository.save(quiz);
//        return quiz;
    }

    @Override
    public Quiz findQuizById(Long id) {
        return quizRepository.findById(id).get();
//        if (id < this.quizStorage.size()){
//            return this.quizStorage.get(id);
//        }else{
//            throw new NoIdException();
//        }


    }
}
