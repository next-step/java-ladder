package nextstep.ladder.domain;

import java.util.Objects;

public class Person {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_PRINT_LENGTH = 6;
    private static final String BLANK = " ";
    private final String name;

    public Person(String name) {
        nullCheck(name);

        name = name.trim();

        lengthCheck(name);

        this.name = name;
    }

    @Override
    public String toString() {
        return nameForPrint();
    }

    private String nameForPrint() {
        return BLANK.repeat(NAME_PRINT_LENGTH - name.length()) + name;
    }

    private void nullCheck(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름을 입력해 주세요.");
        }
    }

    private void lengthCheck(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("참여자 이름은 1~5자로 설정 하세요.");
        }
    }
}
