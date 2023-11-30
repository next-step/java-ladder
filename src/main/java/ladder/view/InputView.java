package ladder.view;

import ladder.model.Player;
import ladder.model.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SERARATOR = ",";
    private static final String ALL = "all";

    public static List<Player> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String players = scanner.nextLine();

        return Arrays.stream(players.split(SERARATOR))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int lineHeight = scanner.nextInt();
        validateLadderHeightInput(lineHeight);
        return lineHeight;
    }

    private static void validateLadderHeightInput(int lineHeight) {
        if (lineHeight == 0 || lineHeight < 0) {
            throw new IllegalArgumentException("사다리 높이가 0이거나 음수일 수 없습니다.");
        }
    }

    public static List<Prize> inputLadderPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String result = scanner.nextLine();

        return Arrays.stream(result.split(SERARATOR))
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public static Player inputLadderResultPlayer(List<Player> players) {
        scanner.nextLine();
        System.out.println("결과를 보고 싶은 사람은?");
        Player player = new Player(scanner.nextLine());
        validateParticipantPlayer(player, players);
        return player;
    }

    private static void validateParticipantPlayer(Player player, List<Player> players) {
        if (!ALL.equals(player.getName())){
            IntStream.range(0, players.size())
                    .filter(i -> Objects.equals(players.get(i).getName(), player.getName()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("사다리 게임 참여자가 아닙니다."));
        }
    }
}
