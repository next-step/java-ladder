package view;

import domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static Players promptForPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        System.out.println();
        return new Players(Arrays.stream(input.split(","))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public static Height promptForHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        System.out.println();
        return new Height(height - 1);
    }

    public static Rewards promptForRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        System.out.println();
        return new Rewards(Arrays.stream(input.split(","))
                .map(Reward::new)
                .collect(Collectors.toList()));
    }
}
