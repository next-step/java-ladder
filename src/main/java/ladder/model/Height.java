package ladder.model;

public class Height implements Comparable<Height> {
    private final int value;

    public Height(int value) {
        // TODO add constraint
        this.value = value;
    }


    @Override
    public int compareTo(Height o) {
        return Integer.compare(this.value, o.value);
    }
}
