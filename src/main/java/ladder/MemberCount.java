package ladder;

public class MemberCount {
    private int count;

    public MemberCount(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Member count must be greater than zero.");
        }
        this.count = count;
    }

    public int toInt() {
        return count;
    }
}
