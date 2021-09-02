package ladderrefactoring.domain.data;

import ladderrefactoring.exception.CustomException;

import java.util.Objects;
import java.util.Optional;

public abstract class Data {

    public static final int MAX_LENGTH_OF_NAME = 5;
    public static final int ZERO_LENGTH_OF_NAME = 0;
    public static final String LENGTH_OF_NAME_EXCEPTION_MESSAGE = "이름 양식 오류. 최대 " + MAX_LENGTH_OF_NAME + "자";
    public static final String EMPTY_STRING_EXCEPTION_MESSAGE = "이름 양식 오류. 빈 값 미허용";

    private final String name;

    public Data(String name) {
        this.name = Optional.ofNullable(name)
                .map(String::trim)
                .map(this::validateEmptyString)
                .map(this::validateLengthOfName)
                .orElseThrow(
                        () -> new CustomException(EMPTY_STRING_EXCEPTION_MESSAGE)
                );
    }

    private String validateLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new CustomException(LENGTH_OF_NAME_EXCEPTION_MESSAGE + "입력값 : " + name);
        }
        return name;
    }

    private String validateEmptyString(String name) {
        if (name.length() == ZERO_LENGTH_OF_NAME) {
            throw new CustomException(EMPTY_STRING_EXCEPTION_MESSAGE);
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(name, data.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
