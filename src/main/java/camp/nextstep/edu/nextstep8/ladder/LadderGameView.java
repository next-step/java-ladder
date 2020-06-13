package camp.nextstep.edu.nextstep8.ladder;

import camp.nextstep.edu.nextstep8.ladder.entity.Ladder;
import camp.nextstep.edu.nextstep8.ladder.entity.Point;
import camp.nextstep.edu.nextstep8.ladder.entity.Row;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameView {
    private static final String LINE = "-----";
    private static final String SPACE = "     ";

    private final Ladder ladder;

    public LadderGameView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void show() {
        int rows = ladder.getHeight();
        int cols = ladder.getCols();
        List<String> joiners = ladder.getJoiners();
        System.out.println(joiners.stream().collect(Collectors.joining("     ")).toString());

        for(int i = 0; i < rows; i++) {
            Row row = ladder.getRows().get(i);
            for(int j = 0; j < cols; j++) {
                System.out.print("|");
                System.out.print(getPrintLine(row.pick(i, j), row.pick(i, j+1)));
            }

            System.out.println();
        }


    }


    private boolean hasDrawLine(Point cur, Point next) {
        if(cur.meetLast(ladder.getCols())) {
            return false;
        }
        return cur.isStart() && next.isEnd();
    }

    private String getPrintLine(Point cur, Point next) {
        if(hasDrawLine(cur, next)) {
            return LINE;
        }
        return SPACE;
    }
}
