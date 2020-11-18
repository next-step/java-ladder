package step2.view;

import step2.domain.ladder.Ladder;
import step2.domain.ladder.LadderPlayers;
import step2.strategy.LadderPrintStrategy;
import step2.strategy.PrintLadderStrategy;

import java.util.stream.Stream;

public class LadderGameResultView implements ResultView{
    public static final String VERTICAL_LINE = "|";
    public static final String HORIZON_LINE_MARKED = "-----";
    public static final String HORIZON_LINE_WHITE =  "     ";
    private final StringBuilder sb;

    public LadderGameResultView() {
        sb = new StringBuilder();
    }

    @Override
    public void drawLadder(LadderPlayers players, Ladder ladder) {
        clearStringBuilder();
        append(players.toString());
        PrintLadderStrategy strategy = new LadderPrintStrategy(HORIZON_LINE_MARKED, HORIZON_LINE_WHITE);
        ladder.forEach(line-> append(line.printLine(strategy, VERTICAL_LINE)));

        System.out.println(sb.toString());
    }

    private void append(String ...args) {
        String separator = System.lineSeparator();
        Stream.of(args)
                .forEach(arg-> sb.append(arg).append(separator));
    }

    private void clearStringBuilder() {
        sb.delete(0, sb.length());
    }
}
