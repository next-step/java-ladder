package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.model.result.Results;
import cc.oakk.ladder.view.printer.StringPrinter;

public class ResultsPrinter extends StringPrinter<Results> {
    @Override
    public void print(Results target) {
        target.forEach(result -> stringPrinter.print(String.format("%5s ", result.getName())));
    }
}
