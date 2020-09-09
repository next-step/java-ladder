package cc.oakk.ladder.view;

import cc.oakk.ladder.model.Person;
import cc.oakk.ladder.model.ladder.dto.LadderDto;
import cc.oakk.ladder.model.line.dto.LineDto;
import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.StandardPrinter;

import java.util.List;

public class ResultView {
    public static final String LINE_BREAK = System.lineSeparator();

    private final Printer<Person> personPrinter;
    private final Printer<LineDto> linePrinter;
    private final Printer<String> stringPrinter;

    public ResultView(Printer<Person> personPrinter, Printer<LineDto> linePrinter) {
        this.personPrinter = personPrinter;
        this.linePrinter = linePrinter;
        this.stringPrinter = StandardPrinter.getInstance();
    }

    public ResultView(Printer<Person> personPrinter, Printer<LineDto> linePrinter, Printer<String> stringPrinter) {
        this.personPrinter = personPrinter;
        this.linePrinter = linePrinter;
        this.stringPrinter = stringPrinter;
    }

    public void printLadder(List<Person> persons, LadderDto ladder) {
        stringPrinter.print("실행결과" + LINE_BREAK);
        stringPrinter.print(LINE_BREAK);
        persons.forEach(personPrinter::print);
        stringPrinter.print(LINE_BREAK);
        ladder.getLines().forEach(linePrinter::print);
    }
}
