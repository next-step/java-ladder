package ladder.view;

import ladder.model.Player;
import ladder.model.Players;
import ladder.model.Reward;
import ladder.model.Rewards;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String QUESTION_FOR_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String QUESTION_FOR_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String QUESTION_FOR_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String QUESTION_FOR_RESULT = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    public static Players askPlayers() {
        System.out.println(QUESTION_FOR_PLAYERS);

        String input = scanner.nextLine();
        List<String> names = Arrays.asList(input.split(","));

        return Players.of(names);
    }

    public static Rewards askRewards() {
        System.out.println(QUESTION_FOR_REWARDS);

        String input = scanner.nextLine();
        List<String> valuesOfRewards = Arrays.asList(input.split(","));
        return Rewards.of(valuesOfRewards);
    }

    public static int askHeight() {
        System.out.println(QUESTION_FOR_LADDER_HEIGHT);

        return scanner.nextInt();
    }

}
