package step2.domain;

import step2.exception.IllegalPlayerName;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    public static final int FULL_LENGTH = 6;
    public static final int NAME_MAX_SIZE = 5;

    private final String name;

    public Player(String player) {
        if (player.length() > NAME_MAX_SIZE) {
            throw new IllegalPlayerName("이름이 5글자를 초과할수 없습니다.");
        }

        this.name = player;
    }

    public String getName() {
        int blankSize = FULL_LENGTH - name.length();
        String blank = Stream.generate(() -> " ")
                .limit(blankSize)
                .collect(Collectors.joining());

        return blank + name;
    }
}
