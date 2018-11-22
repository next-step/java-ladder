package ladder.domain;

public class Reward {

    private static final int STANDARD_LENGTH = 5;
    private String benefit;

    private Reward(String benefit) {
        this.benefit = benefit;
    }

    public static Reward from(String benefit) {
        return new Reward(benefit);
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