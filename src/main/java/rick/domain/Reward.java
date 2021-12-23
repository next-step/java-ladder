package rick.domain;

import java.util.Objects;

public class Reward {

    private static final String EXCEPTION_MESSAGE_TOO_LONG = "보상의 길이가 너무 깁니다. Max Length %d";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY = "보상은 빈 값일 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_NULL = "보상은 null 일 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Reward(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_NULL);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_TOO_LONG, MAX_NAME_LENGTH));
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
