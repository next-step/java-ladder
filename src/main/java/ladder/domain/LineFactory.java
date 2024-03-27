package ladder.domain;

import static ladder.domain.Link.LEFT_LINK;
import static ladder.domain.Link.NO_LINK;
import static ladder.domain.Link.RIGHT_LINK;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {

    private static final String CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE
        = "인스턴스화 불가 클래스입니다";
    private static final Random random = new Random();

    private LineFactory() {
        throw new AssertionError(CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE);
    }

    public static Line generate(int participantCount) {
        List<Link> links = new ArrayList<>();
        for (int i = 0; i < participantCount; i++) {
            links.add(nextLink(links, participantCount));
        }
        return Line.from(links);
    }

    private static Link nextLink(List<Link> links, int totalLinkCount) {
        if (prevLink(links) == RIGHT_LINK) {
            return LEFT_LINK;
        }
        boolean isLastLink = links.size() == totalLinkCount - 1;
        if (isLastLink) {
            return NO_LINK;
        }
        return randomLinkOf(NO_LINK, RIGHT_LINK);
    }

    private static Link prevLink(List<Link> links) {
        if (links.isEmpty()) {
            return NO_LINK;
        }
        int lastIndex = links.size() - 1;
        return links.get(lastIndex);
    }

    private static Link randomLinkOf(Link... links) {
        int randomIndex = random.nextInt(links.length);
        return links[randomIndex];
    }
}
