package nextstep.ladder.domain.game;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderConnectionLineConditional;
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
    private final LadderConnectionLineConditional drawingMachine;

    public LadderGame(LadderConnectionLineConditional drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    public Ladder createLadder(final LadderGameUserStore ladderGameUserStore, final int maxHeight) {
        LadderLines ladderLines = new LadderLines();
        for (int orderValue = 1; orderValue < ladderGameUserStore.count(); orderValue++) {
            ladderLines.addLine(Order.of(orderValue), drawingMachine, maxHeight);
        }
        ladderLines.addLine(Order.of(ladderGameUserStore.count()), () -> false, maxHeight);
        return Ladder.of(maxHeight, ladderGameUserStore, ladderLines);
    }

    public LadderResult execute(final Ladder ladder) {
        LadderGameUserStore ladderGameUserStore = ladder.getLadderGameUsers();
        Map<Point, LadderGameSnapshot> ladderResult = new HashMap<>();
        ladderResult.put(Point.of(0), initialize(ladderGameUserStore));
        final int maxPoint = ladder.getMaxPoint();

        for (int point = 1; point <= maxPoint; point++) {
            LadderGameSnapshot beforeSnapshot = ladderResult.get(Point.of(point).before());
            Map<LadderGameUser, Order> currentSnapshot = new HashMap<>();
            for (LadderGameUser ladderGameUser : ladderGameUserStore.getLadderGameUsers()) {
                Order beforeOrder = beforeSnapshot.findOrderOf(ladderGameUser);
                if (ladder.hasConnection(beforeOrder, Point.of(point))) { // 오른쪽이동
                    currentSnapshot.put(ladderGameUser, beforeOrder.next());
                } else if (beforeOrder.before().isPresent() && ladder.hasConnection(beforeOrder.before().get(), Point.of(point))) {
                    currentSnapshot.put(ladderGameUser, beforeOrder.before().get());
                } else {
                    currentSnapshot.put(ladderGameUser, beforeOrder);
                }
            }
            //Snapshot 추가
            ladderResult.put(Point.of(point), new LadderGameSnapshot(currentSnapshot));
        }
        return new LadderResult(ladderResult);
    }

    private LadderGameSnapshot initialize(final LadderGameUserStore ladderGameUserStore) {
        final AtomicInteger orderValue = new AtomicInteger(1);
        return ladderGameUserStore.getLadderGameUsers().stream()
                .collect(collectingAndThen(
                        toMap(user -> user, a -> Order.of(orderValue.getAndIncrement())), LadderGameSnapshot::new
                ));
    }
}
