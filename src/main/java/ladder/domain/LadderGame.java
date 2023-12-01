package ladder.domain;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 참여자 이름, 사다리 구조, 실행 결과로 이루어진 사다리 게임을 표현합니다.
 * 불변 객체입니다.
 */
public class LadderGame {
    private final List<Name> names;
    private final Ladder ladder;
    private final List<ResultItem> resultItems;

    public LadderGame(List<Name> names, Ladder ladder, List<ResultItem> resultItems) {
        this.names = names;
        this.resultItems = resultItems;
        this.ladder = ladder;
    }

    /**
     * 주어진 이름의 사다리 실행 결과를 계산하여 반환합니다.
     *
     * @param who 실행 결과를 볼 사람의 이름
     * @return 그 사람의 실행 결과
     */
    public LadderResult calculateResultOf(Name who) {
        int namePosition = this.names.indexOf(who);

        int resultPosition = this.ladder.calculateResultOf(namePosition);

        return new LadderResult(
                who,
                this.resultItems.get(resultPosition)
        );
    }

    /**
     * 주어진 이름의 사다리 실행 결과를 계산하여 반환합니다.
     * 모든 사람에 대하여 결과를 계산합니다.
     *
     * @return 실행 결과
     */
    public LadderResultSet calculateResultsOfAll() {
        LadderResultSet resultSet = new LadderResultSet();

       this.names.stream()
               .map(this::calculateResultOf)
               .forEach(resultSet::addResultMapping);

       return resultSet;
    }

    public Ladder ladderBody() {
        return this.ladder;
    }

    public List<ResultItem> results() {
        return List.copyOf(this.resultItems);
    }

    public List<Name> names() {
        return List.copyOf(this.names);
    }
}