package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class LadderRow {

    private final List<Boolean> columns = new ArrayList<>();

    public LadderRow(int width, Supplier<Boolean> connectionFunction) {
        initializeColumns(width, connectionFunction);
    }

    private void initializeColumns(int width, Supplier<Boolean> connectionFunction) {
        boolean prevPoint = false;
        for (int i = 0; i < width - 1; i++) {
            boolean isConnected = determineConnection(prevPoint, connectionFunction);
            columns.add(isConnected);
            prevPoint = isConnected;
        }
    }

    private boolean determineConnection(boolean prevPoint, Supplier<Boolean> connectionFunction) {
        if (prevPoint) {
            return false;
        }
        return connectionFunction.get();
    }

    public void forEach(Consumer<Boolean> consumer) {
        columns.forEach(consumer);
    }
}
