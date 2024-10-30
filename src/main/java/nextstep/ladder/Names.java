package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {

    private static final String SPLIT_PATTERN = ",";
    private final List<String> names;

    public Names(List<String> names) {
        this.names = names;
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
