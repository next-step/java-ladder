package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rows {
    private final List<Row> values = new ArrayList<>();

    public Rows(Height height, Count playersCount, RungGenerateStrategy strategy) {
        this(IntStream.range(0, height.value())
                .mapToObj(idx -> new Row(playersCount, strategy))
                .collect(Collectors.toList()));
    }

    public Rows(List<Row> values) {
        if (values != null && !values.isEmpty()) {
            this.values.addAll(values);
        }
    }

    public Height height() {
        return new Height(this.values.size());
    }

    public void forEach(Consumer<Row> action) {
        values.forEach(action);
    }
}
