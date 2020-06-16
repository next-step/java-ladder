package camp.nextstep.edu.nextstep8.ladder.entity;

import java.util.*;

public class Ladder {
    private final Rows rows;
    private final Joiners joiners;
    private final int height;

    public Ladder(String input, int height) {
        this.joiners = new Joiners(input);
        this.rows = new Rows(joiners.count(), height);
        this.height = height;
        make();
    }

    private void make() {
        Random random = new Random();
        int randomRows, randomCols;
        for(int i = 0; i < joiners.count() * height; i++) {
            randomRows = random.nextInt(height - 1);
            randomCols = random.nextInt(joiners.count() - 1);
            rows.get(randomRows).draw(randomRows, randomCols);
        }
    }

    public Rows getRows() {
        return rows;
    }

    public Joiners getJoiners() {
        return joiners;
    }
}
