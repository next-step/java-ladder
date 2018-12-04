package domain;

public enum Point {

    EXIST(true),
    NONE(false);

    private boolean existence;

    Point(final boolean existence) {
        this.existence = existence;
    }

    public boolean isExistence() {
        return this.existence;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Point{");
        sb.append("existence=").append(existence);
        sb.append('}');
        return sb.toString();
    }

    public int move() {

        if (this.existence) {
            return 1;
        }

        return 0;
    }

}
