package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.strategy.RandomDrawLineStrategy;

public class LadderRow {

    List<LadderColumn> ladderColumns = new ArrayList<>();

    public LadderRow(int ladderWidth) {

        if (ladderWidth != 1) {
            boolean prev = false;
            for (int i = 0; i < ladderWidth - 1; i++) {
                if (prev == true) {
                    ladderColumns.add(new LadderColumn());
                } else {
                    ladderColumns.add(new LadderColumn().drawLine(new RandomDrawLineStrategy()));
                }
                prev = ladderColumns.get(i).value();
            }
        }
        ladderColumns.add(new LadderColumn());
    }

    public int ladderColumnCount() {
        return ladderColumns.size();
    }

}
