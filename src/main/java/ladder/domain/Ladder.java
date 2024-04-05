package ladder.domain;

import ladder.domain.factory.PlayerFactory;
import ladder.domain.vo.Rows;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Rows> rowsList;

    public Ladder(List<String> playersNames,
                  Integer height){
        this(create(PlayerFactory.create(playersNames), height));
    }

    public Ladder(Players players,
                  Integer height){
        this(create(players, height));
    }

    public Ladder(List<Rows> rowsList) {
        this.rowsList = rowsList;
    }

    private static List<Rows> create(Players players,
                                     Integer height){
        if (players.count() < 2)
            throw new IllegalArgumentException("사다리 생성에 필요한 참가자는 최소 2명 이상이어야 합니다.");
        if (height < 2)
            throw new IllegalArgumentException("사다리 높이는 최소 2 이상이어야 합니다.");
        return IntStream.range(0, height)
                .mapToObj(i -> new Rows(players.count() - 1))
                .collect(Collectors.toList());
    }

    public List<Rows> rowsList(){
        return Collections.unmodifiableList(rowsList);
    }

    public Integer height(){
        return rowsList.size();
    }

    public Integer width(){
        return rowsList().stream()
                .findFirst()
                .map(rows -> rows.rows().size())
                .orElseThrow(() -> new IllegalStateException("알 수 없는 오류 입니다."));
    }
}