package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static nextstep.ladder.utils.BinaryOperators.nope;

/**
 * |-----|     |-----| 의 경우 첫번째는 1~2 구간에는 발판이 있고 2~3구간에는 발판이 없고 3~4 구간에는 발판이 있다.
 * 이를 Spoke.of(true, false, true) 로 표현한다
 */
public class Spoke {
    private final List<Boolean> list = new ArrayList<>();

    public static Spoke of(Boolean... existsSpoke) {
        return Stream.of(existsSpoke)
                .collect(collect());
    }

    public static Spoke fromCount(int count, BooleanGenerator booleanGenerator) {
        return IntStream.range(0, count)
                .mapToObj(number -> booleanGenerator.nextBoolean())
                .collect(collect());
    }

    private static Collector<Boolean, Spoke, Spoke> collect() {
        return Collector.of(Spoke::new, Spoke::add, nope());
    }

    public Line toLine() {
        return new Line(this.list);
    }

    private void add(Boolean next) {
        if (list.isEmpty()) {
            list.add(next);
            return;
        }

        if (last()) {
            list.add(Boolean.FALSE);
            return;
        }

        list.add(next);
    }

    private Boolean last() {
        return list.get(list.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Spoke spoke = (Spoke) o;
        return list.equals(spoke.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "Spoke{" +
                "list=" + list +
                '}';
    }
}
