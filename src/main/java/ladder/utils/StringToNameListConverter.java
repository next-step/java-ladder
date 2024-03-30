package ladder.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringToNameListConverter {
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";
    public static List<String> toList(String value) {
        String[] names = value.split(",");
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String noBlank = names[i].replaceAll(" ", "");
            nameList.add(noBlank);
        }
        checkPattern(nameList);
        return nameList;
    }

    private static void checkPattern(List<String> nameList){
        nameList.stream()
                .filter(name -> !Pattern.matches(NAME_PATTERN, name))
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("아이디는 영어 대소문자 / 숫자만 포함 가능.");
                });

        nameList.stream()
                .filter(name -> name.length() > 5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("아이디는 5자 이하.");
                });
    }

}
