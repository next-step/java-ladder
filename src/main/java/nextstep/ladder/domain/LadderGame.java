package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Members members;
    private final int layer;

    public LadderGame(String memberNames, int layer) {
        this(new Members(memberNames), layer);
    }

    public LadderGame(Members members, int layer){
        this.members = members;
        this.layer = layer;
    }

    public Ladder generate(PointStrategy pointStrategy) {
        // pointStrategy.generate();
//        new Ladder(ladderheight)
        List<Line> Lines = new ArrayList<>();
        while(moreLayer()){
            Lines.add(gen(pointStrategy));
        }
        return new Ladder(Lines);
    }

    public Line gen(PointStrategy pointStrategy) {
//        layer.nextLayer();
        return new Line(1);
    }

    public boolean moreLayer(){
        // return layer.moreLayer();
        return true;
    }

    public Members getMembers() {
        return members;
    }
}
