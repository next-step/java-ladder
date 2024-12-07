package nextstep.laddergame.view;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String TWICE_SPACES = "  ";
    private static final String THIRD_SPACES = "   ";
    private static final String EMPTY_LINE = "|     ";
    private static final String SET_LINE = "|-----";
    private static final String ALL_PARTICIPANTS = "all";

    private OutputView() {
    }

    public static void printLadder(List<String> participants, Ladder ladder, List<String> ladderOutputs) {
        StringBuilder stringBuilder = new StringBuilder("사다리 결과").append(LINE_SEPARATOR).append(LINE_SEPARATOR);
        stringBuilder.append(createParticipantsName(participants)).append(LINE_SEPARATOR);
        stringBuilder.append(createLadder(ladder));
        stringBuilder.append(createLadderGameOutput(ladderOutputs)).append(LINE_SEPARATOR);

        System.out.println(stringBuilder);
    }

    private static String createLadderGameOutput(List<String> ladderOutputs) {
        return ladderOutputs
                .stream().map(ladderOutput -> ladderOutput + TWICE_SPACES)
                .collect(Collectors.joining());
    }

    private static String createLadder(Ladder ladder) {
        return ladder.values().stream()
                .map(line -> {
                    String output = line.values().stream()
                            .map(cross -> cross.isSet() ? SET_LINE : EMPTY_LINE)
                            .collect(Collectors.joining());
                    return THIRD_SPACES + output + LINE_SEPARATOR;
                })
                .collect(Collectors.joining());
    }

    private static String createParticipantsName(List<String> participants) {
        return participants
                .stream().map(participant -> participant + TWICE_SPACES)
                .collect(Collectors.joining());
    }

    public static void printGameResult(LadderResult ladderResult) {
        boolean isAllParticipants = false;
        while (!isAllParticipants) {
            List<String> participantsForResult = InputView.enterParticipantNamesForResult();
            isAllParticipants = isAllParticipants(participantsForResult);

            System.out.println(new StringBuilder("실행 결과")
                    .append(LINE_SEPARATOR)
                    .append(isAllParticipants ? createAllGameResult(ladderResult) : createSingleGameResult(participantsForResult, ladderResult))
                    .append(LINE_SEPARATOR));
        }
    }

    private static String createAllGameResult(LadderResult ladderResult) {
        return ladderResult.keys().stream()
                .map(key -> String.format("%s : %s", key, ladderResult.outputOf(key)))
                .collect(Collectors.joining((LINE_SEPARATOR)));
    }

    private static String createSingleGameResult(List<String> participantsForResult, LadderResult ladderResult) {
        return ladderResult.outputOf(participantsForResult.get(0));
    }

    private static boolean isAllParticipants(List<String> names) {
        return names.size() == 1 && ALL_PARTICIPANTS.equals(names.get(0));
    }
}
