package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.IllegalMaxLengthValueException;

public class Prize {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE =
            "실행결과 이름은 %d글자를 넘을 수 없습니다.";
    private String name;

    public Prize(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalMaxLengthValueException(
                    String.format(MAX_NAME_LENGTH_ERROR_MESSAGE,
                            MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
