import console.ConsoleInput;
import console.ConsoleOutput;
import domain.Line;
import java.util.ArrayList;
import java.util.List;

public class LadderConsoleApp {

    public static void main(String[] args) {
        final List<String> users = ConsoleInput.enterUsers();
        final int height = ConsoleInput.enterHeight();
        final int countOfLines = users.size();

        List<Line> lines = new ArrayList<>(height);

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfLines));
        }

        ConsoleOutput.printResult(users, lines);
    }
}
