package engine;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class QuizController {
    Quiz myQuiz;
    QuizCreator creator;
    ServerResp responce;

    public QuizController(){
        this.creator = new QuizCreator();
    }

    @PostMapping(path = "/api/quizzes",consumes = "application/json")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz ){
        return this.creator.createQuiz(quiz);

    }

    @GetMapping(path = "/api/quizzes/{id}")
    public Quiz findQuizById(@PathVariable int id){
        return this.creator.findQuizById(id);
    }

    @GetMapping(path = "/api/quizzes")
    public List<Quiz> getAllQuizzes(){
        return this.creator.quizStorage;
    }

    @PostMapping(path = "/api/quizzes/{id}/solve",consumes = "application/json")
    public ServerResp checkAnswerForId(@PathVariable int id,@RequestBody Quiz quiz){
        Quiz myQuiz = this.creator.findQuizById(id);
        int[] myquizanswer = myQuiz.getAnswer();
        int[] answer = quiz.getAnswer();
//        System.out.println(quiz.getAnswer());
//        System.out.println(myquizanswer);
        String feedback;
        boolean success;
        if (myquizanswer == null || myquizanswer.length == 0){
            if (answer == null || answer.length == 0){
                success = true;
            }
            else{
                success = false;
            }

        }
        else if (Arrays.equals(answer,myquizanswer)){
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
