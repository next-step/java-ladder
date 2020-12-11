package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private static final int MINIMUM_NUMBER_PERSON = 1;
    private final List<Boolean> links;

    private Row(List<Boolean> links) {
        this.links = links;
    }

    public static Row of(int numberPersons, LinkStrategy strategy) {
        if (numberPersons < MINIMUM_NUMBER_PERSON) {
            throw new IllegalArgumentException("numberPersons must be greater than " + MINIMUM_NUMBER_PERSON + " or equal");
        }
        final boolean[] context = { false };
        List<Boolean> links = IntStream.range(1, numberPersons)
                .mapToObj(i -> context[0] = !context[0] && strategy.tryLink() )
                .collect(Collectors.toList());
        return new Row(links);
    }

    public List<Boolean> getLinks() {
        return Collections.unmodifiableList(links);
    }
}
