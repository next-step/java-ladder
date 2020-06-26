package ladder.domain.play;

import java.util.Objects;

public class Item {
    private static final int MAX_LENGTH = 5;

    private final String input;

    private Item(final String input) {
        isNotNullOrEmpty(input);
        validateMaxLength(input);
        this.input = input;
    }

    private void isNotNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }

    private void validateMaxLength(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("입력 값은 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    public static Item of(final String input) {
        return new Item(input);
    }

    public String getInput() {
        return input;
    }

    public boolean same(String name) {
        return this.input.equals(name);
    }

    @Override
    public String toString() {
        return String.format("%6s", input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(input, item.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
