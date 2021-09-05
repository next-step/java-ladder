package nextstep.ladder;

public class Result {

    private String name;
    private Position position;

    private Result(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Result of(String name, Position position) {
        return new Result(name, position);
    }
}
