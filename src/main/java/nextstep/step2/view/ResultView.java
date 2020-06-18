package nextstep.step2.view;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Names;

import java.util.List;

public class ResultView {
    private static final String BAR = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "";
    private static final String FORMAT = "%5s";

    private List<String> names;
    private List<Line> ladders;

    public ResultView(Names names, List<Line> ladders) {
        this.names = names.getNames();
        this.ladders = ladders;
    }

    public void displayLadder() {
        printNames();
        printLadders();
    }

    private void printNames() {
        names.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

    private void printLadders() {
        ladders.forEach(line -> {
            line.getOneLayerLadder().forEach(this::printLine);
            System.out.println();
        });
    }

    private void printLine(Boolean existLine) {
        System.out.print(BAR);
        if (existLine) {
            System.out.printf(FORMAT, LINE);

            return;
        }

        System.out.printf(FORMAT, BLANK);
    }
}
