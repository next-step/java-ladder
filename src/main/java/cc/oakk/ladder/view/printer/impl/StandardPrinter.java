package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.view.printer.Printer;

public class StandardPrinter implements Printer<String> {
    private static StandardPrinter INSTANCE;

    private StandardPrinter() {}

    public static StandardPrinter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StandardPrinter();
        }
        return INSTANCE;
    }

    public void print(String target) {
        System.out.print(target);
    }
}
