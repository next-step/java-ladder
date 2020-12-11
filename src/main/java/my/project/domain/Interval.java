package my.project.domain;

/**
 * Created : 2020-12-11 오전 11:03
 * Developer : Seo
 */
public enum Interval {
    FIRST(0),
    NEXT(1),
    LINE(1),
    VERTICAL(2),
    BRIDGE(2);

    private final int which;

    Interval(int which) {
        this.which = which;
    }

    public int value() {
        return which;
    }
}
