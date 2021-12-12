package api.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PetPojo {

    private int id;
    private Map<String, Object> category;
    private String name;
    private List<String> photoUrls;
    private List<Map<String, Object>> tags;
    private String status;

}
