package engine;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Quiz {
    public int id;

    @NotBlank
    public String title;

    @NotBlank
    public String text;

    @NotEmpty
    @Size(min = 2)
    public String[] options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public int[] answer;

    public Quiz(){

    }


    //setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setOptions(String[] options) {
        this.options = options;
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

    public String[] getOptions() {
        return options;
    }



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
