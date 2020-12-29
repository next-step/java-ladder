package nextstep.ladder.domain.floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFloorFactory implements FloorFactory {

    private final Random random = new Random();

    @Override
    public Floor generate(int numberOfPositions) {
        List<Link> links = new ArrayList<>();
        Link initial = Link.of(random.nextBoolean());
        links.add(initial);

        Link previous = initial;
        for (int i = 1; i < numberOfPositions - 1; i++) {
            Link next = previous.nextLink(random.nextBoolean());
            links.add(next);
            previous = next;
        }

        return new Floor(numberOfPositions, links);
    }
}
