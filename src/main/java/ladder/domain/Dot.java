package ladder.domain;

public class Dot {
    private int index;
    private Boolean value;

    public Dot(int index, Boolean value) {
        this.index = index;
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        Dot dot = (Dot)obj;
        return this.value == dot.value && this.index == ((Dot) obj).index;
    }
}
