package john.babybeach.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddBeach {
    private int rank;
    private String name;
    private String description;
    private String location;
    private List<String> features = new ArrayList<>();
    private boolean babyFriendly;
    private String accessibility;
    private int safetyRating;
}
