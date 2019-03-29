package view;

import domain.Ladders;
import domain.Players;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = sc.nextLine();
        System.out.println();

        return Players.generate(names);
    }

    public static Ladders inputLadders(int size) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        System.out.println();

        return Ladders.generate(height, size);
    }
}
