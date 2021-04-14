package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import step4.exception.DuplicateNameException;
import step4.util.StringSpliter;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String names) {
        String[] splitNames = StringSpliter.split(names);
        IntStream.range(0, splitNames.length)
            .forEach(i -> {
                validate(splitNames[i]);
                players.add(new Player(i, splitNames[i]));
            });
    }

    private void validate(String name) {
        boolean isExists = players.stream()
            .filter(player -> player.isNameEqual(new PlayerName(name)))
            .findFirst()
            .isPresent();

        if (isExists) {
            throw new DuplicateNameException("동일한 이름을 가진 참여자가 존재합니다.");
        }
    }

    public int playerCount() {
        return players.size();
    }
}
