package ladder.DTO;

import java.util.List;

public class LadderDTO {

    private final List<List<Boolean>> layout;

    public LadderDTO(List<List<Boolean>> layout) {
        this.layout = layout;
    }

    public List<List<Boolean>> getLayout() {
        return this.layout;
    }
}
