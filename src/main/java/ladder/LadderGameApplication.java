package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        List<String> playerStrings = Arrays.asList(names);
        Players players = new Players(playerStrings);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = Integer.parseInt(scanner.nextLine());

        System.out.println("실행결과");
        LadderGame ladderGame = new LadderGame(players, maxHeight);
        Ladder ladder = ladderGame.createLadder();
        for (int i = 0; i < ladder.height(); i++) {
            System.out.println("사다리 " + (i + 1) + ": " + ladder.getLadderLine(i));
        }

    }
}
