package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Player extends LadderItem {

    public static final String NULL_CHECK_ERROR_MESSAGE = "참여자 이름을 입력해 주세요.";
    public static final String LENGTH_CHECK_ERROR_MESSAGE = "참여자 이름은 1~5자로 설정 하세요.";

    private static final Map<String, Player> playersMap = new HashMap<>();

    public static Player of(String name) {
        Player player = playersMap.get(name);

        if (player == null) {
            playersMap.put(name, new Player(name));

            player = playersMap.get(name);
        }

        return player;
    }

    private Player(String name) {
        super(name);
    }

    @Override
    protected String nullCheckErrorMessage() {
        return NULL_CHECK_ERROR_MESSAGE;
    }

    @Override
    protected String lengthCheckErrorMessage() {
        return LENGTH_CHECK_ERROR_MESSAGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
