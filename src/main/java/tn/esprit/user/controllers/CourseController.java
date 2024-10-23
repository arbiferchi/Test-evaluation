package tn.esprit.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.user.entities.Cours;
import tn.esprit.user.entities.Quiz;
import tn.esprit.user.repositories.CoursRepository;
import tn.esprit.user.repositories.QuizRepository;

@RestController
public class CourseController {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private QuizRepository quizRepository;

    @PostMapping("/courses/{courseId}/quizzes/{quizId}")
    public ResponseEntity<String> addQuizToCourse(@RequestParam String courseId, @RequestParam String quizId) {
        Cours course = coursRepository.findById(courseId).orElse(null);
        Quiz quiz = quizRepository.findById(quizId).orElse(null);

        if (course != null && quiz != null) {
            // Add the quiz to the course's list of quizzes
            course.getQuizzes().add(quiz);
            // Set the course for the quiz
            quiz.setCours(course);
            // Save the updated course and quiz
            coursRepository.save(course);
            quizRepository.save(quiz);
            return ResponseEntity.ok("Quiz added to course successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course or quiz not found");
        }
    }
}
