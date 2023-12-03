package nextstep.ladder.model;

public class Game {
    private final Ladder ladder;
    private final Results results;

    public Game(Ladder ladder, Results results) {
        validate(ladder, results);
        this.ladder = ladder;
        this.results = results;
    }

    private void validate(Ladder ladder, Results results) {
        if (results.resultSize() > ladder.peopleCount()) {
            throw new IllegalArgumentException("실행 결과 수는 총 사람수 보다 클 수 없습니다.");
        }
    }

}
