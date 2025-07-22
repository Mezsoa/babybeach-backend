package john.babybeach.service;

import john.babybeach.dto.AddBeach;
import john.babybeach.model.Beach;
import john.babybeach.repository.BeachRepository;
import org.springframework.stereotype.Service;

@Service
public class BeachService {

    private final BeachRepository beachRepository;

    public BeachService(BeachRepository beachRepository) {
        this.beachRepository = beachRepository;
    }

    public Beach getAllBeaches(String name) {
        return beachRepository.findByName(name);
    }
    public Beach getBeachById(String id) {
        return beachRepository.findAllById(id);
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
}
