package ladder.model.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListConverter {
    public static List<String> toList(String value) {
        String[] valueList = value.split(",");
        checkNull(valueList);

        return Arrays.stream(valueList)
                .map(element -> element.replaceAll(" ", ""))
                .collect(Collectors.toList());
    }

    private static void checkNull(String[] valueList) {
        Arrays.stream(valueList)
                .filter(value -> value == null || value.isBlank())
                .findAny()
                .ifPresent(value -> {
                    throw new IllegalArgumentException("입력 항목이 빈칸일수 없습니다");
                });
    }


}
