package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Connection> connections = new ArrayList<>();

    public Row(Count playersCount, RungGenerateStrategy strategy) {
        this.connections.addAll(generateRungs(playersCount, strategy));
    }

    private List<Connection> generateRungs(Count playersCount, RungGenerateStrategy strategy) {
        return Stream.iterate(Connection.EMPTY.generate(strategy),
                        previousRung -> previousRung.generate(strategy))
                .limit(playersCount.subtract(1).value())
                .collect(Collectors.toList());
    }

    public List<Connection> rungs() {
        return Collections.unmodifiableList(connections);
    }

    public ColumnIndex moveFrom(ColumnIndex columnIndex) {
        if (!columnIndex.equals(connections.size()) && isConnected(columnIndex)) {
            return columnIndex.next();
        }

        final ColumnIndex beforeIndex = columnIndex.before();
        if (columnIndex.isNotFirst() && isConnected(beforeIndex)) {
            return beforeIndex;
        }

        return columnIndex;
    }

    public boolean isConnected(ColumnIndex columnIndex) {
        return connections.get(columnIndex.value()).exist();
    }
}
