package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> line = new ArrayList<>();

    public Line(int size) {
        Point prevPoint = new Point();
        for(int i = 1 ; i < size; i ++){
            Point point = new Point(prevPoint);
            line.add(point);

            prevPoint = point;
        }
    }

    public String printLine(){
        StringBuilder str = new StringBuilder();

        String lineStr = line.stream()
                            .map(this::getSignal)
                            .collect(Collectors.joining("|"));

        str.append("   ");
        str.append("|");
        str.append(lineStr);
        str.append("|");

        return str.toString();
    }

    private String getSignal(Point p){
        if(p.getDirection() == Direction.RIGTH){
            return "-----";
        }

        return "     ";
    }

    @Override
    public String toString() {
        return printLine();
    }
}
