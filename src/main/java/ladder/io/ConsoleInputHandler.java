package ladder.io;


import ladder.domain.Players;
import ladder.domain.engine.Rewards;
import ladder.domain.impl.RewardsImpl;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = ",";

    @Override
    public Players createPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> namesOfPeopleFromUser = getNamesOfPlayersFromUser();
        return Players.of(namesOfPeopleFromUser);
    }

    private List<String> getNamesOfPlayersFromUser() {
        String[] namesOfPeople = SCANNER.nextLine().split(DEFAULT_DELIMITER);
        blankLine();
        return List.of(namesOfPeople);
    }

    @Override
    public Rewards createRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> playResultsFromUser = getPlayResultsFromUser();
        return RewardsImpl.of(playResultsFromUser);
    }

    private List<String> getPlayResultsFromUser() {
        String[] playResults = SCANNER.nextLine().split(DEFAULT_DELIMITER);
        blankLine();
        return List.of(playResults);
    }

    @Override
    public int getHeightOfLadderFromUser() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String heightOfLadder = SCANNER.nextLine();
        blankLine();
        return toInt(heightOfLadder);
    }

    private void blankLine() {
        System.out.println();
    }

    private int toInt(String heightOfLadder) {
        return Integer.parseInt(heightOfLadder);
    }

}
