package ladder.model.gameresult;

public class GameResult {

    private final String name;
    private final int resultIndex;

    public GameResult(String name, int resultIndex) {
        this.name = name;
        this.resultIndex = resultIndex;
    }

    public int resultIndex() {
        return this.resultIndex;
    }

    public String name() {
        return this.name;
    }
}
