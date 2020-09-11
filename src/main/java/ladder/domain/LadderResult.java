package ladder.domain;

import ladder.domain.line.Line;
import ladder.util.InputUtil;
import ladder.view.PrintResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private List<String> gameReult;
    private LadderGame ladderGame;

    public LadderResult(List<String> gameReult, LadderGame ladderGame) {

        this.gameReult = gameReult;
        this.ladderGame = ladderGame;
    }

    public static void validationCheck(List<String> gameReult, LadderGame ladderGame) {
        if(ladderGame.getPeople().size() != gameReult.size()) {
            throw new IllegalArgumentException("실행결과는 참여할 사람수와 같게 입력해주세요.");
        }
    }

    public String getPersonResult(String personResult) {
        int location = getPersonLocation(personResult);
        return getResultByLocation(location);
    }

    private String getResultByLocation(int location) {
        int currentlocation = location;
        int size = ladderGame.getLadder().getLines().size();
        for (int i = 0; i < size; i++) {
            currentlocation = getCurrentLocation(currentlocation, i);
        }
        return gameReult.get(currentlocation);
    }

    private int getCurrentLocation(int widthLocation, int heigthLocation) {
        Line line = ladderGame.getLadder().getLines().get(heigthLocation);
        if (line.getPoints().get(widthLocation).isNextPoint()) {
            return widthLocation + 1;
        }
        if (line.getPoints().get(widthLocation).isPrevPoint()) {
            return widthLocation - 1;
        }
        return widthLocation;
    }

    public int getPersonLocation(String personResult) {
        GamePerson gamePerson = new GamePerson(personResult);
        validationName(gamePerson);
        return ladderGame.getPeople().indexOf(gamePerson);
    }

    private void validationName(GamePerson gamePerson) {
        ladderGame.getPeople().stream()
                .filter(person -> person.equals(gamePerson))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 사람은 게임에 존재하지 않습니다."));
    }

    public LadderGame getLadderGame() {
        return ladderGame;
    }

    public List<String> getGameReult() {
        return Collections.unmodifiableList(gameReult);
    }
}
