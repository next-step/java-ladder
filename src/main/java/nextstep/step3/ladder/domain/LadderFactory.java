package nextstep.step3.ladder.domain;

import java.util.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 02:03
 */
public class LadderFactory {

    public static final int NEXT_INDEX = 1;
    public static final int LAST_INDEX = 1;

    public static Ladder create(int row, int line) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            lines.add(createLine(line));
        }
        return new Ladder(lines);
    }

    public static Map<Integer, Integer> play(Ladder ladder, int participantCount) {
        Map<Integer, Integer> executeReuslt = new HashMap<>();
        for (int i = 0; i < participantCount; i++) {
            executeReuslt.put(i, ladder.execute(i));
        }
        return executeReuslt;
    }

    private static LadderLine createLine(int line) {
        List<Link> links = new ArrayList<>();
        links.add(Link.first(() -> random()));
        for (int i = NEXT_INDEX; i < line - LAST_INDEX; i++) {
            links.add(nextLink(links.get(i - NEXT_INDEX)));
        }
        links.add(Link.last(links.get(links.size() - LAST_INDEX)));
        return new LadderLine(links);
    }

    private static Link nextLink(Link leftLink) {
        return Link.next(leftLink, () -> leftLink.status() ? false : random());
    }

    private static boolean random() {
        return new Random().nextBoolean();
    }
}
