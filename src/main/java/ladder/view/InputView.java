package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ladder.LadderResult;
import ladder.Player;
import ladder.Players;

public class InputView {

    private static final String DELIMITER = ",";

    public static Players inputPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitPlayer(scanner.nextLine());
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();

        if (height <= 0) {
            throw new IllegalArgumentException("height must be greater than 0");
        }

        return height;
    }

    public static LadderResult inputResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String resultStrings = scanner.nextLine();
        return new LadderResult(resultStrings.split(DELIMITER));
    }

    private static Players splitPlayer(String inputPlayers) {
        String[] players = inputPlayers.split(DELIMITER);
        List<Player> playerList = new ArrayList<>();
        for (String player : players) {
            playerList.add(new Player(player));
        }

        return new Players(playerList);
    }
}
