package nextstep.step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Entries {

    private final List<Participant> entries;

    public Entries(String names) {
        validation(names);
        this.entries = Arrays.stream(names.split(","))
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private void validation(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException("이름에는 null과 공백이 올 수 없습니다.");
        }
    }

    public List<Participant> getHumanList() {
        return Collections.unmodifiableList(entries);
    }
}
