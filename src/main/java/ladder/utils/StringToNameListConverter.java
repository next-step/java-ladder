package ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToNameListConverter {
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";

    public static List<String> toList(String value) {
        String[] names = value.split(",");

        checkNull(names);

        List<String> nameList = Arrays.stream(names)
                .map(name -> name.replaceAll(" ", ""))
                .collect(Collectors.toList());

        checkDuplicate(nameList);
        checkPattern(nameList);
        checkLength(nameList);
        return nameList;
    }

    private static void checkNull(String[] names) {
        Arrays.stream(names)
                .filter(name -> name == null || name.isBlank())
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("이름이 빈칸일수 없습니다");
                });
    }

    private static void checkDuplicate(List<String> nameList) {
        if (nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException("이름은 중복일수 없습니다.");
        }
    }

    private static void checkPattern(List<String> nameList) {
        nameList.stream()
                .filter(name -> !Pattern.matches(NAME_PATTERN, name))
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("아이디는 영어 대소문자 / 숫자만 포함 가능.");
                });
    }

    private static void checkLength(List<String> nameList) {
        nameList.stream()
                .filter(name -> name.length() > 5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("아이디는 5자 이하.");
                });
    }

}
