package nextstep.ladder.domain;

public class Name {
    private static final int MAX_SIZE_OF_NAME = 5;

    private final String name;

    public Name(String name) {
        String stripName = name.strip();
        checkNameValidation(stripName);
        this.name = stripName.strip();
    }

    private void checkNameValidation(String name) {
        isNullOrEmpty(name);
        checkNameLength(name);
    }

    private void isNullOrEmpty(String name) {
        if (isNull(name) || isEmpty(name)) {
            throw new IllegalArgumentException("참가자 이름을 입력하지 않았습니다. 입력해주세요.");
        }
    }

    private boolean isNull(String name) {
        return name == null;
    }

    private boolean isEmpty(String name) {
        return name.isEmpty();
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_SIZE_OF_NAME) {
            throw new IllegalArgumentException("이름 길이는 5글자를 초과할 수 없습니다. - " + name);
        }
    }

}
