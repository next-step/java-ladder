package ladder.domain.result;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Position;
import ladder.exception.LadderGameException;

public class ResultPrize {

    private static final int START_INDEX = 0;
    private static final String PRIZES_COUNT_SHOULD_EQUAL_PARTICIPANT_COUNT = "사다리 타기 결과와 참가자 수가 다릅니다.";

    private final Map<Position, String> resultMap;

    public ResultPrize(String[] names, int participantsCount) {
        if (names.length != participantsCount) {
            throw new LadderGameException(PRIZES_COUNT_SHOULD_EQUAL_PARTICIPANT_COUNT);
        }
        this.resultMap = IntStream.range(START_INDEX, names.length)
            .boxed()
            .collect(Collectors.toMap(Position::new, index -> names[index], (integer1, integer2) -> integer1, LinkedHashMap::new));
    }

    public Collection<String> getResultPrizeNames() {
        return resultMap.values();
    }

    public String getResultByResultPosition(Position resultPosition) {
        return resultMap.get(resultPosition);
    }
}
