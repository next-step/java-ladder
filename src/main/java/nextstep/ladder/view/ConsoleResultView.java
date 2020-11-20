package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView {
    private static final String LADDER_STICK = "|";
    private static final String EXIST_POINT = "-----";
    private static final String EMPTY_POINT = "     ";

    @Override
    public void printLadder(Ladder ladder) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladder.repeatAsHeight(renderFirstPartOfLine(ladderBuilder), renderPoint(ladderBuilder), renderLastPartOfLine(ladderBuilder));

        System.out.println(ladderBuilder.toString());
    }

    private Runnable renderFirstPartOfLine(StringBuilder ladderBuilder) {
        return () -> ladderBuilder.append(EMPTY_POINT).append(LADDER_STICK);
    }

    private Consumer<Boolean> renderPoint(StringBuilder ladderBuilder) {
        return point -> {
            ladderBuilder.append(point ? EXIST_POINT : EMPTY_POINT);
            ladderBuilder.append(LADDER_STICK);
        };
    }

    private Runnable renderLastPartOfLine(StringBuilder ladderBuilder) {
        return () -> ladderBuilder.append(System.lineSeparator());
    }

    public void printParticipants(Participants participants) {
        List<Name> names = participants.getNames();
        String joinedNames = names.stream()
                .map(name -> String.format("%6s", name.value))
                .collect(Collectors.joining());
        System.out.println(joinedNames);
    }
}
