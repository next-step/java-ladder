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
        System.out.println(focus + "...points.toString() = " + points.toString());
        boolean isTrue = points.get(focus);
        if (isTrue) {
            toRightFocus();
        }
        return isTrue;
    }

    public boolean isLeftTrue(Points points) {
        if (focus == 0) return false;
        boolean isTrue = points.get(focus - 1);
        if (isTrue) {
            toLeftFocus();
        }
        return isTrue;
    }
}
