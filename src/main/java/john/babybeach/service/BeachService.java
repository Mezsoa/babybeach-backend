package john.babybeach.service;

import john.babybeach.dto.AddBeach;
import john.babybeach.model.Beach;
import john.babybeach.repository.BeachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeachService {
    private final BeachRepository beachRepository;

    @Autowired
    public BeachService(BeachRepository beachRepository) {
        this.beachRepository = beachRepository;
    }
    public List<Beach> getAllBeaches() {
        return beachRepository.findAll();
    }

    public Beach getFromDTO(AddBeach beachDto) {

        Beach beach = new Beach();

        beach.setRank(beachDto.getRank());
        beach.setName(beachDto.getName());
        beach.setDescription(beachDto.getDescription());
        beach.setLocation(beachDto.getLocation());
        beach.setFeatures(beachDto.getFeatures());
        beach.setBabyFriendly(beachDto.isBabyFriendly());
        beach.setAccessibility(beachDto.getAccessibility());
        beach.setSafetyRating(beachDto.getSafetyRating());

        return beachRepository.save(beach);
    }

    public Optional<Beach> getBeachById(String id) {
        return beachRepository.findById(id);
    }
}
