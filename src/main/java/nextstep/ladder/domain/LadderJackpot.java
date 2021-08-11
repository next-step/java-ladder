package nextstep.ladder.domain;

public class LadderJackpot{
    private final String ladderResults;

    private LadderJackpot(String ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderJackpot of(String ladderResults) {
        return new LadderJackpot(ladderResults);
    }

    public String findJackpot() {
        return ladderResults;
    }

    @Override
    public String toString() {
        return ladderResults;
    }
}
