package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(String[] inputNames) {
        validate(inputNames);

        List<Player> playerList = new ArrayList<>();
        for (String input : inputNames) {
            playerList.add(new Player(input.trim()));
        }

        this.players = playerList;
    }

    private void validate(String[] names) {
        checkNameSizeIsValid(names);
    }

    private void checkNameSizeIsValid(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException("이름의 갯수는 최소 1개 이상이어야 합니다.");
        }
    }

    public int size() {
        return this.players.size();
    }

    public Player name(String inputName) {
        return this.players.stream()
                .filter(name -> name.isSame(inputName))
                .findAny()
                .orElse(Player.NONE);
    }

    public Player find(Position position) {
        return this.players.get(position.current());
    }

    @Override
    public Iterator<Player> iterator() {
        return this.players.iterator();
    }
}
