package nextstep.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        this.players = new ArrayList<>();
        boolean match = Arrays.stream(names)
                .anyMatch(s -> s.length() > 5);
        if (match) {
            throw new IllegalArgumentException("사람의 이름은 최대5글자까지 부여할 수 있습니다.");
        }
        for (String name : names) {
            this.players.add(new Player(name));
        }
    }
    public String spacedNames() {
        return this.players.stream()
                .map(p -> p.player())
                .collect(Collectors.joining(EMPTY_LADDER_STRING,"",""));
    }

    public int filter(Player player) {
        int indexOf = -1;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).equals(player)) {
                indexOf = i;
                break;
            }

        }
        return indexOf;
    }
}
