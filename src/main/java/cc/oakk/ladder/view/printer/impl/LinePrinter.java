package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.model.line.Connection;
import cc.oakk.ladder.model.line.dto.LineDto;
import cc.oakk.ladder.view.printer.StringPrinter;

import java.util.List;

public class LinePrinter extends StringPrinter<LineDto> {
    public static final String START = "    ";
    public static final String LINE = "|";

    public static final String LINE_BREAK = System.lineSeparator();

    public static final String CONNECTED = "-----";
    public static final String NOT_CONNECTED = "     ";

    @Override
    public void print(LineDto target) {
        List<Connection> connections = target.getConnections().getConnections();

        stringPrinter.print(START);
        for (int i = 0; i < target.getWidth().get() - 1; i++) {
            stringPrinter.print(LINE);
            printConnection(connections.get(i));
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
