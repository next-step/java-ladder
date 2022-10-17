package laddergame.component;

import laddergame.domain.LadderLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLadderLineFactory implements LadderLineFactory {

    private static final int MIN_NUMBER_OF_COLUMNS = 1;
    private static final Random RANDOM = new Random();

    @Override
    public LadderLine createLadderLine(int numberOfColumns) {
        validate(numberOfColumns);

        List<Boolean> connections = createRandomConnections(numberOfColumns);
        return new LadderLine(connections);
    }

    private static void validate(int numberOfColumns) {
        if (numberOfColumns < MIN_NUMBER_OF_COLUMNS) {
            throw new IllegalArgumentException(String.format("세로 막대 개수는 최소 %d 개 이상이어야 합니다.", MIN_NUMBER_OF_COLUMNS));
        }
    }

    private List<Boolean> createRandomConnections(int numberOfColumns) {
        if (numberOfColumns == MIN_NUMBER_OF_COLUMNS) {
            return Collections.emptyList();
        }

        int sizeOfConnections = numberOfColumns - 1;
        List<Boolean> connections = new ArrayList<>();
        connections.add(RANDOM.nextBoolean());
        IntStream.range(1, sizeOfConnections)
                .forEach(i -> connections.add(createCollection(connections.get(i - 1))));
        return connections;
    }

    private boolean createCollection(boolean previousConnected) {
        if (previousConnected) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

}
