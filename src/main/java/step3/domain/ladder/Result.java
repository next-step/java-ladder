package step3.domain.ladder;

import java.util.List;

public class Result {
    private final List<String> results;

    private Result(List<String> results) {
        this.results = results;
    }

    public static Result of(List<String> results) {
        return new Result(results);
    }

    public String findResultOf(int index) {
        return results.get(index);
    }

    public void validateResultSize(int ladderWidth) {
        if (results.size() != ladderWidth) {
            throw new RuntimeException("게임 결과의 갯수는 사다리 참여자의 수와 동일해야 합니다.");
        }
    }
}
