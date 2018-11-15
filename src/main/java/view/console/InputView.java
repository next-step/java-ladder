package view.console;

import java.util.Scanner;

public class InputView {

    public static String[] names(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split(",");
        return names;
    }

    public static int ladderCount() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner sc = new Scanner(System.in);
        int ladderCount = sc.nextInt();
        return ladderCount;
    }
}
