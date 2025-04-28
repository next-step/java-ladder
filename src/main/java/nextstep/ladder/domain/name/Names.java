package nextstep.ladder.domain.name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final String DELIM = ",";
    private List<Name> nameList;
    public Names(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("이름 문자열은 빈공백일 수 없습니다.");
        }

        nameList = Arrays.stream(names.split(DELIM))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> values() {
        return nameList;
    }

    public int count() {
        return nameList.size();
    }
}
