package ladder.domain.wrapper;

public class RewardName extends Name {
    public RewardName(String value) {
        super(value);
    }

    @Override
    public int length() {
        return name.length();
    }

    @Override
    public String name() {
        return name;
    }
}
