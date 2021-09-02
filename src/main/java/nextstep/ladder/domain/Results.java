package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {
    private final List<StringValue> results;

    public Results(final List<String> results) {
        this.results = Collections.unmodifiableList(
                results.stream()
                        .map(StringValue::new)
                        .collect(Collectors.toList())
        );
    }

    public String indexOf(int index) {
        return results.get(index).getValue();
    }

    public int sizeOfResults() {
        return results.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
