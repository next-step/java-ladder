package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import ladder.util.SplitUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elements {

    public static final int MIN_COUNT_OF_PERSON = 2;
    private static final int EXCLUSION_POINT_VALUE = 1;

    private final List<Element> values;

    public Elements(String names) {
        this(convertToList(SplitUtil.split(names)));
    }

    public Elements(String... names) {
        this(convertToList(names));
    }

    public Elements(List<Element> values) {
        if (values.size() < MIN_COUNT_OF_PERSON) {
            throw new InvalidCountOfPersonException();
        }
        this.values = values;
    }

    private static List<Element> convertToList(String... names) {
        return IntStream.range(Position.MIN_VALUE, names.length)
                .mapToObj(index -> new Element(names[index], names.length - 1, index))
                .collect(Collectors.toList());
    }

    public int pointCount() {
        return values.size() - EXCLUSION_POINT_VALUE;
    }

    public List<Element> toList() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elements elements = (Elements) o;
        return Objects.equals(values, elements.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
