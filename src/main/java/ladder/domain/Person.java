package ladder.domain;

import java.util.List;

public class Person {

    public static final int MAX_LENGTH = 5;

    private final String name;
    private Integer position;

    public Person(String name, int position) {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 자입니다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public String spaceAddedName() {
        return String.format("%6s", name);
    }

    public int move(List<Boolean> lineCondition) {
        if (position < lineCondition.size() && lineCondition.get(position)) {
            this.position = position + 1;
            return position;
        }
        if (position - 1 >= 0 && lineCondition.get(position - 1)) {
            this.position = position - 1;
            return position;
        }
        return position;
    }
}
