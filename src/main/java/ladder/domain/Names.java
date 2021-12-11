package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String PLAYER_ERROR_MESSAGE = "error : 사다리 게임 은 혼자할수 없습니다.";
    private static final String NAME_ERROR_MESSAGE = "error : 없는 이름입니다.";
    private static final int PLAYER_NAME_MIN = 2;

    private final List<Name> names;

    public Names(List<String> names) {
        this.names = playerName(names);
    }

    private List<Name> playerName(List<String> names) {
        validPlayerNameCount(names.size());
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validPlayerNameCount(int count) {
        if (count < PLAYER_NAME_MIN) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
    }

    public Name name(int index){
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

    public String value(int index) {
        return names.get(index).value();
    }

    public Name playerName(String playerName){
        return names.stream()
                .filter(name -> name.value().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NAME_ERROR_MESSAGE));
    }

}
