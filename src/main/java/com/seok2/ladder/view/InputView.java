package com.seok2.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String NAMES_OF_PLAYER_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        System.out.println(NAMES_OF_PLAYER_MSG);
        return scanner.nextLine();
    }

    public static int getHeigth() {
        System.out.println(NAMES_OF_PLAYER_MSG);
        return scanner.nextInt();
    }

}
