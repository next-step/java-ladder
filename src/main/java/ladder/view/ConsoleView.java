package ladder.view;

import java.util.List;

import ladder.domain.Line;
import ladder.domain.Users;

public class ConsoleView {
    private final UserDisplay userDisplay;
    private final List<Line> ladder;
    private final LineDisplay lineDisplay;

    public ConsoleView(final Users users,  final List<Line> ladder) {
        this.ladder = ladder;
        this.userDisplay = new UserDisplay(users, displaySize(users.names(), users.getMaxNameSize()));
        this.lineDisplay = new LineDisplay(displaySize(users.names(), users.getMaxNameSize()));
    }

    public void show() {
        showUsers();
        showLadder();
    }

    private static int displaySize(List<String> names, int maxNameSize) {
        return maxNameSize + names.size() - maxNameSize;
    }

    private void showLadder() {
        for (Line line : ladder) {
            System.out.println(lineDisplay.show(line.getPoints()));
        }
    }

    private void showUsers() {
        System.out.println(userDisplay.get());
    }
}
