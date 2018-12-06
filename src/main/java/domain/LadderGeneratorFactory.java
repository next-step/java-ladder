package domain;

import domain.generator.LadderGenerator;
import domain.generator.LevelLadderGenerator;
import domain.level.HeightLevel;
import domain.level.PointLevel;

public class LadderGeneratorFactory {

    private static final String INPUT_EASY = "하";
    private static final String INPUT_NORMAL = "중";
    private static final String INPUT_HARD = "상";

    public static LadderGenerator create(String level) {
        HeightLevel heightLevel;
        PointLevel pointLevel;

        if (INPUT_EASY.equals(level)) {
            heightLevel = HeightLevel.EASY;
            pointLevel = PointLevel.EASY;
        } else if (INPUT_NORMAL.equals(level)) {
            heightLevel = HeightLevel.NORMAL;
            pointLevel = PointLevel.NORMAL;
        } else if (INPUT_HARD.equals(level)) {
            heightLevel = HeightLevel.HARD;
            pointLevel = PointLevel.HARD;
        } else {
            throw new IllegalArgumentException("상, 중, 하 중 입력해야한다.");
        }

        return new LevelLadderGenerator(heightLevel, pointLevel);
    }
}
