package nextstep.ladder.domain.game;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderConnectionConditional;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStorage;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public class LadderGame {
    private static final int FIRST_ORDER_NUMBER = 1;
    private final LadderConnectionConditional conditional;

    public LadderGame(LadderConnectionConditional conditional) {
        this.conditional = conditional;
    }

    public Ladder createLadder(final LadderGameUserStorage ladderGameUserStorage, final int maxHeight) {
        return new Ladder(ladderGameUserStorage.count(), conditional, maxHeight);
    }

    public LadderGameResult execute(final Ladder ladder, final LadderGameUserStorage users,
                                    final int maxPoint, final LadderGamePrize prize) {
        Map<Point, LadderGameSnapshot> ladderResult = new HashMap<>();
        ladderResult.put(Point.ZERO_BASE_POINT, createInitialSnapshot(users));

        for (int point = 1; point <= maxPoint; point++) {
            LadderGameSnapshot beforeSnapshot = ladderResult.get(Point.of(point).before());
            Map<LadderGameUser, Order> currentSnapshot = createSnapshot(ladder, users, point, beforeSnapshot);
            //Snapshot 추가
            ladderResult.put(Point.of(point), new LadderGameSnapshot(currentSnapshot));
        }
        return new LadderGameResult(ladderResult.get(Point.of(maxPoint)), prize);
    }

    private Map<LadderGameUser, Order> createSnapshot(final Ladder ladder, final LadderGameUserStorage userStore, final int point, final LadderGameSnapshot beforeSnapshot) {
        Map<LadderGameUser, Order> currentSnapshot = new HashMap<>();
        for (LadderGameUser ladderGameUser : userStore.findAll()) {
            Order beforeOrder = beforeSnapshot.findOrderOf(ladderGameUser);
            Order resultOrder = getCurrentOrder(ladder, beforeOrder, Point.of(point));
            currentSnapshot.put(ladderGameUser, resultOrder);
        }
        return currentSnapshot;
    }

    private Order getCurrentOrder(Ladder ladder, final Order beforeOrder, final Point point) {
        if (ladder.hasConnection(beforeOrder, point)) {
            return beforeOrder.next();
        }
        boolean isEnableToMoveLeft = beforeOrder.before()
                .map(before -> ladder.hasConnection(before, point))
                .orElse(false);

        if (isEnableToMoveLeft) {
            return beforeOrder.before().get();
        }
        return beforeOrder;
    }

    private LadderGameSnapshot createInitialSnapshot(final LadderGameUserStorage ladderGameUserStorage) {
        final AtomicInteger orderValue = new AtomicInteger(FIRST_ORDER_NUMBER);
        return ladderGameUserStorage.findAll().stream()
                .collect(collectingAndThen(
                        toMap(user -> user, a -> Order.of(orderValue.getAndIncrement())), LadderGameSnapshot::new
                ));
    }
}
