package nextstep.ladder.domain;

import java.util.List;

import static nextstep.ladder.utils.Util.convertArrayToList;

public class Result {

    public static final String DELIMITER = ",";
    private List<String> results;

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
}
