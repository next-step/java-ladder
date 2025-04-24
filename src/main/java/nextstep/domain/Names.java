package nextstep.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * 전체 인원
 */
public class Names {
    private final List<Name> names;

    public Names(String names) {
        List<Name> list = makeNamesStringToList(names);
        validate(list);
        this.names = list;
    }

    public static Names of(String name) {
        return new Names(name);
    }

    private void validate(List<Name> names) {
        int distinct = (int)names.stream()
            .distinct()
            .count();
        if (distinct != names.size()) {
            throw new IllegalArgumentException("중복된 이름은 올 수 없습니다.");
        }
    }

    private List<Name> makeNamesStringToList(String names) {
        return Arrays.stream(names.split(","))
            .map(String::trim)
            .map(Name::of)
            .collect(Collectors.toList());
    }

    public int size() {
        return names.size();
    }
  
    public int getIndex(Name name) {
        return names.indexOf(name);
    }

    public List<Name> unmodifiableNames() {
        return Collections.unmodifiableList(names);
    }
}
