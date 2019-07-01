package com.jaeyeonling.ladder.view.console;

import java.util.Scanner;

public final class ConsoleInputView {

    private static final String READ_USERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_LADDER_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_USERNAME_OF_WANT_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String READ_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner CONSOLE = new Scanner(System.in);

    private ConsoleInputView() { }

    public static String readUsers() {
        return readStringWithMessage(READ_USERS_MESSAGE);
    }

    public static String readLadderResults() {
        ConsoleOutputView.newline();

        return readStringWithMessage(READ_LADDER_RESULTS_MESSAGE);
    }

    public static int readLadderHeight() {
        ConsoleOutputView.newline();

        return readIntWithMessage(READ_LADDER_HEIGHT_MESSAGE);
    }

    public static String readUsernameOfWantResult() {
        ConsoleOutputView.newline();

        return readStringWithMessage(READ_USERNAME_OF_WANT_RESULT_MESSAGE);
    }

    private static String readStringWithMessage(final String message) {
        ConsoleOutputView.print(message);
        return readString();
    }

    private static String readString() {
        return CONSOLE.nextLine();
    }

    private static int readIntWithMessage(final String message) {
        ConsoleOutputView.print(message);
        return readInt();
    }

    private static int readInt() {
        final int readValue = CONSOLE.nextInt();
        CONSOLE.nextLine();

        return readValue;
    }
}