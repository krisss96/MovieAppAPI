package Controller.Resource;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class MoodResource {
    private String name;

    @JsonAlias("moodCover")
    private String moodCoverPath;
}
