package nextstep.ladder.domain.game;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStorage;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static nextstep.ladder.domain.vo.Point.ZERO_BASE_POINT;

public class LadderGameResult {
    private static final int FIRST_ORDER_NUMBER = 1;
    private final LadderProcessSnapshot ladderProcessSnapshot;
    private final LadderGamePrize ladderGamePrize;

    private LadderGameResult(final Ladder ladder, final LadderGameUserStorage users, final int maxPoint, LadderGamePrize prize) {
        Map<Point, LadderProcessSnapshot> ladderResult = init(ladder, users, maxPoint);
        this.ladderProcessSnapshot = ladderResult.get(Point.of(maxPoint));
        this.ladderGamePrize = prize;
        if (ladderProcessSnapshot.count() != ladderGamePrize.count()) {
            throw new IllegalArgumentException("사용자와 상품은 일치해야합니다");
        }
    }

    public static LadderGameResult of(final Ladder ladder, final LadderGameUserStorage users, final int maxPoint, LadderGamePrize prize) {
        return new LadderGameResult(ladder, users, maxPoint, prize);
    }

    private Map<Point, LadderProcessSnapshot> init(final Ladder ladder, final LadderGameUserStorage users, final int maxPoint) {
        Map<Point, LadderProcessSnapshot> ladderResult = new HashMap<>();
        ladderResult.put(ZERO_BASE_POINT, createInitialSnapshot(users));
        for (int point = 1; point <= maxPoint; point++) {
            LadderProcessSnapshot beforeSnapshot = ladderResult.get(Point.of(point).before());
            LadderProcessSnapshot currentSnapshot = createSnapshot(ladder, users, point, beforeSnapshot);
            ladderResult.put(Point.of(point), currentSnapshot);
        }
        return ladderResult;
    }

    private LadderProcessSnapshot createInitialSnapshot(final LadderGameUserStorage ladderGameUserStorage) {
        final AtomicInteger orderValue = new AtomicInteger(FIRST_ORDER_NUMBER);
        return ladderGameUserStorage.findAll().stream()
                .collect(collectingAndThen(
                        toMap(user -> user, a -> Order.of(orderValue.getAndIncrement())), LadderProcessSnapshot::new
                ));
    }

    private LadderProcessSnapshot createSnapshot(final Ladder ladder, final LadderGameUserStorage userStore, final int point, final LadderProcessSnapshot beforeSnapshot) {
        Map<LadderGameUser, Order> currentSnapshot = new HashMap<>();
        for (LadderGameUser ladderGameUser : userStore.findAll()) {
            Order beforeOrder = beforeSnapshot.findOrderOf(ladderGameUser);
            Order resultOrder = getCurrentOrder(ladder, beforeOrder, Point.of(point));
            currentSnapshot.put(ladderGameUser, resultOrder);
        }
        return new LadderProcessSnapshot(currentSnapshot);
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

    public String getPrizeOf(LadderGameUser gameUser) {
        Order order = ladderProcessSnapshot.findOrderOf(gameUser);
        return ladderGamePrize.findByOrder(order);
    }
}
