package domain.generator;

import domain.level.HeightLevel;
import domain.Ladder;
import domain.level.PointLevel;

public class LevelLadderGenerator implements LadderGenerator {

    private final HeightLevel heightLevel;
    private final PointLevel pointLevel;

    public LevelLadderGenerator(HeightLevel heightLevel, PointLevel pointLevel) {
        this.heightLevel = heightLevel;
        this.pointLevel = pointLevel;
    }

    @Override
    public Ladder generate(int participantCount) {
        return Ladder.of(participantCount, heightLevel.value(), pointLevel.value());
    }
}
