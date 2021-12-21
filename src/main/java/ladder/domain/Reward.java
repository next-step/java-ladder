package ladder.domain;

public class Reward implements LadderString {

    private final LadderStringValue ladderStringValue;

    public Reward(String value) {
        this.ladderStringValue = new LadderStringValue(value);
    }

    @Override
    public String value() {
        return ladderStringValue.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Reward reward = (Reward) o;

        return ladderStringValue != null ? ladderStringValue.equals(reward.ladderStringValue) : reward.ladderStringValue == null;
    }

    @Override
    public int hashCode() {
        return ladderStringValue != null ? ladderStringValue.hashCode() : 0;
    }

}
