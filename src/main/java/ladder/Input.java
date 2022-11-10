package ladder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String SEPARATOR = ",";
    private static final Scanner sc = new Scanner(System.in);

    static String input() {
        return sc.nextLine();
    }

    public static int integer() {
        String input = input();
        try {
            int i = Integer.parseInt(input);
            checkLeastLadders(i);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1이상인 숫자만 입력해주세요");
        }
    }

    private static void checkLeastLadders(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("1이상 입력해주세요");
        }
    }

    public static List<String> players() {
        String input = input();
        validateSeparator(input);
        List<String> players = Stream.of(input.split(SEPARATOR)).collect(Collectors.toList());
        validatePlayersLength(players);
        return players;
    }

    private static void validatePlayersLength(List<String> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("2명이상 입력해주세요");
        }
        for (String player : players) {
            validatePlayerName(player);
        }
    }

    private static void validatePlayerName(String player) {
        if (player.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자만 입력 가능합니다.");
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException("구분자 ',' 를 입력해주세요");
        }
    }
}
