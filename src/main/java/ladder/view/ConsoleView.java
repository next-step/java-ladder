package ladder.view;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.Users;

public class ConsoleView {
    private final Ladder ladder;
    private final Displayer userDisplayer;
    private final Displayer lineDisplayer;
    private final Displayer resultDisplayer;

    public ConsoleView(final Users users, final Ladder ladder) {
        this.ladder = ladder;
        this.userDisplayer = DisplayerFactory.createUserDisplayer(users, displaySize(users.names(), users.getMaxNameSize()));
        this.lineDisplayer = DisplayerFactory.createLineDisplayer(ladder.lines(), displaySize(users.names(), users.getMaxNameSize()));
        this.resultDisplayer = DisplayerFactory.createResultDisplayer(ladder.getResult(), displaySize(users.names(), users.getMaxNameSize()));
    }

    private static int displaySize(List<String> names, int maxNameSize) {
        return maxNameSize + names.size() - maxNameSize;
    }
    
    public void show() {
        showUsers();
        showLines();
        showResult();
    }

    private void showUsers() {
        System.out.println("사다리 결과");
        userDisplayer.show((String name) -> System.out.println(name));
    }
    
    private void showLines() {
        lineDisplayer.show((String points) -> System.out.println(points));
    }

    private void showResult() {
        resultDisplayer.show((String result) -> System.out.println(result));
    }
}
