package ladder.domain;

import ladder.constant.Type;
import ladder.exception.InvalidCountOfElementException;
import ladder.exception.NotFoundElementException;
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

    public Elements(List<Element> values) {
        if (values.size() < MIN_COUNT_OF_PERSON) {
            throw new InvalidCountOfElementException();
        }
        this.values = values;
    }

    public static Elements createPlayers(String names) {
        return new Elements(convertToList(SplitUtil.split(names), Type.UNFIXED));
    }

    public static Elements createResults(String names) {
        return new Elements(convertToList(SplitUtil.split(names), Type.FIXED));
    }

    private static List<Element> convertToList(String[] names, Type type) {
        return IntStream.range(Position.MIN_VALUE, names.length)
                .mapToObj(index -> new Element(names[index], new Position(names.length - 1, index, type)))
                .collect(Collectors.toList());
    }

    public int pointCount() {
        return values.size() - EXCLUSION_POINT_VALUE;
    }

    public List<Element> toList() {
        return Collections.unmodifiableList(values);
    }

    public boolean sameSize(Elements otherElements) {
        return values.size() == otherElements.values.size();
    }

    public int size() {
        return values.size();
    }

    public int maxNameSize() {
        return values.stream()
                .mapToInt(Element::nameSize)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public Element value(Name name) {
        return values.stream()
                .filter(element -> element.sameName(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundElementException(name.toString()));
    }

    public Element value(Position position) {
        return values.stream()
                .filter(element -> element.samePosition(position))
                .findFirst()
                .orElseThrow(RuntimeException::new);
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
