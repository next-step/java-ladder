package ladder.model;

public class Reward {

    private final String value;

    private int position;

    public Reward(String value) {
        this.value = value;
    }

    public Reward(String value, int position) {
        this.value = value;
        this.position = position;
    }

    public String getValue() {
        return value;
    }
}
