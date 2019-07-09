package ladder.domain;

import java.util.Objects;

public class Reward {
    private final String name;

    public Reward(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getViewName() {
        StringBuilder name = new StringBuilder(getName());
        while (name.length() < Name.MAX_NAME_LENGTH) {
            name.insert(0, " ");
        }
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
