package laddergame.view;

import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final int MIN_VALUE_OF_LADDER_HEIGHT = 1;

    private InputView() {}

    public static List<String> inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        List<String> participantNames = List.of(input.split(DELIMITER));
        validateParticipantNames(participantNames);
        return participantNames;
    }

    private static void validateParticipantNames(List<String> participantNames) {
        participantNames.forEach(InputView::validateParticipantName);
    }

    private static void validateParticipantName(String participantName) {
        if (participantName == null || participantName.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 null 이거나 공백으로 입력할 수 없습니다.");
        }

        if (participantName.length() > ParticipantName.MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("참가자 이름은 최대 %d자까지 입력할 수 있습니다.", ParticipantName.MAX_LENGTH));
        }
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = SCANNER.nextInt();
        validateLadderHeight(input);
        return input;
    }

    private static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_VALUE_OF_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 보다 작은 숫자를 입력할 수 없습니다.", MIN_VALUE_OF_LADDER_HEIGHT));
        }
    }

}
