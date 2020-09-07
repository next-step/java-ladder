package cc.oakk.ladder.view;

import cc.oakk.ladder.model.Ladder;
import cc.oakk.ladder.model.Person;
import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.view.printer.Printer;

import java.util.List;

public class ResultView {
    private final Printer<Person> personPrinter;
    private final Printer<Line> linePrinter;

    public ResultView(Printer<Person> personPrinter, Printer<Line> linePrinter) {
        this.personPrinter = personPrinter;
        this.linePrinter = linePrinter;
    }

    public void printLadder(List<Person> persons, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();
        persons.forEach(personPrinter::print);
        System.out.println();
        ladder.getLines().forEach(linePrinter::print);
    }
}
