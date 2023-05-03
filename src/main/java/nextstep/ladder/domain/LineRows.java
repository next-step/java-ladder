package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineRows {

    private final List<Connectable> connectables = new ArrayList<>();

    public void initialize(int userCount, BooleanGenerator booleanGenerator) {
        IntStream.range(0, userCount - 1)
                .forEach(index -> addConnect(index, booleanGenerator));
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
