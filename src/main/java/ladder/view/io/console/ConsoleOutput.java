package ladder.view.io.console;

import ladder.view.io.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printLine(final String text) {
        System.out.println(text);
    }
}
