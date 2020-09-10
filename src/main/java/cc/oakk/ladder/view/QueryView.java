package cc.oakk.ladder.view;

import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.model.result.Result;
import cc.oakk.ladder.model.result.Results;
import cc.oakk.ladder.model.trace.Trace;
import cc.oakk.ladder.model.trace.dto.TraceResultsDto;
import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.StandardPrinter;

import java.util.Scanner;

public class QueryView {
    public static final String LINE_BREAK = System.lineSeparator();
    public static final String RESULT_DELIMITER = ":";

    private final Scanner scanner;
    private final Printer<Person> personPrinter;
    private final Printer<Result> resultPrinter;
    private final Printer<String> stringPrinter;

    public QueryView(Printer<Person> personPrinter,
                     Printer<Result> resultPrinter) {
        this.scanner = new Scanner(System.in);
        this.personPrinter = personPrinter;
        this.resultPrinter = resultPrinter;
        this.stringPrinter = StandardPrinter.getInstance();
    }

    public QueryView(Scanner scanner, Printer<Person> personPrinter, Printer<Result> resultPrinter, Printer<String> stringPrinter) {
        this.scanner = scanner;
        this.personPrinter = personPrinter;
        this.resultPrinter = resultPrinter;
        this.stringPrinter = stringPrinter;
    }

    public String getWantedPerson() {
        printHeader("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    public void printResult(Result result) {
        printHeader("실행 결과");
        resultPrinter.print(result);
    }

    public void printTraceResults(TraceResultsDto traceResults, Persons persons, Results results) {
        printHeader("실행 결과");
        for (int i = 0; i < persons.size(); i++) {
            Trace traceResult = traceResults.getTraceResult(Trace.of(i));
            personPrinter.print(persons.get(i));
            stringPrinter.print(RESULT_DELIMITER);
            resultPrinter.print(results.get(traceResult.get()));
            stringPrinter.print(LINE_BREAK);
        }
    }

    private void printHeader(String header) {
        stringPrinter.print(LINE_BREAK);
        stringPrinter.print(header);
        stringPrinter.print(LINE_BREAK);
    }

    public void printError(Throwable throwable) {
        stringPrinter.print("오류발생: " + throwable.getMessage() + LINE_BREAK);
    }
}
