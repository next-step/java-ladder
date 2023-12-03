package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;

import java.util.List;

import static nextstep.ladder.model.Name.MAX_NAME_LENGTH;

public class LadderOutputView {

    public static final String WALL = "|";
    public static final String LINE_INITIAL = "-";
    public static final String BLANK_INITIAL = " ";

    public void getLadderResult(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();
        viewNames(ladder);
        for (int height = 0; height < ladder.height(); height++) {
            List<Boolean> list = ladder.horizonLineDrawAvailable(height);
            drawHorizon(ladder, list);
            System.out.println();
        }
    }

    private void drawHorizon(Ladder ladder, List<Boolean> list) {
        for (int peopleCount = 0; peopleCount < ladder.peopleCount(); peopleCount++) {
            drawOneLine(list, peopleCount);
        }
    }

    private void drawOneLine(List<Boolean> list, int peopleCount) {
        String initial = changeInitial(list, peopleCount);
        System.out.print(initial.repeat(MAX_NAME_LENGTH));
        System.out.print(WALL);
    }

    private String changeInitial(List<Boolean> list, int peopleCount) {
        if (list.get(peopleCount)) {
            return LINE_INITIAL;
        }
        return BLANK_INITIAL;
    }

    private void viewNames(Ladder ladder) {
        for (String name : ladder.peopleNames()) {
            System.out.printf("%" + (MAX_NAME_LENGTH + 1) + "s", name);
        }
        System.out.println();
    }
}
