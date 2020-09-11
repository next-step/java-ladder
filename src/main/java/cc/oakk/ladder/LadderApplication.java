package cc.oakk.ladder;

import cc.oakk.ladder.controller.LadderGame;
import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.line.dto.LineDto;
import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.model.result.Result;
import cc.oakk.ladder.model.result.Results;
import cc.oakk.ladder.view.InputView;
import cc.oakk.ladder.view.QueryView;
import cc.oakk.ladder.view.ResultView;
import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.*;

public class LadderApplication {
    public static void main(String[] args) {
        Printer<LineDto> linePrinter = new LinePrinter();
        Printer<Persons> personsPrinter = new PersonsPrinter();
        Printer<Results> resultsPrinter = new ResultsPrinter();

        Printer<Person> personPrinter = new PersonPrinter();
        Printer<Result> resultPrinter = new ResultPrinter();

        InputView inputView = new InputView();
        ResultView resultView = new ResultView(personsPrinter, linePrinter, resultsPrinter);
        QueryView queryView = new QueryView(personPrinter, resultPrinter);
        LadderGame game = new LadderGame(inputView, resultView, queryView);
        game.start();
    }
}
