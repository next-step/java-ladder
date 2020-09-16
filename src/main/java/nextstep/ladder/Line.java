package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Point> line = new ArrayList<>();

    private Line(int size) {
        Point prevPoint = new Point();
        for(int i = 1 ; i < size; i ++){
            Point point = prevPoint.next();
            line.add(point);

            prevPoint = point;
        }
    }

    public static Line of(int size){
        return new Line(size);
    }

//    public String getLadderLine(){
//        StringBuilder str = new StringBuilder();
//
//        String lineStr = line.stream()
//                            .map(this::getSignal)
//                            .collect(Collectors.joining("|"));
//
//        return str.toString();
//    }
//
//    private String getSignal(Point p){
//        if(p.getDirection() == Direction.RIGHT){
//            return "-----";
//        }
//
//        return "     ";
//    }
//    @Override
//    public String toString() {
//        return getLadderLine();
//    }
//

    public List<Point> getLine(){
        return new ArrayList<>(line);
    }
}
