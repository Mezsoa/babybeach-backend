package john.babybeach.repository;

import john.babybeach.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VoteRepository extends MongoRepository<Vote, String> {
    Optional<Vote> findByBeachId(int beachId);
}
