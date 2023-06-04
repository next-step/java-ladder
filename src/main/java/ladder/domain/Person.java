package ladder.domain;

import ladder.domain.enums.Direction;

public class Person {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Person(String name, int position) {
        validateName(name);

        this.name = name.trim();
        this.position = position;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 Null 또는 빈값이 입력되었습니다.");
        }

        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 최대허용길이(" + MAX_NAME_LENGTH + ")를 초과하였습니다");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(obj);
    }

    public int getPosition() {
        return position;
    }
}
