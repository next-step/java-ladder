package seungjun.ladder;


import ladder.*;

import java.util.List;

/**
 * 참여자 이름, 사다리 구조, 실행 결과로 이루어진 사다리 게임을 표현합니다.
 * 불변 객체입니다.
 */
public class SeungjunLadderGame implements LadderGame {
    private final List<LadderParticipant> names;
    private final LadderBody ladder;
    private final List<LadderResultItem> resultItems;

    public SeungjunLadderGame(List<LadderParticipant> names, LadderBody ladder, List<LadderResultItem> resultItems) {
        this.names = names;
        this.resultItems = resultItems;
        this.ladder = ladder;
    }

    @Override
    public LadderResult calculateResultOf(LadderParticipant who) {
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
    @Override
    public LadderResultSet calculateResultsOfAll() {
        LadderResultSet resultSet = new LadderResultSet();

       this.names.stream()
               .map(this::calculateResultOf)
               .forEach(resultSet::addResultMapping);

       return resultSet;
    }

    @Override
    public LadderBody ladderBody() {
        return this.ladder;
    }

    @Override
    public List<LadderResultItem> resultItems() {
        return List.copyOf(this.resultItems);
    }

    @Override
    public List<LadderParticipant> participants() {
        return List.copyOf(this.names);
    }
}