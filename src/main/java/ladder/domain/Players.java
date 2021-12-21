package ladder.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Name> names;

    private Players(List<Name> names) {
        this.names = names;
    }

    public static Players of(String names) {
        if (isEmpty(names)) {
            throw new IllegalArgumentException("참여할 사람의 이름을 입력해주세요");
        }

        String[] namesString = names.split(",");
        List<Name> players = Arrays.stream(namesString)
                .map(player -> new Name(player))
                .collect(Collectors.toList());
        return new Players(players);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public List<Name> get() {
        return names;
    }

    public int countOfPlayers() {
        return names.size();
    }

    public int findIndexByName(String name) {
        int result = names.indexOf(new Name(name));
        if (result == -1) {
            throw new IllegalArgumentException("찾을 수 없는 이름입니다.");
        }
        return result;
    }

}
