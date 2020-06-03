package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.RandomPointStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LadderFactory {

    private LadderFactory() { }

    public static Ladder create(Players players, Height height) {
        validatePlayers(players);
        validateHeight(height);

        List<Line> lines = Stream.generate(() -> LineFactory.create(players.getCount(), new RandomPointStrategy()))
                .limit(height.getHeight())
                .collect(Collectors.toList());

        return Ladder.newInstance(players, Lines.newInstance(lines));
    }

    private static void validatePlayers(Players players) {
        if (players == null) {
            throw new IllegalArgumentException("참여자 정보가 존재하지 않습니다.");
        }
    }

    private static void validateHeight(Height height) {
        if (height == null) {
            throw new IllegalArgumentException("사다리 높이 정보가 존재하지 않습니다.");
        }
    }
}
