package nextstep.ladder.view;

import java.util.Scanner;

public final class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PERSON_NAMES_REQUEST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PERSON_NAME_DELIMITER = ",";
    private static final String LADDER_HEIGHT_REQUEST_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private InputView() {
    }

    private static void printLine(final String message) {
        System.out.println(message);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static String getUserInput() {
        final String result = SCANNER.nextLine().trim();
        printEmptyLine();
        return result;
    }

    public static int getLadderHeight() {
        printLine(LADDER_HEIGHT_REQUEST_MESSAGE);
        return parseInt(getUserInput());
    }

    public static String[] getPlayerNames() {
        printLine(PERSON_NAMES_REQUEST_MESSAGE);
        return parsePersonNames(getUserInput());
    }

    private static int parseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Ladder height can not be numeric");
        }
    }

    private static String[] parsePersonNames(final String personNames) {
        validatePersonNames(personNames);
        return personNames.split(PERSON_NAME_DELIMITER);
    }

    private static void validatePersonNames(final String personNames) {
        if (personNames == null) {
            throw new IllegalArgumentException("Person Names can not be null");
        }
        if (personNames.isBlank()) {
            throw new IllegalArgumentException("Person Names can not be blank");
        }
    }

}