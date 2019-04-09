import domain.Ladder;
import domain.Position;
import view.ConsoleInputView;
import view.ConsoleOutputView;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ConsoleMain {
    public static void main(String[] args) {
        List<Position> users = createPositions(ConsoleInputView.inputUserNames());
        List<Position> results = createPositions(ConsoleInputView.inputResults());
        Integer height = ConsoleInputView.inputLadderHeight();

        Ladder ladder = new Ladder(users.size(), height);
        ConsoleOutputView.printPositions(users);
        ConsoleOutputView.printLadder(ladder);
        ConsoleOutputView.printPositions(results);

        String name = ConsoleInputView.inputNameForResult();
        if(name.equals("all")) {
            ConsoleOutputView.printAllResult(users, results, ladder);
        } else {
            ConsoleOutputView.printOneResult(name, users, results, ladder);
        }

    }

    private static List<Position> createPositions(List<String> names) {
        AtomicInteger integer = new AtomicInteger(1);
        return names.stream()
            .map(s -> new Position(s, integer.getAndIncrement()))
            .collect(Collectors.toList());
    }
}
