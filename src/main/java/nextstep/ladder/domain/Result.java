package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static nextstep.ladder.utils.Util.convertArrayToList;

public class Result implements Iterable<String> {

    public static final String DELIMITER = ",";
    private final List<String> results;
    private final Map<String, String> gameResults = new HashMap<>();

    public static Result of(Participants participants, String resultList) {
        String[] splitResults = resultList.split(DELIMITER);
        validateIfHasSameNum(participants, splitResults);
        return new Result(convertArrayToList(splitResults));
    }

    private static void validateIfHasSameNum(Participants participants, String[] splitResults) {
        if (participants.isNotSameNum(splitResults.length)) {
            throw new IllegalArgumentException("참여자 수와 같은 결과 수를 입력하셔야 합니다.");
        }
    }

    private Result(List<String> results) {
        this.results = List.copyOf(results);
    }

    @Override
    public Iterator<String> iterator() {
        return results.iterator();
    }

    public String calculateResult(Participants participants, String name, List<Line> ladder) {
        int index = participants.indexOf(name);
        int maxIndex = participants.maxIndex();

        for (Line line : ladder) {
            if (index != maxIndex && line.get(index)) {
                index++;
                continue;
            }
            if (index - 1 >= 0 && line.get(index - 1)) {
                index--;
            }
        }
        return results.get(index);
    }
}
