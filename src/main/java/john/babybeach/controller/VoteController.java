package john.babybeach.controller;

import john.babybeach.model.Vote;
import john.babybeach.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @GetMapping("/beach/{beachId}")
    public ResponseEntity<Vote> getVotesByBeachId(@PathVariable String beachId) {
        return ResponseEntity.ok(voteService.getVotesByBeachId(beachId));
    }

    @PostMapping("/beach/{beachId}")
    public ResponseEntity<Vote> vote(
            @PathVariable String beachId,
            @RequestParam boolean isUpvote) {
        return ResponseEntity.ok(voteService.vote(beachId, isUpvote));
    }
}
