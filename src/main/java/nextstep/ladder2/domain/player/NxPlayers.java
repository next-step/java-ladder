package nextstep.ladder2.domain.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NxPlayers {
    private final List<NxPlayer> playerList;

    public NxPlayers(List<String> names) {
        playerList = new ArrayList<>(names.size());
        for (int i = 0; i < names.size(); i++) {
            playerList.add(new NxPlayer(names.get(i)));
        }
    }

    public NxPlayer get(int i) {
        return playerList.get(i);
    }

    public NxPlayer findPlayerByName(String name) {
        return playerList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 플레이어가 없습니다."));
    }

    public int getPlayerCount() {
        return playerList.size();
    }

    public List<String> getAllPlayerNames() {
        return playerList.stream()
                .map(NxPlayer::getName)
                .collect(Collectors.toList());
    }
}
