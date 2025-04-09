package laddergameRDD.domain;

public class GameResult {
    private final String name;
    private final String result;

    public GameResult(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getUserName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
