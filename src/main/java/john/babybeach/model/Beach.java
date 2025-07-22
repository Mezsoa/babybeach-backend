package john.babybeach.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "beaches")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Beach {

    @Id
    private String id;
    private int rank;
    private String name;
    private String description;
    private String location;
    private List<String> features = new ArrayList<>();
    private boolean babyFriendly;
    private String accessibility;
    private int safetyRating;
}
