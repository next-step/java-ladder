package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.exception.DuplicateNameException;
import ladder.exception.NotFoundException;
import ladder.utils.StringSpliter;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String names) {
        String[] splitNames = StringSpliter.split(names);
        for (int i = 0; i < splitNames.length; i++) {
            validate(splitNames[i]);
            players.add(new Player(i, splitNames[i]));
        }
    }

    private void validate(String name) {
        boolean isExists = players.stream()
            .filter(player -> player.getPlayerName().equals(new PlayerName(name)))
            .findFirst()
            .isPresent();

        if (isExists) {
            throw new DuplicateNameException("동일한 이름을 가진 참여자가 존재합니다.");
        }
    }

    public int playerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }
}
