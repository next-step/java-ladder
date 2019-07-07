package nextstep.step4.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladderLine
 * create date  : 2019-06-29 03:27
 */
public class LadderLine {
    private static final String CREATE_LIST_SIZE_EXCEPTION_MESSAGE = "사다리라인이 비어있습니다.";
    private static final String CREATE_LIST_MIN_SIZE_EXCEPTION_MESSAGE = "사다리라인의 최소 개수는 2개 입니다.";
    private static final String CHECK_START_INDEX = "일치하는 Index가 없습니다.";
    private static final int MIN_SIZE = 1;

    private final List<Link> links;

    public LadderLine(List<Link> links) {
        if (links == null || links.isEmpty()) {
            throw new IllegalArgumentException(CREATE_LIST_SIZE_EXCEPTION_MESSAGE);
        }
        if (links.size() <= MIN_SIZE) {
            throw new IllegalArgumentException(CREATE_LIST_MIN_SIZE_EXCEPTION_MESSAGE);
        }
        this.links = links;
    }

    public int moveLine(int startIndex) {
        return links.stream()
                .filter(link -> link.matchIndex(startIndex))
                .findFirst()
                .map(link -> link.move())
                .orElseThrow(() -> new IllegalArgumentException(CHECK_START_INDEX));
    }

    public Stream<Link> stream() {
        return links.stream();
    }
}
