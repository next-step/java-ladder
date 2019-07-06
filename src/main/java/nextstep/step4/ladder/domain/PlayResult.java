package nextstep.step4.ladder.domain;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 17:58
 */
public class PlayResult {
    public static final String NO_SEARCH_PRIZE = "일치하는 Prize가 없습니다.";
    private final Map<Integer, Integer> result;

    public PlayResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    public Prize findPrizeByIndex(int findIndex, PrizeInfo prizeInfo) {
        int endIndex = result.get(findIndex);
        return prizeInfo.stream()
                .filter(prize -> prizeInfo.matchAttribute(prize, endIndex))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NO_SEARCH_PRIZE));
    }

    public Name findNameByIndex(int findIndex, Participant participant) {
        return participant.stream()
                .filter(name -> participant.matchAttribute(name, findIndex))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NO_SEARCH_PRIZE));
    }

    public Stream<Integer> keySet() {
        return result.keySet().stream();
    }
}
