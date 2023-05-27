package ladder.domain.name;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    public static final String DELIMITER = ",";

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = valid(names);
    }

    public static Names of(String names) {
        return of(Arrays.stream(splitString(names))
            .map(String::trim)
            .map(Name::of)
            .collect(Collectors.toList()));
    }

    public static Names of(List<Name> names) {
        return new Names(names);
    }

    public List<Name> names() {
        return List.copyOf(names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    public int count() {
        return names.size();
    }

    @Override
    public String toString() {
        return "Names{" +
            "names=" + names +
            '}';
    }

    public int properWidth() {
        return names.stream()
            .map(x -> x.length())
            .reduce(0, (a,b) -> a + b) / count();
    }

    private static String[] splitString(String names) {
        return names.split(DELIMITER);
    }

    private List<Name> valid(List<Name> names) {
        if (names == null || names.size() == 0) {
            throw new IllegalArgumentException("이름 목록은 빈 값일 수 없습니다.");
        }
        if (names.size() == 1) {
            throw new IllegalArgumentException("참가자는 두 명 이상이어야 합니다.");
        }
        return names;
    }

}
