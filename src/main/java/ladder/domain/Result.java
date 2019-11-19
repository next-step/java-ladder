package ladder.domain;

import java.util.Objects;

public class Result {

    private static final int NAME_MAX_LENGTH = 6;
    private static final int NAME_LENGTH = 5;

    private String name;
    private int position;

    public Result(String name, int position) {
        this.name = name;
        this.position = position;
        validate();
    }

    public String getName() {
        return name;
    }

    boolean isPosition(int resultIndex) {
        return this.position == resultIndex;
    }

    public boolean isNameLength() {
        return this.name.length() <= NAME_LENGTH;
    }

    private void validate() {
        if (this.name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public int getEmptyLength() {
        return NAME_MAX_LENGTH - name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return position == result.position &&
                Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
