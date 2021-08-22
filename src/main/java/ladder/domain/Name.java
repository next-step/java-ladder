package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Name {
    public static final String VALID_NAME_CHARACTER = "[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝|,]*";
    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자까지 입력할 수 있습니다. name : " + name);
        }
    }

    public static List<Name> of(String nameList) {
        validateNameList(nameList);
        return Arrays.stream(nameList.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateNameList(String nameList) {
        if (!nameList.matches(VALID_NAME_CHARACTER)) {
            throw new IllegalArgumentException("이름 리스트에 유효하지 않은 특수문자가 포함되어 있습니다.");
        }

    }

    public String getName() {
        return name;
    }
}
