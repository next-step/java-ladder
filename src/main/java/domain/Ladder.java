package domain;

public class Ladder {

    private final Lines lines;

    public Ladder(int playerCount, int height) {
        this(Lines.of(playerCount, height));
    }

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public void accept(LadderVisitor visitor) {
        lines.accept(visitor);
    }

    public int getEndPoint(int position) {
        return 0;
    }
}
