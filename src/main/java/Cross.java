public class Cross {
    private final int posX;
    private final int posY;
    private final Dot dot;

    private Cross(int posX, int posY, boolean left, boolean current) {
        this.posX = posX;
        this.posY = posY;
        this.dot = new Dot(left, current);
    }

    private Cross(int posX, int posY, Dot dot) {
        this.posX = posX;
        this.posY = posY;
        this.dot = dot;
    }

    public static Cross first(boolean current, int posY) {
        return new Cross(0, posY, false, current);
    }

    public Cross add(boolean current) {
        return new Cross(this.posX + 1, this.posY, this.dot.chain(current));
    }

    public Cross last() {
        return new Cross(this.posX + 1, this.posY, this.dot.chain(false));
    }

    public Pos move(Pos prevPos) {
        Direction direction = this.dot.move();

        if (direction == Direction.LEFT && !prevPos.xIs(this.posX - 1)) {
            return new Pos(this.posX - 1, this.posY);
        }

        if (direction == Direction.RIGHT && !prevPos.xIs(this.posX + 1)) {
            return new Pos(this.posX + 1, this.posY);
        }

        return new Pos(this.posX, this.posY + 1);
    }

    @Override
    public String toString() {
        return this.dot.toString();
    }
}
