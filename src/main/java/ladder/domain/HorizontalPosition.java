package ladder.domain;

import java.util.Objects;

public class HorizontalPosition {

    private int position;

    public HorizontalPosition(int position) {
        if (position < 0){
            throw new IllegalArgumentException("사용자 위치 인덱스 값은 0 보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    public void decrease(){
        this.position--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorizontalPosition that = (HorizontalPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
