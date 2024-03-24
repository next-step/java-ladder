package ladder.domain;

import static ladder.domain.Link.LEFT_LINK;
import static ladder.domain.Link.NO_LINK;
import static ladder.domain.Link.RIGHT_LINK;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {

    private static final Random random = new Random();

    public static Line generate(int participantCount) {
        List<Link> links = new ArrayList<>();
        for (int i = 0; i < participantCount; i++) {
            links.add(nextPoint(links, participantCount));
        }
        return Line.from(links);
    }

    private static Link nextPoint(List<Link> links, int pointCount) {
        if (lastAddedPoint(links) == RIGHT_LINK) {
            return LEFT_LINK;
        }
        boolean isLastPoint = links.size() == pointCount - 1;
        if (isLastPoint) {
            return NO_LINK;
        }
        return randomPointOf(NO_LINK, RIGHT_LINK);
    }

    private static Link lastAddedPoint(List<Link> links) {
        if (links.isEmpty()) {
            return NO_LINK;
        }
        int lastIndex = links.size() - 1;
        return links.get(lastIndex);
    }

    private static Link randomPointOf(Link... links) {
        int randomIndex = random.nextInt(links.length);
        return links[randomIndex];
    }
}
