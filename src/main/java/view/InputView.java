package view;

import domain.Height;
import domain.Player;
import domain.Players;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static Players promptForPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();
        return new Players(Arrays.stream(input.split(","))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public static Height promptForHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        System.out.println();
        return new Height(height);
    }
}
