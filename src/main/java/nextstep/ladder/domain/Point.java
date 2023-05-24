package nextstep.ladder.domain;

public class Point {

    private int index;
    private final boolean previous;
    private final boolean current;

    Point(int index, boolean previous, boolean current) {
        this.index = index;
        this.previous = previous;
        this.current = current;
    }

    public int move() {
        if (previous){
            this.index--;
        }
        if (current) {
            this.index++;
        }
        return this.index;
    }
}
