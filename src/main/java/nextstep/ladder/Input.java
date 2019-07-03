package nextstep.ladder;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUsers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int getMaxHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = scanner.nextInt();
        scanner.nextLine();
        return maxHeight;
    }

}
