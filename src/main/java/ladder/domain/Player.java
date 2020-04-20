package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LEN_LIMIT = 5;

    private final String name;
    private final int orderNumber;

    public Player(String name, int orderNumber) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > NAME_LEN_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }

        this.name = name;
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player that = (Player) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean matchByName(String name) {
        return this.name.equals(name);
    }
}
