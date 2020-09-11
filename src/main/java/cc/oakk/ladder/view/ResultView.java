package cc.oakk.ladder.view;

import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.model.ladder.dto.LadderDto;
import cc.oakk.ladder.model.line.dto.LineDto;
import cc.oakk.ladder.model.result.Results;
import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.StandardPrinter;

public class ResultView {
    public static final String LINE_BREAK = System.lineSeparator();

    private final Printer<Persons> personsPrinter;
    private final Printer<LineDto> linePrinter;
    private final Printer<Results> resultsPrinter;
    private final Printer<String> stringPrinter;

    public ResultView(Printer<Persons> personsPrinter,
                      Printer<LineDto> linePrinter,
                      Printer<Results> resultsPrinter) {
        this.personsPrinter = personsPrinter;
        this.linePrinter = linePrinter;
        this.resultsPrinter = resultsPrinter;
        this.stringPrinter = StandardPrinter.getInstance();
    }

    public ResultView(Printer<Persons> personsPrinter,
                      Printer<LineDto> linePrinter,
                      Printer<Results> resultsPrinter,
                      Printer<String> stringPrinter) {
        this.personsPrinter = personsPrinter;
        this.linePrinter = linePrinter;
        this.resultsPrinter = resultsPrinter;
        this.stringPrinter = stringPrinter;
    }

    public void printHeader() {
        stringPrinter.print(LINE_BREAK);
        stringPrinter.print("실행결과");
        stringPrinter.print(LINE_BREAK);
    }

    public void printPersons(Persons persons) {
        personsPrinter.print(persons);
    }

    public void printLadder(LadderDto ladder) {
        stringPrinter.print(LINE_BREAK);
        ladder.getLines().forEach(linePrinter::print);
    }

    public void printResults(Results results) {
        resultsPrinter.print(results);
    }
}
