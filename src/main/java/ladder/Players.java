package ladder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players extends EndPoints {
    public Players(String names) {
        super(parse(StringUtils.split(names)));
    }

    private static List<Player> parse(List<String> strings) {
        return IntStream.range(0, strings.size())
                .mapToObj(i -> new Player(i, strings.get(i)))
                .collect(Collectors.toList());
    }

    public void descendByOrder(Ladder ladder) {
        getPlayers().forEach(player -> player.descend(ladder));
    }

    public List<Player> getPlayers() {
        return this.endPoints.stream().map(player -> (Player) player).collect(Collectors.toList());
    }

    public Player match(String selectedPlayer) {
        Optional<Player> found = getPlayers()
                .stream()
                .filter(player -> player.equalsName(selectedPlayer)).findFirst();
        return found.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }
}
