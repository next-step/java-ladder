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

        for (int i = 1; i < numberOfPositions - 1; i++) {
            links.add(nextLink(links, i));
        }

        return new Floor(numberOfPositions, links);
    }

    private Link nextLink(List<Link> links, int currentIndex) {
        if (isPreviousLinkNotLinked(links, currentIndex)) {
            return Link.of(random.nextBoolean());
        }
        return Link.UNLINKED;
    }

    private boolean isPreviousLinkNotLinked(List<Link> links, int currentIndex) {
        return !(links.get(currentIndex - 1).equals(Link.LINKED));
    }
}
