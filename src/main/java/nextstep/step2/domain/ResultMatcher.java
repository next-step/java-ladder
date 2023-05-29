package nextstep.step2.domain;

public class ResultMatcher {

    private final Ladder ladder;
    private final Result result;

    public ResultMatcher(Ladder ladder, Result result) {
        this.ladder = ladder;
        this.result = result;
    }

    public String match(String name) {
        final var index = ladder.move(name);
        return result.get(index);
    }
}
