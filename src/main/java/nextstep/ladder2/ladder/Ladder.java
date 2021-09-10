package nextstep.ladder2.ladder;

import nextstep.ladder2.player.Players;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(LineMaker maker, int height, int size) {
        for(int i=0; i<height; i++){
            lines.add(new Line(maker, size-1));
        }
    }

    public List<Line> lines(){
        return new ArrayList<>(lines);
    }

    public void play(Players players) {
        lines.stream()
                .forEach(line -> line.playLadderLine(players));
    }
}
