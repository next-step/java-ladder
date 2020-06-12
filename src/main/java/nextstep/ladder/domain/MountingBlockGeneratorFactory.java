package nextstep.ladder.domain;

public class MountingBlockGeneratorFactory {

    public MountingBlockGenerator randomMountingBlockGenerator() {
        return new RandomMountingBlockGenerator();
    }
}
