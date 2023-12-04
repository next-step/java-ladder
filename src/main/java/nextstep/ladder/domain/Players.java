package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(String inputNames) {
        String[] inputs = inputNames.split(",");

        List<Player> playerList = new ArrayList<>();
        for (String input : inputs) {
            playerList.add(new Player(input.trim()));
        }

        this.players = playerList;
        validate(this.players);
    }

    private void validate(List<Player> players) {
        checkNameSizeIsValid(players);
    }

    private void checkNameSizeIsValid(List<Player> players) {
        if (players.isEmpty()) {
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

    public Player find(int index) {
        return this.players.get(index);
    }

    @Override
    public Iterator<Player> iterator() {
        return this.players.iterator();
    }
}
