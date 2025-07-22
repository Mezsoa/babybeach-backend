package john.babybeach.repository;

import john.babybeach.model.Beach;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BeachRepository extends MongoRepository<Beach, String> {
    Beach findByLocation(String location);
    Beach findByName(String name);

}
