package ladder.domain;

public class Benefit {

    private static final int STANDARD_LENGTH = 5;
    private String benefit;

    private Benefit(String benefit) {
        this.benefit = benefit;
    }

    public static Benefit from(String benefit) {
        return new Benefit(benefit);
    }

    private int getLengthCount() {
        return STANDARD_LENGTH - this.benefit.length();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.benefit);
        for (int i = 0; i < getLengthCount(); i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
