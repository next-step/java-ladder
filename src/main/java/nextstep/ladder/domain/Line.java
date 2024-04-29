package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line implements RandomBoolean{
    private List<Boolean> connection = new ArrayList<>();
    private Random random = new Random();
    private Location location;

    public Line(int size) {
        basicLine(size);
        IntStream.range(1, size)
                .filter(i -> !connection.get(i - 1))
                .forEach(i -> connection.set(i, isConnection()));
    }

    private void basicLine(int k) {
        for (int i = 0; i < k; i++) {
            connection.add(false);
        }
    }

    public List<Boolean> getList() {
        return connection;
    }

    @Override
    public boolean isConnection() {
        return random.nextBoolean();
    }
}
