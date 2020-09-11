package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.model.result.Result;
import cc.oakk.ladder.view.printer.StringPrinter;

public class ResultPrinter extends StringPrinter<Result> {
    @Override
    public void print(Result target) {
        stringPrinter.print(String.format("%s", target.getName()));
    }
}
