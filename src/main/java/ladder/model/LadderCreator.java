package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator implements LadderFactory {
    private int size;
    private int height;

    public LadderCreator(int size, int height) {
        this.size = size;
        this.height = height;
    }

    @Override
    public List<Point> create() {
        List<Point> result = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            //행의 수 숫자를 뽑아야하는데 양쪽이 있으면 안됨.
            int index = i + 1;
            
            //Direction direction = new Direction();
        }

        return result;
    }
}
