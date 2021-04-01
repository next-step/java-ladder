package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.service.Ladder;

import java.util.List;

public class ResultView {

    public static final String STRING_NAME_FORMAT = "%6s";

    public void printResult(Ladder ladder, Participants participants) {
        StringBuilder printBuilder = new StringBuilder();

        printHeader(printBuilder);
        printNames(participants, printBuilder);
        printLadder(ladder, printBuilder);

        System.out.println(printBuilder.toString());
    }

    private void printHeader(StringBuilder printBuilder) {
        printBuilder.append("실행 결과").append(System.lineSeparator());
    }

    private void printNames(Participants participants, StringBuilder builder) {
        participants.getUsers()
                .forEach(name -> builder.append(parseName(name)));
        builder.append(System.lineSeparator());
    }

    private String parseName(Name name) {
        return String.format(STRING_NAME_FORMAT, name);
    }

    private void printLadder(Ladder ladder, StringBuilder builder) {
        ladder.lines()
                .forEach(line -> createLadder(builder, line));
    }

    private void createLadder(StringBuilder builder, Line line) {
        List<Boolean> points = line.points();
        points.forEach(aBoolean -> builder.append(extracted(aBoolean)));
        builder.append(System.lineSeparator());
    }

    private String extracted(Boolean pointFlag) {
        if(pointFlag) {
            return String.format(STRING_NAME_FORMAT, "-----|");
        }
        return String.format(STRING_NAME_FORMAT, "     |");
    }
}
