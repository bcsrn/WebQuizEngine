package engine;

public interface QuizService {
    public Quiz createQuiz(Quiz quiz);
    public Quiz findQuizById(Long id);
}