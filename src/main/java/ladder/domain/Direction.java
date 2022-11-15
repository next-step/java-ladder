package ladder.domain;

public class Direction {

    private boolean next;

    private boolean previous;

    public boolean hasNext() {
        return next;
    }

    public boolean hasPrevious() {
        return previous;
    }

    public void addNext(Direction unit) {
        if (unit.hasPrevious() || this.hasNext()) {
            throw new IllegalArgumentException("이미 설정된 값이 존재합니다.");
        }
        if (!canAddNext()) {
            throw new IllegalStateException("가로라인은 중복될 수 없습니다.");
        }
        this.next = true;
        unit.previous = true;
    }

    public boolean canAddNext() {
        return !previous && !next;
    }


}
