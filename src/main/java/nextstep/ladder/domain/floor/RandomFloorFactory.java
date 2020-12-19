package nextstep.ladder.domain.floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFloorFactory implements FloorFactory {

    private final Random random = new Random();

    @Override
    public Floor generate(int maxLinks) {
        List<Boolean> links = new ArrayList<>();
        boolean initial = random.nextBoolean();
        links.add(initial);

        for (int i = 1; i < maxLinks; i++) {
            links.add(nextLink(links, i));
        }

        return new Floor(links);
    }

    private boolean nextLink(List<Boolean> links, int currentIndex) {
        if (isPreviousLinkNotLinked(links, currentIndex)) {
            return random.nextBoolean();
        }
        return false;
    }

    private boolean isPreviousLinkNotLinked(List<Boolean> links, int currentIndex) {
        return !links.get(currentIndex - 1);
    }

}
