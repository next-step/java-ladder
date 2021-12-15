package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderGame {
    private final Members members;
    private final Layer layer;

    public LadderGame(String memberNames, int layer) {
        this(new Members(memberNames), new Layer(layer));
    }

    public LadderGame(Members members, Layer layer) {
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

    private boolean moreLayer() {
        return layer.moreLayer();
    }

    public Members getMembers() {
        return members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(members, that.members) &&
                Objects.equals(layer, that.layer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, layer);
    }
}
