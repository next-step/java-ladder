package ladder.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Name> names;

    public Players(String names) {
        if (isEmpty(names)) {
            throw new IllegalArgumentException("참여할 사람의 이름을 입력해주세요");
        }
        this.names = init(names);
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static List<Name> init(String playersString) {
        String[] players = playersString.split(",");
        return Arrays.stream(players)
                .map(player -> new Name(player))
                .collect(Collectors.toList());
    }

    public List<Name> get() {
        return names;
    }

    public int countOfPlayers() {
        return names.size();
    }

}
