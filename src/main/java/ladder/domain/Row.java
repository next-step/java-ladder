package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private static final int MINIMUM_NUMBER_PERSON = 1;
    private final List<Link> links;

    private Row(List<Link> links) {
        this.links = links;
    }

    public static Row of(int numberPersons, LinkStrategy strategy) {
        if (numberPersons < MINIMUM_NUMBER_PERSON) {
            throw new IllegalArgumentException("numberPersons must be greater than " + MINIMUM_NUMBER_PERSON + " or equal");
        }
        final boolean[] context = { false };
        List<Link> links = IntStream.range(1, numberPersons)
                .mapToObj(i -> new Link(i, context[0] = !context[0] && strategy.tryLink()) )
                .collect(Collectors.toList());
        return new Row(links);
    }

    public List<Link> getLinks() {
        return Collections.unmodifiableList(links);
    }

    public List<Integer> step(List<Integer> positions) {
        List<Integer> ret = new ArrayList<>(positions);
        links.forEach(link -> link.swapPosition(ret));
        return ret;
    }
}
