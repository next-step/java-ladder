package view;

import java.util.Scanner;

public class InputView {

    public static String inputUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
