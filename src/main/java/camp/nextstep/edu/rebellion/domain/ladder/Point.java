package camp.nextstep.edu.rebellion.domain.ladder;

public class Point {
    private boolean prev;
    private boolean next;

    public boolean canMark() {
        return !(this.prev) && !(this.next);
    }
    public void markOnPrev() {
        this.prev = true;
    }
    public void markOnNext() {
        this.next = true;
    }
    public boolean hasPrev() {
        return this.prev;
    }
    public boolean hasNext() {
        return this.next;
    }
}
