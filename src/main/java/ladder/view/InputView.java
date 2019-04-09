package ladder.view;

import ladder.Utils;
import ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public List<Player> printInputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        String[] names = Utils.stringSplitWithDelimiter(inputValue, ",");
        List<Player> players = Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
        return players;
    }

    public int printInputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return Integer.parseInt(inputValue);
    }


}
