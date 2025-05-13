package nextstep.ladder2.domain.reward;

import java.util.Objects;

public class Reward {

    private String name;

    public Reward(String name) {
        if (null == name || name.isBlank()) {
            throw new IllegalArgumentException("보상은 null이거나 빈값일 수 없습니다. reward=" + name);
        }
        
        if (name.length() > 5) {
            throw new IllegalArgumentException("보상은 최대 5글자까지만 허용됩니다. reward=[" + name + "]");
        }
        
        this.name = name.trim();
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(this.name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}