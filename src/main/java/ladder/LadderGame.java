package ladder;


public class LadderGame {
    private final LadderGenerator ladderGenerator;
    private Ladder ladder;

    public LadderGame(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public void init(int countOfPerson, int height) {
        this.ladder = ladderGenerator.generate(countOfPerson, height);
    }

    public GameResults play(Players players, EndPoints endPoints) {
        verifyGamePlay(players, endPoints);
        players.descendByOrder(ladder);
        return new GameResults(players, endPoints);
    }

    private void verifyGamePlay(Players players, EndPoints endPoints) {
        if (!players.isEqualCount(endPoints)) {
            throw new RuntimeException("사다리게임의 참여인원과 결과는 개수가 다를 수 없습니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }
}
