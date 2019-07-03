package ladderGame.domain;

public class Result {

    private final String content;
    private final Position position;

    private Result(String content, int position) {
        this.content = content;
        this.position = new Position(position);
    }

    public static Result of(String content, int position) {
        return new Result(content, position);
    }

    public boolean isEquals(Position targetPosition) {
        return this.position.equals(targetPosition);
    }

    public String getContent() {
        return content;
    }
}
