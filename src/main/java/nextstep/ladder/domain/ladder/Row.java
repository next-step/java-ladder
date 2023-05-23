package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.BooleanGenerator;
import nextstep.ladder.domain.user.Position;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {

    private static final String COLUMN_DELIMITER = "|";
    private static final String OUTPUT_PREFIX = "    " + COLUMN_DELIMITER;
    private static final String OUTPUT_SUFFIX = COLUMN_DELIMITER;

    private final Map<Position, ConnectionType> connectionTypeMap;
    private final int connectionSize;

    public Row(Map<Position, ConnectionType> connectionTypeMap, int connectionSize) {
        this.connectionTypeMap = connectionTypeMap;
        this.connectionSize = connectionSize;
    }

    public static Row initialize(int size, BooleanGenerator booleanGenerator) {
        Row row = new Row(new LinkedHashMap<>(), size);
        IntStream.range(0, size)
                .mapToObj(Position::new)
                .forEach(position -> row.addConnectionType(position, booleanGenerator));
        return row;
    }

    private void addConnectionType(Position position, BooleanGenerator booleanGenerator) {
        if (position.isFirst()) {
            connectionTypeMap.put(position, ConnectionType.getRightOrNone(booleanGenerator.getBoolean()));
            return;
        }

        ConnectionType beforeConnection = connectionTypeMap.get(position.beforePosition());
        if (beforeConnection.isRight()) {
            connectionTypeMap.put(position, ConnectionType.LEFT);
            return;
        }

        if (position.equals(new Position(lastIndex()))) {
            connectionTypeMap.put(position, ConnectionType.NONE);
            return;
        }

        connectionTypeMap.put(position, ConnectionType.getRightOrNone(booleanGenerator.getBoolean()));
    }

    private int lastIndex() {
        return connectionSize - 1;
    }

    public int movePoint(int currentPosition) {
        ConnectionType currenConnectionType = connectionTypeMap.get(new Position(currentPosition));
        return currenConnectionType.getMovePoint();
    }

    @Override
    public String toString() {
        return OUTPUT_PREFIX + drawLines() + OUTPUT_SUFFIX;
    }

    private String drawLines() {
        return connectionTypeMap.values()
                .stream()
                .limit(lastIndex())
                .map(ConnectionType::toOutput)
                .collect(Collectors.joining(COLUMN_DELIMITER));
    }

}
