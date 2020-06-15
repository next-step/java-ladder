package nextstep.ladder.domain;

public class LadderGameManager {

    public static LineGenerator lineGenerator() {
        return new LineGenerator(randomMountingGenerator());
    }

    public static MountingBlockGenerator randomMountingGenerator() {
        return new RandomMountingBlockGenerator();
    }
}
