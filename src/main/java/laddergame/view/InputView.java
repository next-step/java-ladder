package laddergame.view;

import laddergame.domain.LadderGameReward;
import laddergame.domain.ParticipantName;
import laddergame.dto.LadderGameRunRequest;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final int MIN_VALUE_OF_LADDER_HEIGHT = 1;

    private InputView() {}

    public static LadderGameRunRequest inputLadderGameRunRequest() {
        List<String> participantNames = InputView.inputParticipantNames();
        List<String> rewards = InputView.inputRewards();
        validateParticipantNamesAndRewards(participantNames, rewards);
        int ladderHeight = InputView.inputLadderHeight();
        return new LadderGameRunRequest(participantNames, rewards, ladderHeight);
    }

    private static List<String> inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        List<String> participantNames = List.of(input.split(DELIMITER));
        validateParticipantNames(participantNames);
        return participantNames;
    }

    private static void validateParticipantNames(List<String> participantNames) {
        participantNames.forEach(InputView::validateParticipantName);

        if (participantNames.size() != getDistinctCountOfParticipantNames(participantNames)) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
    }

    private static void validateParticipantName(String participantName) {
        if (participantName == null || participantName.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 null 이거나 공백으로 입력할 수 없습니다.");
        }

        if (participantName.length() > ParticipantName.MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("참가자 이름은 최대 %d자까지 입력할 수 있습니다.", ParticipantName.MAX_LENGTH));
        }
    }

    private static int getDistinctCountOfParticipantNames(List<String> participantNames) {
        return (int) participantNames.stream()
                .distinct()
                .count();
    }

    private static List<String> inputRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        List<String> rewards = List.of(input.split(DELIMITER));
        validateRewards(rewards);
        return rewards;
    }

    private static void validateRewards(List<String> rewards) {
        rewards.forEach(InputView::validateReward);
    }

    private static void validateReward(String reward) {
        if (reward == null || reward.isBlank()) {
            throw new IllegalArgumentException("결과는 null 이거나 공백으로 입력할 수 없습니다.");
        }

        if (reward.length() > LadderGameReward.MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("결과는 최대 %d자까지 입력할 수 있습니다.", LadderGameReward.MAX_LENGTH));
        }

    }

    private static void validateParticipantNamesAndRewards(List<String> participantNames, List<String> rewards) {
        if (participantNames.size() != rewards.size()) {
            throw new IllegalArgumentException("입력하는 참가자 이름의 수와 결과의 수는 동일해야 합니다.");
        }
    }

    private static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = Integer.parseInt(SCANNER.nextLine());
        validateLadderHeight(input);
        return input;
    }

    private static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_VALUE_OF_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 보다 작은 숫자를 입력할 수 없습니다.", MIN_VALUE_OF_LADDER_HEIGHT));
        }
    }

    public static String inputNameForSearch() {
        System.out.println("결과를 보고 싶은 사람은?");
        String nameForSearch = SCANNER.nextLine();
        validateParticipantName(nameForSearch);
        return nameForSearch;
    }
}
