package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.ladder.model.ladder.Height;
import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.model.result.Result;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return createPlayersFromInput(input);
    }
    
    private static Players createPlayersFromInput(String input) {
        List<Player> playerList = parseInput(input, Player::new);
        return Players.from(playerList);
    }
    
    public static List<Result> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return parseInput(input, Result::new);
    }
    
    private static <T> List<T> parseInput(String input, java.util.function.Function<String, T> mapper) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(mapper)
                .collect(Collectors.toList());
    }
    
    public static Height inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return new Height(Integer.parseInt(scanner.nextLine()));
    }
    
    public static String inputResultQuery() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
