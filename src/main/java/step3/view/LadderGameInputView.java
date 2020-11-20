package step3.view;

import step3.domain.ladder.LadderPlayers;

import java.util.Scanner;

public class LadderGameInputView implements InputView {
    public static final String QUESTION_JOIN_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    public static final String QUESTION_MAXIMUM_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String QUESTION_LADDER_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final Scanner scanner;

    public LadderGameInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getPlayerNames() {
        System.out.println(QUESTION_JOIN_PLAYER_NAMES);
        return scanner.nextLine();
    }

    @Override
    public Integer getLadderHeight() {
        System.out.println(QUESTION_MAXIMUM_LADDER_HEIGHT);
        return nextInt();
    }

    @Override
    public String getLadderResult(int maxSize) {
        System.out.println(QUESTION_LADDER_RESULTS);
        return scanner.nextLine();
    }

    @Override
    public String findResultByPlayer(LadderPlayers players) {
        System.out.println("결과를 보고 싶은 사람은?");
        String playerName = scanner.nextLine();

        return players.existsPlayer(playerName);
    }

    private Integer nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }
}
