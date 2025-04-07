package nextstep.ladder.domain;

public class GameResult {

    private final Results results;
    private final Ladder ladder;

    public GameResult(Results results, Ladder ladder) {
        this.results = results;
        this.ladder = ladder;
    }

    public String finalResult(int startIndex) {
        int finalIndex = ladder.finalIndex(startIndex);
        return results.getResults().get(finalIndex).getResult();
    }
}
