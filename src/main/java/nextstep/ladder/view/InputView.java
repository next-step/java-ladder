package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER_COMMA = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public List<String> askNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            return toNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askNames();
    }

    private List<String> toNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("참여할 사람 이름을 입력하세요");
        }

        return Arrays.stream(input.split(DELIMITER_COMMA))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(name -> name.length() <= MAX_NAME_LENGTH)
                .collect(toList());
    }

    public int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return askLadderHeight();
    }

    public List<String> askLadderReward(int countOfPlayer) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        try {
            String input = SCANNER.nextLine();
            String[] reward = input.split(DELIMITER_COMMA);

            validateRewardCount(countOfPlayer, reward.length);

            return List.of(reward);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askLadderReward(countOfPlayer);
    }

    private void validateRewardCount(int countOfPlayer, int rewardCount) {
        if (countOfPlayer != rewardCount) {
            throw new IllegalArgumentException("인원 수 만큼 실행 결과를 입력하세요");
        }
    }

    public String askPlayerNameToConfirm() {
        System.out.println("결과를 보고 싶은 사람은?");

        try {
            String playerName = SCANNER.nextLine();

            validateNullOrBlank(playerName);

            return playerName.toLowerCase();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askPlayerNameToConfirm();
    }

    private void validateNullOrBlank(String playerName) {
        if (playerName == null || playerName.isBlank()) {
            throw new IllegalArgumentException("결과를 확인하고 싶은 사람의 이름이 비어있습니다");
        }
    }
}
