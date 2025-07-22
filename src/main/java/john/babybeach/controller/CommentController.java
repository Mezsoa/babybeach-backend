package john.babybeach.controller;

import john.babybeach.model.Comment;
import john.babybeach.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/beach/{beachId}")
    public ResponseEntity<List<Comment>> getCommentsByBeachId(@PathVariable String beachId) {
        return ResponseEntity.ok(commentService.getCommentByBeachId((beachId)));
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.addComment(comment));
    }



}
