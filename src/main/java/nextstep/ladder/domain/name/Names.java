package nextstep.ladder.domain.name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String DELIM = ",";
    private List<Name> nameList;

    public Names(String names) {
        this(parseNameString(names));
    }

    public Names(List<Name> nameList) {
        if (nameList == null || nameList.isEmpty()) {
            throw new IllegalArgumentException("이름 문자열은 빈공백일 수 없습니다.");
        }
        this.nameList = nameList;
    }

    private static List<Name> parseNameString(String names) {
        return Arrays.stream(names.split(DELIM))
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
