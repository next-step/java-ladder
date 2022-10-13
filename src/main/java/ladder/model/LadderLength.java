package ladder.model;

import java.util.Objects;

public class LadderLength implements Comparable<LadderLength> {

    private int length;

    public LadderLength(int length) {
        if (length < 0 ){
            throw new IllegalArgumentException("사다리 높이는 음수가 올 수 없습니다.");
        }
        this.length = length;
    }

    public void increase(){
        this.length++;
    }


    @Override
    public int compareTo(LadderLength target) {
        return Integer.compare(this.length,target.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLength that = (LadderLength) o;
        return length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    public int getLength() {
        return length;
    }
}
