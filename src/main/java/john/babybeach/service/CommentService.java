package john.babybeach.service;

import john.babybeach.model.Comment;
import john.babybeach.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;

    public List<Comment> getCommentByBeachId(int beachId) {
        return commentRepository.findByBeachId(beachId);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }


}
