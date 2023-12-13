package ladderWithInterface.engin;

public interface LadderCreator {
    Ladder create(int countOfPosition, int height, CoordinateGenerator coordinateGeneration);
}
