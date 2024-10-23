package tn.esprit.user.entities;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "QuizSubmission ")
@Data
public class QuizSubmission {
    @Id
    private String _id;

    private String userId;
    private String quizId;
    private int score;
    private Cours cours;

    // Getter and other methods

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
