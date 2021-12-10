package ladder.strategy;

@FunctionalInterface
public interface MakeRungStrategy {

    boolean test();

    static MakeRungStrategy of(boolean isRungSet, boolean randomBoolean) {
        if (isRungSet) {
            return () -> false;
        }
        return () -> randomBoolean;
    }

}
