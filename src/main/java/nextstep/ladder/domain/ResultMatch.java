package nextstep.ladder.domain;

public class ResultMatch {
    private final Result result;
    private final Ladder ladder;

    public ResultMatch(Result result, Ladder ladder) {
        this.result = result;
        this.ladder = ladder;
    }

    public String match(String memberName) {
        Position resultPosition = ladder.move(memberName);
        return result.result(resultPosition);
    }
}
