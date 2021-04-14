package nextstep.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<String> names;

    public Players(String[] names) {
        this.names = new ArrayList<>();
        boolean match = Arrays.stream(names)
                .anyMatch(s -> s.length() > 5);
        if (match) {
            throw new IllegalArgumentException("사람의 이름은 최대5글자까지 부여할 수 있습니다.");
        }
        for (String name : names) {
            this.names.add(name);
        }
    }
    public String names() {
        return names.stream()
                .collect(Collectors.joining(" ","",""));
    }
}
