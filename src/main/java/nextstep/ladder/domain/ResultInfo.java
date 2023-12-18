package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultInfo {

    private final List<String> results;

    public ResultInfo(String result, int participantCount) {
        this(checkResultSize(Arrays.stream(result.split(",")).collect(Collectors.toList()), participantCount));

    }

    private static List<String> checkResultSize(List<String> result, int participantCount) {
        checkResultAndParticipantCount(result, participantCount);
        return result;
    }

    public ResultInfo(List<String> results) {
        this.results = results;
    }

    private static void checkResultAndParticipantCount(List<String> result, int participantCount) {
        if (result.size() != participantCount) {
            throw new IllegalArgumentException("결과 갯수와 참가자 수와 다릅니다.");
        }
    }

    public List<String> getResults() {
        return results;
    }

    public String getResult(int position) {
        return results.get(position);
    }
}
