package nextstep.laddergame.view;

import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.domain.LadderOutput;
import nextstep.laddergame.domain.Participants;
import nextstep.laddergame.service.LadderGameResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String TWICE_SPACES = "  ";
    private static final String THIRD_SPACES = "   ";
    private static final String EMPTY_LADDER_LINE = "|     ";
    private static final String SET_LADDER_LINE = "|-----";

    private OutputView() {
    }

    public static void printLadder(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder("사다리 결과").append(LINE_SEPARATOR).append(LINE_SEPARATOR);
        stringBuilder.append(createParticipantsName(ladderGame.getParticipants())).append(LINE_SEPARATOR);
        stringBuilder.append(createLadder(ladderGame));
        stringBuilder.append(createLadderGameOutput(ladderGame.getLadderOutputs())).append(LINE_SEPARATOR);

        System.out.println(stringBuilder);
    }

    private static String createLadderGameOutput(List<LadderOutput> ladderOutputs) {
        return ladderOutputs
                .stream().map(ladderOutput -> ladderOutput.getWinningData() + TWICE_SPACES)
                .collect(Collectors.joining());
    }

    private static String createLadder(LadderGame ladderGame) {
        return IntStream.range(0, ladderGame.getLaddersLineSize())
                .mapToObj(height -> {
                    String output = IntStream.range(0, ladderGame.getLaddersSize())
                            .mapToObj(position -> ladderGame.getLadders().ladderAt(position).isLineAlreadySetAt(height) ? SET_LADDER_LINE : EMPTY_LADDER_LINE)
                            .collect(Collectors.joining());
                    return THIRD_SPACES + output + LINE_SEPARATOR;
                })
                .collect(Collectors.joining());
    }

    private static String createParticipantsName(Participants participants) {
        return participants.values()
                .stream().map(participant -> participant.getName() + TWICE_SPACES)
                .collect(Collectors.joining());
    }

    public static void printGameResult(List<LadderGameResult> gameResults) {
        System.out.println(new StringBuilder("실행 결과")
                .append(LINE_SEPARATOR)
                .append(createGameResult(gameResults))
                .append(LINE_SEPARATOR));
    }

    private static String createGameResult(List<LadderGameResult> gameResults) {
        if (gameResults.size() == 1) {
            return createSingleGameResult(gameResults);
        }
        return createAllGameResults(gameResults);
    }

    private static String createSingleGameResult(List<LadderGameResult> gameResults) {
        return gameResults.get(0).getWinningData();
    }

    private static String createAllGameResults(List<LadderGameResult> gameResults) {
        return gameResults.stream()
                .map(result -> String.format("%s : %s", result.getParticipant().getName(), result.getWinningData()))
                .collect(Collectors.joining((LINE_SEPARATOR)));
    }
}
