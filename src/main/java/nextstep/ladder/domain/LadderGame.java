package nextstep.ladder.domain;

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

    public Ladder createLadder(final LadderGameUsers ladderGameUsers, final int maxHeight) {
        LadderLines ladderLines = new LadderLines();
        for (int orderValue = 1; orderValue < ladderGameUsers.size(); orderValue++) {
            ladderLines.addLine(Order.of(orderValue), drawingMachine, maxHeight);
        }
        ladderLines.addLine(Order.of(ladderGameUsers.size()), () -> false, maxHeight);
        return Ladder.of(maxHeight, ladderGameUsers, ladderLines);
    }

    public LadderResult execute(final Ladder ladder) {
        LadderGameUsers ladderGameUsers = ladder.getLadderGameUsers();
        Map<Point, LadderGameSnapshot> ladderResult = new HashMap<>();
        ladderResult.put(Point.of(0), initialize(ladderGameUsers));
        final int maxPoint = ladder.getMaxPoint();

        for (int point = 1; point <= maxPoint; point++) {
            LadderGameSnapshot beforeSnapshot = ladderResult.get(Point.of(point).before());
            Map<LadderGameUser, Order> currentSnapshot = new HashMap<>();
            for (LadderGameUser ladderGameUser : ladderGameUsers.getLadderGameUsers()) {
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

    private LadderGameSnapshot initialize(final LadderGameUsers ladderGameUsers) {
        final AtomicInteger orderValue = new AtomicInteger(1);
        return ladderGameUsers.getLadderGameUsers().stream()
                .collect(collectingAndThen(
                        toMap(user -> user, a -> Order.of(orderValue.getAndIncrement())), LadderGameSnapshot::new
                ));
    }
}
