package com.ladder.view;

import com.ladder.model.Players;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Players writeUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String result = scanner.nextLine();
        return Players.of(result);
    }

    public static int askNumberOfColumns(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int inputOfColumns = scanner.nextInt();
        newLine();
        return inputOfColumns;
    }

    private static void newLine() {
        scanner.nextLine();
    }
}
