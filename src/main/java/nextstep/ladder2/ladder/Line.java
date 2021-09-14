package nextstep.ladder2.ladder;

import nextstep.ladder2.player.Direction;
import nextstep.ladder2.player.Players;
import nextstep.ladder2.point.LadderPoint;
import nextstep.ladder2.point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Boolean> ladderLine;

    public Line(LineMaker maker, int size) {
        boolean pre = false;
        this.ladderLine = new ArrayList<>();
        for(int i=0; i<size; i++){
            pre = maker.makeLine(pre);
            ladderLine.add(maker.makeLine(pre));
        }
    }

    public List<Boolean> showLine(){
        return new ArrayList<>(ladderLine);
    }

    public void playLadderLine(Players players){
        List<Direction> dir = players.indexes().stream()
                .map(position -> new Point(position, players.size()))
                .map(LadderPoint::new)
                .map(point -> point.chooseDirection(ladderLine))
                .collect(Collectors.toList());
        players.move(dir);
    }

    @Override
    public String toString() {
        return ladderLine.toString();
    }
}
