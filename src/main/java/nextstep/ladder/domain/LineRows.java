package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineRows {

    private final List<Connectable> connectables;

    private LineRows(List<Connectable> connectables) {
        this.connectables = connectables;
    }

    public static LineRows initialize(int userCount, BooleanGenerator booleanGenerator) {
        LineRows lineRows = new LineRows(new ArrayList<>());
        IntStream.range(0, userCount - 1)
                .forEach(index -> lineRows.addConnect(index, booleanGenerator));
        return lineRows;
    }

    private void addConnect(int index, BooleanGenerator booleanGenerator) {
        if (isNotAddableTrue(index)) {
            connectables.add(new Connectable(false));
            return;
        }
        connectables.add(new Connectable(booleanGenerator.getBoolean()));
    }

    private boolean isNotAddableTrue(int index) {
        return index != 0 && getConnectable(index - 1).isConnected();
    }

    private Connectable getConnectable(int index) {
        return connectables.get(index);
    }

    public List<Connectable> getConnectables() {
        return connectables;
    }

}
