package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {

    private static final String SPLIT_PATTERN = ",";
    private static final int MIN_SIZE = 2;
    private final List<String> names;

    public Names(List<String> names) {
        if (inValid(names)) {
            throw new IllegalArgumentException("잘못된 이름입력입니다.");
        }
        this.names = names;
    }

    private static boolean inValid(List<String> names) {
        return containInValidName(names) || inValidSize(names);
    }

    private static boolean inValidSize(List<String> names) {
        return names.size() < MIN_SIZE;
    }

    private static boolean containInValidName(List<String> names) {
        return names.stream().anyMatch(name -> name.length() > 5 || name.isBlank());
    }

    public Names(String value) {
        this(toList(split(value)));
    }

    private static String[] split(String value) {
        return value.split(SPLIT_PATTERN);
    }

    private static List<String> toList(String[] value) {
        return Arrays.asList(value);
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
