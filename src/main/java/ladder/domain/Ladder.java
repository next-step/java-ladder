package ladder.domain;

import ladder.domain.factory.RowFactory;
import ladder.domain.vo.Rows;
import ladder.util.RandomBooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_WIDTH = 1;
    private static final int MIN_HEIGHT = 2;

    private final List<Rows> rowsList;

    public Ladder(int width,
                  int height){
        this(createLadder(width, height));
    }

    public Ladder(List<Rows> rowsList) {
        this.rowsList = rowsList;
    }

    private static List<Rows> createLadder(int width,
                                           int height){
        if (width < MIN_WIDTH){
            throw new IllegalArgumentException("사다리 넓이는 최소 1 이상이어야 합니다.");
        }
        if (height < MIN_HEIGHT){
            throw new IllegalArgumentException("사다리 높이는 최소 2 이상이어야 합니다.");
        }

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