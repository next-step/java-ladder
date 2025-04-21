package ladder.view;

import ladder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REGEX = ",";

    public static List<Player> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] tokens = getTokens();

        List<Player> players = new ArrayList<>();
        for (String token : tokens) {
            players.add(new Player(token.trim()));
        }
        if (players.isEmpty()) {
            throw new IllegalArgumentException("최소 1명 이상의 이름이 필요합니다.");
        }
        return players;
    }

    public static String askPlayerName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private static String[] getTokens() {
        String input = scanner.nextLine();
        return input.split(REGEX);
    }

    public static Results readResults(Players players) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] tokens = getTokens();

        List<Result> results = new ArrayList<>();
        for (String token : tokens) {
            results.add(new Result(token.trim()));
        }
        return new Results(results, players);
    }

    public static int readHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
