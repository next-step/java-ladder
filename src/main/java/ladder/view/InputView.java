package ladder.view;

import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner;
    private Players players;
    private int ladderHeight;
    private Prize prize;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void inputLadderCondition() {
        inputPlayer();
        inputPrize();
        inputLadderHeight();
    }

    private void inputPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPlayers = scanner.nextLine();
        players = Players.of(Arrays.asList(StringUtil.split(inputPlayers.trim(), DELIMITER)));
    }

    private void inputPrize() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputPrize = scanner.nextLine();

        String[] splitPrize = StringUtil.split(inputPrize.trim(), DELIMITER);
        if (splitPrize.length != players.count()) {
            throw new IllegalArgumentException("실행 결과는 참가자 수 만큼 입력해 주세요.");
        }

        prize = Prize.of(Arrays.asList(StringUtil.split(inputPrize.trim(), DELIMITER)));
    }

    private void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public Players getPlayers() {
        return players;
    }

    public int playersCount() {
        return players.count();
    }

    public Prize getPrize() {
        return prize;
    }
}
