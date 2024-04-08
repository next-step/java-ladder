package ladder.domain;

import ladder.domain.factory.RowFactory;
import ladder.domain.vo.Rows;
import ladder.util.BooleanGenerator;
import ladder.util.RandomBooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_PLAYERS = 2;
    private static final int MIN_HEIGHT = 2;

    private final List<Rows> rowsList;

    public Ladder(Players players,
                  int height){
        this(createLadder(players, height));
    }

    public Ladder(List<Rows> rowsList) {
        this.rowsList = rowsList;
    }

    private static List<Rows> createLadder(Players players,
                                           int height){
        if (players.count() < MIN_PLAYERS){
            throw new IllegalArgumentException("사다리 생성에 필요한 참가자는 최소 2명 이상이어야 합니다.");
        }
        if (height < MIN_HEIGHT){
            throw new IllegalArgumentException("사다리 높이는 최소 2 이상이어야 합니다.");
        }

        RowFactory rowFactory = new RowFactory(new RandomBooleanGenerator());

        return IntStream.range(0, height)
                .mapToObj(i -> rowFactory.createRandom(players.count() - 1))
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