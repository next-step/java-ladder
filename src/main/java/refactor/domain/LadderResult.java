package refactor.domain;


import java.util.Collections;
import java.util.List;

public class LadderResult {
    private List<String> gameReult;
    private LadderGame ladderGame;

    public LadderResult(List<String> gameReult, LadderGame ladderGame) {
        validationCheck(gameReult, ladderGame);
        this.gameReult = gameReult;
        this.ladderGame = ladderGame;
    }

    public static void validationCheck(List<String> gameReult, LadderGame ladderGame) {
        if (ladderGame.getPeople().size() != gameReult.size()) {
            throw new IllegalArgumentException("실행결과는 참여할 사람수와 같게 입력해주세요.");
        }
    }

    public String getPersonResult(String personName) {
        List<LadderLine> ladderLines = ladderGame.getLadder().getLadderLines();
        int poistion = getPersonLocation(personName);
        for (int i = 0, length = ladderLines.size(); i < length; i++) {
            poistion = getIndexOfLadderLine(poistion, ladderLines.get(i));
        }
        return gameReult.get(poistion);
    }

    public int getPersonLocation(String personResult) {
        GamePerson gamePerson = GamePerson.valueOf(personResult);
        validationName(gamePerson);
        return ladderGame.getPeople().indexOf(gamePerson);
    }

    private void validationName(GamePerson gamePerson) {
        ladderGame.getPeople().stream()
                .filter(person -> person.equals(gamePerson))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 사람은 게임에 존재하지 않습니다."));
    }


    private int getIndexOfLadderLine(int position, LadderLine ladderLine) {
        return ladderLine.move(position);
    }

    public LadderGame getLadderGame() {
        return ladderGame;
    }

    public List<String> getGameReult() {
        return Collections.unmodifiableList(gameReult);
    }
}
