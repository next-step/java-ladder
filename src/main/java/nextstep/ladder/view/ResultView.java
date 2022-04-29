package nextstep.ladder.view;

import nextstep.common.Assert;
import nextstep.ladder.view.dto.LineResponse;
import nextstep.ladder.view.dto.LinesResponse;
import nextstep.ladder.view.dto.NamesResponse;

import java.io.PrintStream;

public final class ResultView {

    private static final String CONNECTED_POINT_LINE_MESSAGE = "-----";
    private static final String DISCONNECTED_POINT_LINE_MESSAGE = "     ";
    private static final char POINT_MESSAGE = '|';
    private static final String RESULT_MESSAGE = "실행결과";
    private static final int NAME_PRINT_SIZE = 6;

    private final PrintStream printer;

    private ResultView(PrintStream printer) {
        Assert.notNull(printer, "printer must not be null");
        this.printer = printer;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }

    public void print(NamesResponse names, LinesResponse lines) {
        printer.println(RESULT_MESSAGE);
        names.getNames().forEach(name -> printer.printf("%-" + NAME_PRINT_SIZE + "s", name));
        printer.println();
        lines.getLines().forEach(line -> printer.println(lineMessage(line)));
    }

    private String lineMessage(LineResponse line) {
        return line.getConnections()
                .stream()
                .map(this::connectionMessage)
                .reduce(String.valueOf(POINT_MESSAGE),
                        (previous, current) -> String.format("%s%s%s", previous, current, POINT_MESSAGE));
    }

    private String connectionMessage(boolean connected) {
        if (connected) {
            return CONNECTED_POINT_LINE_MESSAGE;
        }
        return DISCONNECTED_POINT_LINE_MESSAGE;
    }
}
