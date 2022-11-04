package ladder.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ladder.user.Player;
import ladder.user.UserName;

public class LadderResult {

    private final Map<Player, Award> result;

    public LadderResult(Map<Player, Award> result) {
        this.result = result;
    }

    public Award getTargetPlayer(UserName userName) {
        return result.keySet().stream()
            .filter(player -> player.getUserName().equals(userName))
            .findFirst()
            .map(result::get)
            .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 플레이어입니다."));
    }

    public List<Award> getValues() {
        return new ArrayList<>(result.values());
    }
}
