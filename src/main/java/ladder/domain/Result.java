package ladder.domain;

public class Result {

    private final Name name;
    private final Reward reward;

    public Result(String name, String reward) {
        this(new Name(name), new Reward(reward));
    }

    public Result(Name name, Reward reward) {
        this.name = name;
        this.reward = reward;
    }

    public boolean matchName(String name) {
        return this.name.match(name);
    }

    public String name() {
        return name.value();
    }

    public String reward() {
        return reward.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Result result = (Result) o;

        if (name != null ? !name.equals(result.name) : result.name != null) {
            return false;
        }
        return reward != null ? reward.equals(result.reward) : result.reward == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (reward != null ? reward.hashCode() : 0);
        return result;
    }

}
