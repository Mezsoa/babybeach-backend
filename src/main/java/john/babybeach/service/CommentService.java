package john.babybeach.service;

import john.babybeach.model.Comment;
import john.babybeach.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<Comment> getCommentByBeachId(String beachId) {
        return commentRepository.findByBeachId(beachId);
    }

    public Comment addComment(Comment comment) {
        if (comment.getId() == null) {
            return commentRepository.save(comment);
        }

        Optional<Comment> existingComment = commentRepository.findById(comment.getId());
        return existingComment.orElseGet(() -> commentRepository.save(comment));
    }



}
