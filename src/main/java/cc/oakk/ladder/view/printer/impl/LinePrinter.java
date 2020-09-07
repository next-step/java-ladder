package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.model.line.Connection;
import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.view.printer.StringPrinter;

public class LinePrinter extends StringPrinter<Line> {
    public static final String START = "    ";
    public static final String LINE = "|";

    public static final String LINE_BREAK = "\n";

    public static final String CONNECTED = "-----";
    public static final String NOT_CONNECTED = "     ";

    @Override
    public void print(Line target) {
        stringPrinter.print(START);
        for (int i = 0; i < target.width() - 1; i++) {
            stringPrinter.print(LINE);
            printConnection(target.isConnected(i));
        }
        stringPrinter.print(LINE);
        stringPrinter.print(LINE_BREAK);
    }

    private void printConnection(Connection connection) {
        if (connection.get()) {
            stringPrinter.print(CONNECTED);
            return;
        }
        stringPrinter.print(NOT_CONNECTED);
    }
}
