package nextstep.ladder.view;

import nextstep.ladder.ViewUtils;
import nextstep.ladder.domain.*;

import java.util.List;

public class OutputView {

    private static final String LADDER_GAME_RESULT = "실행결과";
    private static final String POINT_FORMAT = "|%s";
    private static final String POINT_LINE = "-----";
    private static final String POINT_EMPTY = "     ";
    private static final String LADDER_END = "|";
    private static final int SPACE_PER_POINT = 6;
    private static final String SPACE = " ";
    private ViewUtils viewUtils;

    public OutputView() {
        this.viewUtils = new ViewUtils();
    }

    public void showLadder(LadderGame ladderGame) {
        List<Participant> participants = ladderGame.getParticipants();
        Ladder ladder = ladderGame.getLadder();

        viewUtils.printLine(LADDER_GAME_RESULT);
        showPersons(participants);

        for(Line line : ladder.getValue()) {
            showLine(line);
        }
    }

    private void showLine(Line line) {
        StringBuilder builder = new StringBuilder();

        builder.append(POINT_EMPTY);
        for(Point point : line.getValue()) {
            builder.append(getPointText(point));
        }
        builder.append(LADDER_END);

        viewUtils.printLine(builder.toString());
    }

    private String getPointText(Point point) {
        return String.format(POINT_FORMAT, point.isHasLine() ? POINT_LINE : POINT_EMPTY);
    }

    private void showPersons(List<Participant> participants) {
        StringBuilder builder = new StringBuilder();

        for(Participant participant : participants) {
            String personName = participant.getName();
            int length = personName.length();
            int spaceCount = SPACE_PER_POINT - length;

            for(int i = 0; i < spaceCount; i++) {
                builder.append(SPACE);
            }
            builder.append(personName);
        }

        viewUtils.printLine(builder.toString());
    }
}
