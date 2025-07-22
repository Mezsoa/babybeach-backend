package john.babybeach.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "votes")
public class Vote {

    @Id
    private String id;
    private int beachId;
    private int upvotes;
    private int downvotes;
    private Map<String, Integer> userVotes; // userId -> vote

    public Vote(int beachId, int upvotes, int downvotes) {
        this.beachId = beachId;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

}
