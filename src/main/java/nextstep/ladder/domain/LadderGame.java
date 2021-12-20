package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Members members;
    private final Layer layer;

    public LadderGame(Members members, Layer layer) {
        this.members = members;
        this.layer = layer;
    }

    public Ladder create(PointStrategy pointStrategy) {
        List<Line> Lines = new ArrayList<>();
        while (moreLayer()) {
            Lines.add(generate(pointStrategy));
        }
        return new Ladder(Lines);
    }

    private boolean moreLayer() {
        return layer.moreLayer();
    }

    private Line generate(PointStrategy pointStrategy) {
        layer.nextLayer();
        return Line.of(members.countOfMember(), pointStrategy);
    }

    public LadderResults start(Ladder ladder, Rewards rewards) {
        List<LadderResult> results = new ArrayList<>();
        int memberPosition = 0;
        for (Member member : members.getMembers()) {
            int position = getPosition(ladder, memberPosition);
            results.add(new LadderResult(member, rewards.getRewards(position)));
            memberPosition++;
        }
        return new LadderResults(results);
    }

    private int getPosition(Ladder ladder, int position) {
        for (Line line : ladder.getLines()) {
            Direction direction = Direction.valueOf(line.isLine(position), line.isNextLine(position));
            position += direction.getMovePosition();
        }
        return position;
    }
}
