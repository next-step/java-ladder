package nextstep.ladder.domain.game;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderConnectionConditional;
import nextstep.ladder.domain.LadderGameSnapshot;
import nextstep.ladder.domain.LadderLines;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public class LadderGame {
    private static final int FIRST_ORDER_NUMBER = 1;
    private final LadderConnectionConditional drawingMachine;

    public LadderGame(LadderConnectionConditional drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    public Ladder createLadder(final LadderGameUserStore ladderGameUserStore, final int maxHeight) {
        LadderLines ladderLines = new LadderLines();
        Point maxPoint = Point.of(maxHeight);

        for (int orderValue = 1; orderValue < ladderGameUserStore.count(); orderValue++) {
            ladderLines.addLine(Order.of(orderValue), drawingMachine, maxPoint);
        }

        addLastEmptyLine(ladderGameUserStore, ladderLines, maxPoint);

        return Ladder.of(maxPoint, ladderGameUserStore, ladderLines);
    }

    private void addLastEmptyLine(final LadderGameUserStore ladderGameUserStore, final LadderLines ladderLines, final Point maxPoint) {
        ladderLines.addLine(Order.of(ladderGameUserStore.count()), () -> false, maxPoint);
    }

    public LadderResult execute(final Ladder ladder) {
        LadderGameUserStore ladderGameUserStore = ladder.getLadderGameUsers();
        Map<Point, LadderGameSnapshot> ladderResult = new HashMap<>();
        ladderResult.put(Point.ZERO_BASE_POINT, createInitialSnapshot(ladderGameUserStore));
        final Point maxPoint = ladder.getMaxPoint();

        for (int point = 1, height = maxPoint.getPosition(); point <= height; point++) {
            LadderGameSnapshot beforeSnapshot = ladderResult.get(Point.of(point).before());
            Map<LadderGameUser, Order> currentSnapshot = createSnapshot(ladder, ladderGameUserStore, point, beforeSnapshot);
            //Snapshot 추가
            ladderResult.put(Point.of(point), new LadderGameSnapshot(currentSnapshot));
        }
        return new LadderResult(ladderResult);
    }

    private Map<LadderGameUser, Order> createSnapshot(final Ladder ladder, final LadderGameUserStore userStore, final int point, final LadderGameSnapshot beforeSnapshot) {
        Map<LadderGameUser, Order> currentSnapshot = new HashMap<>();
        for (LadderGameUser ladderGameUser : userStore.getLadderGameUsers()) {
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
        boolean isEnableToMove = beforeOrder.before()
                .map(before -> ladder.hasConnection(before, point))
                .orElse(false);

        if (isEnableToMove) {
            return beforeOrder.before().get();
        }
        return beforeOrder;
    }

    private LadderGameSnapshot createInitialSnapshot(final LadderGameUserStore ladderGameUserStore) {
        final AtomicInteger orderValue = new AtomicInteger(FIRST_ORDER_NUMBER);
        return ladderGameUserStore.getLadderGameUsers().stream()
                .collect(collectingAndThen(
                        toMap(user -> user, a -> Order.of(orderValue.getAndIncrement())), LadderGameSnapshot::new
                ));
    }
}
