package domain;

public class User {
    private String name;
    private String gameResult;

    public User(String userName) {
        name = userName;
    }

    public String getName() {
        return name;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public String getGameResult() {
        return gameResult;
    }
}
