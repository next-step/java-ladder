package ladder.model;

public class LineUnit {

    private LineUnit next;

    private LineUnit previous;

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    public void addNext(LineUnit unit) {
        if (unit.hasPrevious() || this.hasNext()) {
            throw new IllegalArgumentException("이미 설정된 값이 존재합니다.");
        }
        if (!canAddNext()) {
            throw new IllegalStateException("가로라인은 중복될 수 없습니다.");
        }
        this.next = unit;
        unit.previous = this;
    }

    public boolean canAddNext() {
        return previous == null && next == null;
    }


}
