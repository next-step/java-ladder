package cc.oakk.ladder.view.printer.impl;

import cc.oakk.ladder.model.Person;
import cc.oakk.ladder.view.printer.StringPrinter;

public class PersonPrinter extends StringPrinter<Person> {
    @Override
    public void print(Person target) {
        stringPrinter.print(String.format("%5s ", target.getName()));
    }
}
