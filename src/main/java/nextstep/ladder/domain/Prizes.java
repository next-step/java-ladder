package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames) {
        prizes = new ArrayList<>();
        prizeNames.stream()
                .map(Prize::new)
                .forEach(prizes::add);
    }

    public Prize givePrizeTo(Player player) {
        return IntStream.range(0, prizes.size())
                .filter(i -> player.isPlayerInPosition(new Point(i)))
                .mapToObj(prizes::get)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("플레이어 위치에 맞는 Prize을 찾을 수 없습니다."));
    }

    public List<String> getAllPrizesName() {
        return prizes.stream()
                .map(Prize::toString)
                .collect(Collectors.toList());
    }
}
