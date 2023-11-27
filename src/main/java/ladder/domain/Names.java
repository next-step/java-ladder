package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 여러개의 이름을 생성하는 유틸용 클래스.
 * @see Name
 */
public class Names {
    private Names() {
    }

    public static List<Name> of(String names) {
        return splitNames(names).stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitNames(String names) {
        return List.of(names.split(","));
    }
}