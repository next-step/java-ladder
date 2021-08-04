package ladder.dto.request;

import java.util.List;

public class LadderRequest {
    private final List<String> prizeNames;
    private final int lineHeight;

    public LadderRequest(List<String> prizeNames, int lineHeight) {
        this.lineHeight = lineHeight;
        this.prizeNames = prizeNames;
    }

    public List<String> prizeNames() {
        return prizeNames;
    }

    public int lineHeight() {
        return lineHeight;
    }
}
