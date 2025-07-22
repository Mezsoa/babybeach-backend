package john.babybeach.service;

import john.babybeach.model.Vote;
import john.babybeach.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;


    public Vote getVotesByBeachId(String beachId) {
        return voteRepository.findByBeachId(beachId).orElse(new Vote(beachId, 0, 0));
    }

    public Vote vote(String beachId, boolean isUpvote) {
        Vote vote = voteRepository.findByBeachId(beachId)
                .orElse(new Vote(beachId, 0, 0));

        if (isUpvote) {
            vote.setUpvotes(vote.getUpvotes() + 1);
        } else {
            vote.setDownvotes(vote.getDownvotes() + 1);
        }

        return voteRepository.save(vote);
    }

}
