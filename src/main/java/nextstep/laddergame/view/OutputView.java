package nextstep.laddergame.view;

import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.domain.Participants;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String TWICE_SPACES = "  ";
    private static final String THIRD_SPACES = "   ";
    private static final String EMPTY_LADDER_LINE = "|     ";
    private static final String SET_LADDER_LINE = "|-----";

    public static void printGameResult(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder("실행결과").append(LINE_SEPARATOR).append(LINE_SEPARATOR);
        stringBuilder.append(createParticipantsResult(ladderGame.getParticipants())).append(LINE_SEPARATOR);
        stringBuilder.append(createLadderResult(ladderGame));

        System.out.println(stringBuilder);
    }

    private static String createLadderResult(LadderGame ladderGame) {
        return IntStream.range(0, ladderGame.getMaxHeight())
                .mapToObj(height -> {
                    String output = IntStream.range(0, ladderGame.getLaddersSize())
                            .mapToObj(position -> ladderGame.getLadders().ladderAt(position).isLineAlreadySetAt(height) ? SET_LADDER_LINE : EMPTY_LADDER_LINE)
                            .collect(Collectors.joining());
                    return THIRD_SPACES + output + LINE_SEPARATOR;
                })
                .collect(Collectors.joining());
    }

    private static String createParticipantsResult(Participants participants) {
        return participants.values()
                .stream().map(participant -> participant.getName() + TWICE_SPACES)
                .collect(Collectors.joining());
    }
}
