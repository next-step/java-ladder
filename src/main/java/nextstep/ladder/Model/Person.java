package nextstep.ladder.Model;

import java.util.Objects;

public class Person {

    private static final String NAME_IS_NOT_NULL_OR_BLANK_ERROR = "이름을 정할 때 Null 혹은 빈값을 올 수 없습니다.";
    private static final String NAME_LENGTH_LIMIT_ERROR = "이름은 5자를 초과할 수 없습니다";
    private static final int STANDARD_NAME_LENGTH = 5;
    private final String name;
    private Reward reward;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    public void offerReward(Reward reward) {
        this.reward = reward;
    }

    private void validate(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException(NAME_IS_NOT_NULL_OR_BLANK_ERROR);
        }
        if (isOverLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private boolean isOverLength(String name) {
        return name.length() > STANDARD_NAME_LENGTH;
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isEmpty();
    }

    public String allPeopleToString() {
        return name + " : " + reward.toString();
    }

    public String rewardToString() {
        return reward.toString();
    }

    @Override
    public String toString() {
        return name + " ".repeat(STANDARD_NAME_LENGTH - name.length());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person name1 = (Person) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
