package nextstep.ladder.domain;

import nextstep.ladder.domain.vertexDrawStrategies.RandomVertexDrawStrategy;
import nextstep.ladder.domain.vertexDrawStrategies.VertexDrawStrategy;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<Boolean> vertexes;

    private Row(final List<Boolean> vertexes) {
        this.vertexes = vertexes;
        validateVertexes(vertexes);
    }

    public static Row ofSize(final int columnSize) {
        return new Row(drawRandomVertexes(columnSize - 1, new RandomVertexDrawStrategy()));
    }

    public static Row ofSizeAndStrategy(final int columnSize, VertexDrawStrategy vertexDrawStrategy) {
        return new Row(drawRandomVertexes(columnSize - 1, vertexDrawStrategy));
    }

    public static Row ofVertexes(final List<Boolean> vertexes) {
        return new Row(vertexes);
    }

    private static List<Boolean> drawRandomVertexes(final int columnSize, final VertexDrawStrategy vertexDrawStrategy) {
        List<Boolean> vertexes = new ArrayList<>();
        boolean lastVertexDrawn = false;
        for (int i = 0; i < columnSize; i++) {
            boolean isDraw = vertexDrawStrategy.shouldDraw() && !lastVertexDrawn;
            vertexes.add(isDraw);
            lastVertexDrawn = isDraw;
        }
        return vertexes;
    }

    private void validateVertexes(final List<Boolean> vertexes) {
        for (int i = 1; i < vertexes.size(); i++) {
            if (vertexes.get(i) && vertexes.get(i - 1)) {
                throw new IllegalArgumentException("정상 처리될 수 없는 행 입니다");
            }
        }
    }

    public int getColumnSize() {
        return this.vertexes.size() + 1;
    }

    public boolean hasVertexAt(final int position) {
        return this.vertexes.get(position);
    }

}
