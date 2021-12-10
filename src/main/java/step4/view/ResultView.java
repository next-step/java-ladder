package step4.view;

import step4.domain.*;

import java.util.Map;

public class ResultView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과\n\n";
    private static final String PARTICIPANT_ALL_RESULT_MESSAGE = "실행 결과\n";
    private static final String PARTICIPANT_ALL_RESULT = "%s : %s\n";
    private static final String LADDER_LINE = "|-----";
    private static final String NO_LADDER_LINE = "|     ";
    private static final String WHITE_SPACE = " ";
    private static final String WHITE_SPACE_REPEAT_FOUR = "    ";
    private static final int NAME_MAX_LENGTH = 5;

    public static void ladderResult(Ladder ladder, GameInfo gameInfo) {
        System.out.print(LADDER_RESULT_MESSAGE);
        showParticipants(gameInfo.participants());
        showLadder(ladder);
        showRewards(gameInfo.rewards());
    }

    public static void participantResult(String result) {
        System.out.println(result);
        nextLine();
    }

    public static void allParticipantResult(Map<String, String> result) {
        System.out.print(PARTICIPANT_ALL_RESULT_MESSAGE);
        result.forEach((participant, reward) ->
                System.out.printf(PARTICIPANT_ALL_RESULT, participant, reward));
    }

    public static void nextLine() {
        System.out.println();
    }

    private static void showParticipants(Participants participants) {
        participants.participants().stream()
                .map(Participant::name)
                .forEach(name -> System.out.print(showName(name)));
        nextLine();
    }

    private static String showName(String name) {
        return repeatWhiteSpace(NAME_MAX_LENGTH - name.length()) + name + WHITE_SPACE;
    }

    private static void showLadder(Ladder ladder) {
        for (LadderLine line : ladder.lines()) {
            showLadderLine(line);
        }
    }

    private static void showLadderLine(LadderLine line) {
        System.out.print(WHITE_SPACE_REPEAT_FOUR);
        line.points().stream()
                .map(Point::direction)
                .forEach((direction) -> System.out.print(showDirection(direction)));
        nextLine();
    }

    private static String showDirection(Direction direction) {
        if (direction.isRight()) {
            return LADDER_LINE;
        }
        return NO_LADDER_LINE;
    }

    private static void showRewards(Rewards rewards) {
        rewards.rewards().stream()
                .map(Reward::name)
                .forEach(name -> System.out.print(showName(name)));
        System.out.println();
    }

    private static String repeatWhiteSpace(int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < repeatCount; count++) {
            sb.append(WHITE_SPACE);
        }
        return sb.toString();
    }
}
