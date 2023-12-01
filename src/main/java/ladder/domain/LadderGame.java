package ladder.domain;


import java.util.List;

/**
 * 참여자 이름, 사다리 구조, 실행 결과로 이루어진 사다리 게임을 표현합니다.
 * 불변 객체입니다.
 */
public class LadderGame {
    private final List<Name> names;
    private final Ladder ladder;
    private final List<Result> results;

    public LadderGame(List<Name> names, Ladder ladder, List<Result> results) {
        this.names = names;
        this.results = results;
        this.ladder = ladder;
    }

    /**
     * 주어진 이름의 사다리 실행 결과를 계산하여 반환합니다.
     *
     * @param who 실행 결과를 볼 사람의 이름
     *
     * @return 그 사람의 실행 결과
     */
    public Result calculateResultOf(Name who) {
        int namePosition = this.names.indexOf(who);

        int resultPosition = this.ladder.calculateResultOf(namePosition);

        return this.results.get(resultPosition);
    }
}