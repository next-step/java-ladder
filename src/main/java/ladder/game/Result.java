package ladder.game;

public class Result {
    private String result;

    public Result(String tempResults) {
        this.result = tempResults;
    }

    @Override
    public String toString() {
        return result;
    }
}

