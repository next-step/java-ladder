package ladderGame.domain;

public class LadderResult {

    private final String content;
    private final Position position;

    private LadderResult(String content, int position) {
        this.content = content;
        this.position = new Position(position);
    }

    public static LadderResult of(String content, int position) {
        return new LadderResult(content, position);
    }

    public boolean isEquals(Position targetPosition) {
        return this.position.equals(targetPosition);
    }

    public String getContent() {
        return content;
    }
}
