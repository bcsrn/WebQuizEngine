package engine;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column
    private String text;


    @NotEmpty
    @Size(min = 2)
    @ElementCollection
    @CollectionTable
    private List<String> options = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ElementCollection
    @CollectionTable
    private List<Integer> answers = new ArrayList<>();

    public Quiz(){

    }


    //setters and getters

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public List<Integer> getAnswers() {
        return answers;
    }
    //    public void setAnswers(List<Answer> answers) {
//        this.answers = answers;
//    }
//
//    public List<Answer> getAnswers() {
//        return answers;
//    }

    //    public void setAnswer(int[] answer) {
//        this.answer = answer;
//    }
//    public int[] getAnswer() {
//        return answer;
//    }
//    public void setOptions(List<Option> options) {this.options = options;    }
    //    public void setOptions(String[] options) {
//        this.options = options;
//    }


    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public String getTitle() {
        return title;
    }
//    public List<Option> getOptions() {return options; }
    //    public String[] getOptions() {
//        return options;
//    }



    //    public Quiz(int id,String title, String text, String[] options,int answer){
//        this.title = title;
//        this.text = text;
//        this.options = options;
//        this.answer = answer;
//        this.id = id;
//    }

//    public Quiz getQuiz(){
//        String title = "The Java Logo";
//        String text ="What is on logo?";
//        String[] options = {"Robot","leaf","cup of coffee","bug"};
//
//        Quiz myQuiz = new Quiz(title,text,options);
//
//        return myQuiz;
//    }
}
