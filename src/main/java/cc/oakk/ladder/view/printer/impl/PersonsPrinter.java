package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.view.printer.StringPrinter;

public class PersonsPrinter extends StringPrinter<Persons> {
    @Override
    public void print(Persons target) {
        target.forEach(person -> stringPrinter.print(String.format("%5s ", person.getName())));
    }
}
