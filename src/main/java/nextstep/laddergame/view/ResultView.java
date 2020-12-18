package nextstep.laddergame.view;

import nextstep.laddergame.domain.Person;
import nextstep.laddergame.domain.dto.LadderDTO;
import nextstep.laddergame.domain.dto.LineDTO;

import java.util.List;

public class ResultView {
    private static final String WAY = "-----";
    private static final String NOT_WAY = "     ";
    private static final char LADDER_LINE = '|';

    public void showPeople(List<Person> people) {
        for (Person person : people) {
            System.out.print(person.getName() + "  ");
        }
        System.out.println();
    }

    public void showLadder(LadderDTO ladder) {
        for (LineDTO line : ladder.getLines()) {
            System.out.print("   ");
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(LineDTO line) {
        for (int index = 0; index < line.getPoints().size(); index++) {
            if (isLadderLine(index)) {
                System.out.print(LADDER_LINE);
                continue;
            }

            showWay(line.getPoints().get(index));
        }
    }

    private void showWay(Boolean isWay) {
        if (isWay) {
            System.out.print(WAY);
            return;
        }
        System.out.print(NOT_WAY);
    }

    private boolean isLadderLine(int index) {
        return index % 2 == 0;
    }
}
