package com.hskim.ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String USER_NAMES_DELIMITER = ",";
    private static final String PARTICIPANTS_PHRASE = "참여할 사람 이름을 입력하세요. " +
            "(이름은 (" + USER_NAMES_DELIMITER + ")로 구분하세요)";
    private static final String LADDER_HEIGHT_PHRASE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    public void printParticipantsPhrase() {
        System.out.println(PARTICIPANTS_PHRASE);
    }

    public List<String> getUserNames() {
        String[] userNames = scanner.nextLine()
                .replaceAll(WHITE_SPACE_REGEX, BLANK_STRING)
                .split(USER_NAMES_DELIMITER);

        return Arrays.stream(userNames)
                .collect(Collectors.toList());
    }

    public void printLadderHeightPhrase() {

        System.out.println(NEW_LINE + LADDER_HEIGHT_PHRASE);
    }

    public int getLadderHeight() {
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}
