package john.babybeach.repository;

import john.babybeach.model.Beach;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BeachRepository extends MongoRepository<Beach, String> {
    Beach findAllById(String id);
    Optional<Beach> findById(String id);
    Beach findByName(String name);

}
