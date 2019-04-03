package ladder.dto;

public class Reward {
    private String name;

    public Reward(String name) {
        this.name = name;
    }

    public int getRewardLength() {
        return name.length();
    }

    @Override
    public String toString() {
        return name;
    }
}
