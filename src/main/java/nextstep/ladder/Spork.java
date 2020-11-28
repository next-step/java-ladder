package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * |-----|     |-----| 의 경우 첫번째는 1~2 구간에는 발판이 있고 2~3구간에는 발판이 없고 3~4 구간에는 발판이 있다.
 * 이를 Spork.of(true, false, true) 로 표현한다
 */
class Spork {
    private final List<Boolean> list = new ArrayList<>();

    public static Spork of(Boolean... existsSpoke) {
        return Stream.of(existsSpoke)
                .collect(collect());
    }

    public static Spork fromCount(int count, BooleanGenerator booleanGenerator) {
        return IntStream.range(0, count)
                .mapToObj(number -> booleanGenerator.nextBoolean())
                .collect(collect());
    }

    private static Collector<Boolean, Spork, Spork> collect() {
        return Collector.of(Spork::new,Spork::add, (spork, spork2) -> {
            throw new UnsupportedOperationException("병렬처리는 지원하지 않습니다.");
        });
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
        Spork spork = (Spork) o;
        return list.equals(spork.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "Spork{" +
                "list=" + list +
                '}';
    }
}
