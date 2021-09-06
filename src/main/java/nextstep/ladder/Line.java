package nextstep.ladder;

import nextstep.ladder.participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    private Line(int size, MiddleLadder random) {
        for (int i = 0; i < size; i++) {
            points.add(random.makeBoolean());
        }
        random.resetLine();
    }

    public static Line of(int size, MiddleLadder random) {
        return new Line(size, random);
    }


    public int getSize() {
        return points.size();
    }

    public List<Boolean> pointLists() {
        return new ArrayList<Boolean>(points);
    }

    public void movePlayer(Participant participant) {
        Point point = new Point(participant.position(), points.size());
        boolean left = false;
        boolean right = false;
        System.out.println(point.left());
        System.out.println(point.right());
        System.out.println();
        if (point.left() != Integer.MIN_VALUE) {
            right = points.get(point.left());
        } else if (point.right() != Integer.MAX_VALUE) {
            left = points.get(point.right());
        }
       if(right){
           point.moveRight();
       }else if(left){
            point.moveLeft();
       }
       participant.movePosition(point.position());
    }
}
