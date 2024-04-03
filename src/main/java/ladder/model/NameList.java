package ladder.model;

import ladder.model.utils.StringToListConverter;

import java.util.List;
import java.util.regex.Pattern;

public class NameList {
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";
    private static List<String> nameList;

    public NameList(String nameList) {
        this.nameList = StringToListConverter.toList(nameList);
        checkDuplicate();
        checkPattern();
        checkLength();
    }

    private static void checkDuplicate() {
        if (nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException("이름은 중복일수 없습니다.");
        }
    }

    private static void checkPattern() {
        nameList.stream()
                .filter(name -> !Pattern.matches(NAME_PATTERN, name))
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("이름은 영어 대소문자 / 숫자만 포함 가능.");
                });
    }

    private static void checkLength() {
        nameList.stream()
                .filter(name -> name.length() > 5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("아이디는 5자 이하.");
                });
    }

    public int numOfName() {
        return nameList.size();
    }

    public List<String> getNameList() {
        return nameList;
    }
}
