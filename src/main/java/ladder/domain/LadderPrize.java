package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderPrize {

    private final List<String> result;

    public LadderPrize(final List<String> result) {
        this.result = new ArrayList<>(result);
    }

    public int size() {
        return result.size();
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }
}
