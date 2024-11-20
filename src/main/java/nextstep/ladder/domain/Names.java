package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.CommaSeparatedResult;

public class Names extends CommaSeparatedResult {

    private static final int MIN_SIZE = 2;
    private final List<Name> names;

    public Names(List<String> names) {
        if (inValidSize(names) || hasDuplication(names)) {
            throw new IllegalArgumentException("잘못된 이름입력입니다.");
        }
        this.names = List.copyOf(toNames(names));
    }

    private static List<Name> toNames(List<String> names) {
        return names.stream().map(Name::new).collect(Collectors.toList());
    }

    private boolean hasDuplication(List<String> result) {
        return distinctCount(result) != result.size();
    }

    private static long distinctCount(List<String> result) {
        return result.stream().distinct().count();
    }

    private static boolean inValidSize(List<String> names) {
        return names.size() < MIN_SIZE;
    }

    public Names(String value) {
        this(convert(value));
    }

    public List<String> getNamesByString() {
        return this.names.stream().map(Name::getName).collect(Collectors.toList());
    }

    @Override
    public int size() {
        return names.size();
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
}
