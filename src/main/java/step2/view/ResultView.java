package step2.view;

import step2.domain.Ladder;
import step2.domain.Users;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultView {
    private static final String TEXT_BAR = "|";
    private static final String TEXT_LINE = "-";
    private static final String TEXT_SPACE = " ";

    public static void printLadder(Ladder ladder, Users user) {
        int repeatCount = getMaxUserLength(user);
        String textLine = repeatText(TEXT_LINE, repeatCount);
        String textSpace = repeatText(TEXT_SPACE, repeatCount);

        System.out.println(user.getUsers().stream()
                .map(u -> userFormat(repeatCount, u))
                .collect(Collectors.joining()));

        ladder.getLadder().stream().forEach(line -> {
            StringBuilder stringBuilder = new StringBuilder();
            line.getPoints().forEach(point -> {
                stringBuilder.append(TEXT_BAR);
                stringBuilder.append(point ? textLine : textSpace);
            });
            stringBuilder.append(TEXT_BAR);
            System.out.println(stringBuilder);
        });
    }

    private static String repeatText(String text, int count) {
        String[] textArr = new String[count];
        Arrays.fill(textArr, text);
        return String.join("", textArr);
    }

    private static String userFormat(int count, String user) {
        return String.format("%-" + (count + 1) + "s", user);
    }

    private static int getMaxUserLength(Users users) {
        return users.getUsers().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }
}
