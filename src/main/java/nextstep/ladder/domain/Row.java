package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Row {
    private final List<Boolean> vertexes;

    public Row(final int columnSize) {
        this.vertexes = drawRandomVertexes(columnSize - 1);
    }

    Row(final List<Boolean> vertexes) {
        this.vertexes = vertexes;
        validateVertexes(vertexes);
    }

    private List<Boolean> drawRandomVertexes(final int columnSize) {
        List<Boolean> vertexes = new ArrayList<>();
        Random random = new Random();
        boolean lastVertexDrawn = false;
        for (int i = 0; i < columnSize; i++) {
            boolean isDraw = random.nextBoolean() && !lastVertexDrawn;
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
