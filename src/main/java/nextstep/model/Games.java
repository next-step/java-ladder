package nextstep.model;

public class Games {
    private final int limit;
    public int focus;

    public Games(int limit, int focus) {
        this.limit = limit;
        this.focus = focus;
    }

    public boolean isLeftBlock() {
        return this.focus == 0;
    }

    public boolean isRightBlock() {
        return focus >= limit;
    }

    public void toLeftFocus() {
        if (isLeftBlock()) {
            return;
        }
        focus--;
    }
    public void toRightFocus() {
        if (isRightBlock()) {
            return;
        }
        focus++;
    }

    public boolean isRightTrue(Points points) {
        if (isRightBlock()) {
            return false;
        }
        boolean isTrue = points.get(focus);
        if (isTrue) {
            toRightFocus();
        }
        return isTrue;
    }

    public boolean isLeftTrue(Points points) {
        if (isLeftBlock()) {
            return false;
        }
        boolean isTrue = points.get(focus - 1);
        if (isTrue) {
            toLeftFocus();
        }
        return isTrue;
    }

    @Override
    public String toString() {
        return "Games{" +
                "limit=" + limit +
                ", focus=" + focus +
                '}';
    }
}
