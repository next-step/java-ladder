package step2.domain;

import java.util.List;

public class Users {
    public static final String NAME_LENGTH_EXCEPTION = "사람의 이름은 5글자까지 가능합니다.";
    private List<String> names;

    public Users(List<String> names) {
        names.stream()
                .forEach(name -> validateNames(name));
        this.names = names;

    }

    private static void validateNames(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION);
        }
    }
}
