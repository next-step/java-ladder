package nextstep.ladder.view;

import nextstep.ladder.Ladder;

import java.util.function.Consumer;

public class ConsoleResultView implements ResultView {
    @Override
    public void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        ladder.repeatAsHeight(renderPoints(sb), renderLastPartOfLine(sb));
        System.out.println(sb.toString());
    }

    private Consumer<Boolean> renderPoints(StringBuilder sb) {
        return point -> {
            sb.append("|");
            sb.append(point ? "-----" : "     ");
        };
    }

    private Runnable renderLastPartOfLine(StringBuilder sb) {
        return () -> sb.append("|").append(System.lineSeparator());
    }
}
