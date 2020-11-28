package nextstep.ladder.view;

import nextstep.ladder.entity.ladder.Floor;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.Point;
import nextstep.ladder.entity.ladder.Users;

public class LadderResultView extends AbstractView {

    private static final String BACKWARD_LINK_POINT = "-----|";
    private static final String BACKWARD_EMPTY_LINK_POINT = "     |";

    public static void display(Ladder ladder, Users users) {
        // 유저 이름 출력
        stringBuilder.append(users.getUserNames());
        printAndClear();

        // 사다리 출력
        displayLadder(ladder);
    }

    private static void displayLadder(Ladder ladder) {
        floorView(ladder.getFirstFloor());
    }

    private static void floorView(Floor floor) {

        pointChainingView(floor.getStartPoint());

        printAndClear();

        if (floor.hasNext()) {
            floorView(floor.getNextFloor());
        }
    }

    private static void pointChainingView(Point point) {
        String pointWithLinkView = point.hasBackwardLink() ?
                BACKWARD_LINK_POINT
                : BACKWARD_EMPTY_LINK_POINT;
        stringBuilder.append(pointWithLinkView);

        if (point.hasNext()) {
            pointChainingView(point.getNext());
        }
    }
}
