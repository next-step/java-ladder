package cc.oakk.ladder;

import cc.oakk.ladder.controller.LadderGame;
import cc.oakk.ladder.model.Person;
import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.view.InputView;
import cc.oakk.ladder.view.ResultView;
import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.LinePrinter;
import cc.oakk.ladder.view.printer.impl.PersonPrinter;

public class LadderApplication {
    public static void main(String[] args) {
        Printer<Line> linePrinter = new LinePrinter();
        Printer<Person> personPrinter = new PersonPrinter();
        
        InputView inputView = new InputView();
        ResultView resultView = new ResultView(personPrinter, linePrinter);
        LadderGame game = new LadderGame(inputView, resultView);
        game.start();
    }
}
