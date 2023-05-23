package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

public class LadderResult implements Iterable<String> {

    private final List<String> results;

    public static LadderResult of(Participants participants, List<String> results) {
        validateIfHasSameNum(participants, results);
        return new LadderResult(results);
    }

    private static void validateIfHasSameNum(Participants participants,List<String> results) {
        if (participants.isNotSameNum(results.size())) {
            throw new IllegalArgumentException("참여자 수와 같은 결과 수를 입력하셔야 합니다.");
        }
    }

    private LadderResult(List<String> results) {
        this.results = List.copyOf(results);
    }

    @Override
    public Iterator<String> iterator() {
        return results.iterator();
    }

    public String get(int index) {
        return results.get(index);
    }
}