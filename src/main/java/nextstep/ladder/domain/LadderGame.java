package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Members members;
    private final Layer layer;

    public LadderGame(String memberNames, int layer) {
        this(new Members(memberNames), new Layer(layer));
    }

    public LadderGame(Members members, Layer layer){
        this.members = members;
        this.layer = layer;
    }

    public Ladder create(PointStrategy pointStrategy) {
        List<Line> Lines = new ArrayList<>();
        while(moreLayer()){
            Lines.add(generate(pointStrategy));
        }
        return new Ladder(Lines);
    }

    public Line generate(PointStrategy pointStrategy) {
        layer.nextLayer();
        return new Line(members.countOfMember(), pointStrategy);
    }

    public boolean moreLayer(){
        return layer.moreLayer();
    }

    public Members getMembers() {
        return members;
    }
}
