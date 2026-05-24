package Controller.Resource;

import lombok.Data;
import lombok.Getter;

@Data
public class PlatformResource {
    @Getter 
    String name;
    @Getter
    String imagePath;
}
