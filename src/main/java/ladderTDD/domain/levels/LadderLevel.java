package ladderTDD.domain.levels;

public abstract class LadderLevel {

    abstract public int getHeight();
    abstract public Boolean generateRandomValue();

    public static LadderLevel of(Level level) {
        if (level == Level.ADVANCED) {
            return new AdvancedLadderLevel();
        }
        if (level == Level.INTERMEDIATE) {
            return new IntermediateLadderLevel();
        }
        return new BasicLadderLevel();
    }
}
