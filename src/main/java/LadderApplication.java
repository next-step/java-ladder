import domain.Line;
import domain.Person;
import util.Console;
import view.InputView;
import view.ResultView;

import java.util.stream.IntStream;

public class LadderApplication {
    public static void main(String[] args) {
        try {
            Person person = new Person(InputView.inputPalyer());
            int ladderHeight = InputView.inputLadderHeight();
            Console.print(person.toString());
            IntStream.range(0, ladderHeight)
                    .forEach(height -> ResultView.printLine(new Line(person.personCount())));

        } catch (Exception e) {
            Console.print(e.getMessage());
        }
    }
}
