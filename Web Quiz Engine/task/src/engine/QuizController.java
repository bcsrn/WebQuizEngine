package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class QuizController {
    Quiz myQuiz;
    QuizCreator creator;
    ServerResp responce;

    @Autowired
    private QuizRepository quizRepository;

    public QuizController(){
        this.creator = new QuizCreator();
    }

    @PostMapping(path = "/api/quizzes",consumes = "application/json")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz){
        return quizRepository.save(quiz);
    }

//    @PostMapping(path = "/api/quizzes",consumes = "application/json")
//    public ResponseEntity<Quiz> createQuiz(@Valid @RequestBody Quiz quiz ){
//        Quiz createdQuiz = this.creator.createQuiz(quiz);
//        return new ResponseEntity<>(createdQuiz, HttpStatus.OK);
//
//    }

    @GetMapping(path = "/api/quizzes/{id}")
    public Quiz findQuizById(@PathVariable Long id){
        return quizRepository.findById(id).get();
    }

    @GetMapping(path = "/api/quizzes")
    public List<Quiz> getAllQuizzes(){
        return (List<Quiz>) quizRepository.findAll();
    }

    @PostMapping(path = "/api/quizzes/{id}/solve",consumes = "application/json")
    public ServerResp checkAnswerForId(@PathVariable Long id,@RequestBody Quiz quiz){
        Quiz myQuiz = quizRepository.findById(id).get();
        List<Integer> myquizanswer = myQuiz.getAnswers();
        List<Integer> answer = quiz.getAnswers();
//        System.out.println(quiz.getAnswer());
//        System.out.println(myquizanswer);
        String feedback;
        boolean success;
        if (myquizanswer == null || myquizanswer.size() == 0){
            if (answer == null || answer.size() == 0){
                success = true;
            }
            else{
                success = false;
            }

        }
        else if (answer.equals(myquizanswer)){
            success = true;
        }else{
            success = false;
        }



        if (success){
            feedback = "Congratulations";
        }else{
            feedback = "Sorry, wrong answerr";
        }

        this.responce = new ServerResp(success,feedback);
        return this.responce;

    }



    @GetMapping(path = "/api/quiz")
    public Quiz getQuiz(){
        return this.myQuiz;
    }

    @PostMapping(path = "/api/quiz")
    public ServerResp checkAnswer(int answer){
        String feedback;
        boolean success;
        if (answer  == 2){
            success = true;
        }else{
            success = false;
        }

        if (success){
            feedback = "Congratulations";
        }else{
            feedback = "Sorry, wrong answerr";
        }

        this.responce = new ServerResp(success,feedback);
        return this.responce;

    }
}
