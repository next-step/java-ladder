package ladder.domain.core.line.name;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

final class Name {
    static final String ERROR_MESSAGE_REQUIRED_NAME = "이름을 지정해 주세요.";
    static final String ERROR_MESSAGE_SUITABLE_NAME = "참여하는 사람의 이름은 알파벳(a-z), 숫자(0-9)포함 5글자 입니다.";
    static final String REGEX_SUITABLE_NAME = "[a-z][a-z0-9]{0,4}";
    private static final int MAX_LEN = 5;
    static final String ERROR_MESSAGE_MAX_LEN_NAME = String.format("지정된 이름의 최대 길이는 %d자 입니다.", MAX_LEN);
    protected final String name;

    @SafeVarargs
    Name(String name, Consumer<String>... consumers) {
//        AS-IS
//        verifySuitableName(name);
//        verifyMaxLength(name);
//        verifyBlankName(name);
//
//        TO-BE
        Stream.of(consumers)
              .forEach(c -> c.accept(name));
        this.name = name;
    }

    static Name ofParticipant(String participants){
        return new Name(participants, Name::verifyBlankName, Name::verifySuitableName);
    }

    static Name ofLadderResults(String ladderResults){
        return new Name(ladderResults, Name::verifyBlankName, Name::verifyMaxLength);
    }

    String getName() {
        return name;
    }

    static void verifyBlankName(String name) {
        if (null == name || "".equals(name.trim())) {
            throw new IllegalArgumentException(ERROR_MESSAGE_REQUIRED_NAME);
        }
    }

    static void verifySuitableName(String name) {
        if (!name.matches(REGEX_SUITABLE_NAME)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUITABLE_NAME);
        }
    }

    static void verifyMaxLength(String name) {
        if (MAX_LEN < name.length()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_LEN_NAME);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name that = (Name) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
