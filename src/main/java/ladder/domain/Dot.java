package ladder.domain;

public class Dot {
    private Boolean value;

    public Dot(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        Dot dot = (Dot)obj;
        return this.value == dot.value;
    }
}
