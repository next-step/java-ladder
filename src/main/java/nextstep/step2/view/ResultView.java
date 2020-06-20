package nextstep.step2.view;

import nextstep.step2.domain.*;

import java.util.List;

public class ResultView {
    private static final String BAR = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "";
    private static final String FORMAT = "%5s";

    private List<Name> names;
    private List<Line> lines;

    public ResultView(Names names, Lines lines) {
        this.names = names.getNames();
        this.lines = lines.getLines();
    }

    public void displayLadder() {
        printNames();
        printLadders();
    }

    private void printNames() {
        names.forEach(name -> System.out.printf("%-6s", name.getName()));
        System.out.println();
    }

    private void printLadders() {
        lines.forEach(line -> {
            line.getOneLayerLadder().forEach(this::printOneLayerLadder);
            System.out.println();
        });
    }

    private void printOneLayerLadder(LineConnection lineConnection) {
        System.out.print(BAR);
        if (lineConnection.isConnect()) {
            System.out.printf(FORMAT, LINE);

            return;
        }

        System.out.printf(FORMAT, BLANK);
    }
}
