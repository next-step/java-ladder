package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.PlayerGroup;
import ladder.domain.Stick;

import java.util.List;

public class ConsoleOutput {

    private static final String START_BLANK = "     ";
    private static final String TRUE_STICK = "|-----";
    private static final String FALSE_STICK = "|     ";
    private static final String LAST_PIPE = "|";

    private ConsoleOutput() {
        throw new AssertionError("ConsoleInput 클래스의 생성자를 호출할 수 없습니다.");
    }

    public static void printNamesAndLadder(PlayerGroup playerGroup, Ladder ladder) {
        printNames(playerGroup);
        printLadder(ladder);
    }

    private static void printNames(PlayerGroup playerGroup) {
        List<String> names = playerGroup.findNames();
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        int ladderHeight = ladder.findHeight();
        for (int height = 0; height < ladderHeight; height++) {
            System.out.print(START_BLANK);
            ladder.findSticksOf(height)
                    .forEach(ConsoleOutput::printStick);
            System.out.println(LAST_PIPE);
        }
    }

    private static void printStick(Stick stick) {
        if (stick.isValue()) {
            System.out.print(TRUE_STICK);
            return;
        }
        System.out.print(FALSE_STICK);
    }
}
