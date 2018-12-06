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
        if (INPUT_EASY.equals(level)) {
            return new LevelLadderGenerator(HeightLevel.EASY, PointLevel.EASY);
        }

        if (INPUT_NORMAL.equals(level)) {
            return new LevelLadderGenerator(HeightLevel.NORMAL, PointLevel.NORMAL);
        }

        if (INPUT_HARD.equals(level)) {
            return new LevelLadderGenerator(HeightLevel.HARD, PointLevel.HARD);
        }

        throw new IllegalArgumentException("상, 중, 하 중 입력해야한다.");
    }
}
