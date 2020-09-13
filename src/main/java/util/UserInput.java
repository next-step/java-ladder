package util;

import java.util.Scanner;

public class UserInput {
    private static final String NAME_INPUT_MESSEGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요).";
    private static final String MAX_HEIGHT_MESSEGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT= "실행결과";

    public static final Scanner SC = new Scanner(System.in);

    public static String[] userNameInput() {
        System.out.println(NAME_INPUT_MESSEGE);
        String input = SC.nextLine();
        String names[] = input.split(",");

        return names;
    }

    public static int inputHeight() {
        System.out.println(MAX_HEIGHT_MESSEGE);
        int height = SC.nextInt();
        return height;
    }
    public static void showResult(){
        System.out.println(RESULT);
    }
}
