package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class InputLadderResult {

    private final List<String> results = new ArrayList<>();

    public InputLadderResult(String input) {
        results.addAll(Arrays.asList(input.split(",")));
    }

    public int size() {
        return results.size();
    }

    String findResult(int index) {
        return results.get(index);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputLadderResult that = (InputLadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
