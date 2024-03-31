package ladder.model.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListConverter {
    public static List<String> toList(String value) {
        String[] valueList = value.split(",");
        checkNull(valueList);

        List<String> result = Arrays.stream(valueList)
                .map(element -> element.replaceAll(" ", ""))
                .collect(Collectors.toList());

        return result;
    }

    private static void checkNull(String[] names) {
        Arrays.stream(names)
                .filter(name -> name == null || name.isBlank())
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("이름이 빈칸일수 없습니다");
                });
    }


}
