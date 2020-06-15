package ladder.domain;

public class Draw {

    private boolean drawable;

    public Draw(boolean drawable) {
        this.drawable = drawable;
    }

    public static Draw of(boolean drawable) {
        return new Draw(drawable);
    }
}
