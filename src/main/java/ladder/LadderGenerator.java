package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private final RowGenerator rowGenerator;

    public LadderGenerator(RowGenerator rowGenerator) {
        this.rowGenerator = rowGenerator;
    }

    public Ladder create(int people, int height) {
        List<Row> rows = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            rows.add(rowGenerator.create(people));
        }

        return new Ladder(rows);
    }
}
