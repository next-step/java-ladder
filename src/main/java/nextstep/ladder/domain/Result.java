package nextstep.ladder.domain;

public class Result {
    private String userName;
    private Position position;
    private String result;

    public Result(User user, String result) {
        this.userName = user.getName();
        this.position = new Position(user.getCurrentPosition());
        this.result = result;
    }

    public String getUserName() {
        return userName;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return userName + " : " + result;
    }
}
