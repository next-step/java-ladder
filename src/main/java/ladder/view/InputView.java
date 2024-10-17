package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ladder.Player;

public class InputView {

    private static final String DELIMITER = ",";

    public static List<Player> inputPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitPlayer(scanner.nextLine());
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private static List<Player> splitPlayer(String inputPlayers) {
        String[] players = inputPlayers.split(DELIMITER);
        List<Player> playerList = new ArrayList<>();
        for (String player : players) {
            playerList.add(new Player(player));
        }

        return playerList;
    }
}
