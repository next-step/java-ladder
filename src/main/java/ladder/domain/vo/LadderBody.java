package ladder.domain.vo;

import ladder.domain.Players;
import ladder.domain.factory.RowFactory;
import ladder.util.RandomBooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBody {

    private static final int MIN_WIDTH = 1;
    private static final int MIN_HEIGHT = 2;
    private final List<Rows> rowsList;

    public LadderBody(int width, int height) {
        validateWidth(width);
        validateHeight(height);
        this.rowsList = createLadderBody(width, height);
    }

    public LadderBody(List<Rows> rowsList) {
        this.rowsList = rowsList;
    }

    private void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 너비는 최소 1 이상이어야 합니다.");
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 2 이상이어야 합니다.");
        }
    }

    private static List<Rows> createLadderBody(int width,
                                               int height){
        RowFactory rowFactory = new RowFactory(new RandomBooleanGenerator());

        return IntStream.range(0, height)
                .mapToObj(i -> rowFactory.createRandom(width))
                .collect(Collectors.toList());
    }

    public List<Rows> rowsList(){
        return Collections.unmodifiableList(rowsList);
    }

    public int height(){
        return rowsList.size();
    }

    public int width(){
        if (rowsList.isEmpty()) {
            throw new IllegalStateException("알 수 없는 오류 입니다.");
        }

        return rowsList.get(0).size();
    }
}