package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputLadderResult {

    private final List<String> results = new ArrayList<>();

    public InputLadderResult(String input) {
        results.addAll(Arrays.asList(input.split(",")));
    }

    public int size() {
        return results.size();
    }

    public String findResult(int index) {
        return results.get(index);
    }
}
