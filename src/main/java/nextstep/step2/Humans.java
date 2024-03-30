package nextstep.step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Humans {

    private final List<Human> humanList;

    public Humans(String names) {
        validation(names);
        this.humanList = Arrays.stream(names.split(","))
                .map(String::trim)
                .map(Human::new)
                .collect(Collectors.toList());
    }

    private void validation(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException("이름에는 null과 공백이 올 수 없습니다.");
        }
    }

    public List<Human> getHumanList() {
        return Collections.unmodifiableList(humanList);
    }
}
