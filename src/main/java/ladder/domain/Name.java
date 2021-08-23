package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Name {
    private static final String VALID_NAME_CHARACTER = "0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣";
    private static final String VALID_DELIMITER = ",";
    public static final String REGEX_SEPERATOR = "|";
    public static final String REGEX_PREFIX = "[";
    public static final String REGEX_SUFFIX = "]*";
    public static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자까지 입력할 수 있습니다. name : " + name);
        }
    }

    public static List<Name> of(String nameList) {
        validateNameList(nameList);
        return Arrays.stream(nameList.split(VALID_DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateNameList(String nameList) {
        if (!nameList.matches(validNameFormatRegex())) {
            throw new IllegalArgumentException("이름 리스트에 유효하지 않은 특수문자가 포함되어 있습니다.");
        }

    }

    private static String validNameFormatRegex() {
        return REGEX_PREFIX + VALID_NAME_CHARACTER + REGEX_SEPERATOR + VALID_DELIMITER + REGEX_SUFFIX;
    }

    public String getName() {
        return name;
    }
}
