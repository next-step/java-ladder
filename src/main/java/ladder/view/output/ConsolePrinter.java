package ladder.view.output;

import ladder.core.view.output.Printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
