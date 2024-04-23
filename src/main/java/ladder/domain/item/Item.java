package ladder.domain.item;

import java.util.Objects;

public class Item {

    private final String name;

    public Item(final String name) {
        validateNameIsNotNullOrBlank(name);

        this.name = name;
    }

    private void validateNameIsNotNullOrBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("사다리 결과의 이름은 null이거나 비어있을 수 없습니다. 이름: " + name);
        }
    }

    public String name() {
        return this.name;
    }

    public Item copyOf() {
        return new Item(new String(this.name));
    }

    @Override
    public boolean equals(final Object otherItem) {
        if (this == otherItem) {
            return true;
        }

        if (otherItem == null || getClass() != otherItem.getClass()) {
            return false;
        }

        return Objects.equals(this.name, ((Item)otherItem).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
