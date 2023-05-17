package step2.domain;

public class RandomBridgeBuildStrategy implements  BridgeBuildStrategy {

    @Override
    public boolean canBuild() {
        return Math.random() < 0.5;
    }
}
