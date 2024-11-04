package ladder.domain;

public class Dot {
    private int index;
    private Boolean value;
    private Line line;

    public Dot(int index, Boolean value) {
        this.index = index;
        this.value = value;
    }

    public void toLine(Line line) {
        this.line = line;
    }

    public void setDot(Boolean value) {
        if (index == 0) {
            this.value = value;
            return;
        }
        if (index == line.getLengthOfLine() - 1) {
            return;
        }

        this.value = !line.getDotValue(index-1);
    }

    public static Dot ofInitDot(int index) {
        return new Dot(index, false);
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
