package laddergame.ui;

import laddergame.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class InputView {
    private  static final String INPUT_DELIMITER = ",";
    private static final String PLAYER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GAME_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_PLAYER_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Player> getPlayerFromUser(){
        String playerInput = getPlayerInput();
        String[] playerNames = split(playerInput);
        return getPlayers(playerNames);
    }

    private String getPlayerInput() {
        System.out.println(PLAYER_INPUT_MESSAGE);
        String players = SCANNER.nextLine();

        if(players.isBlank()){
            throw new IllegalArgumentException("사다리 게임에 참여할 사람 이름을 입력해주세요");
        }
        return players;
    }

    private List<Player> getPlayers(String[] playerNames) {
        return IntStream.range(0, playerNames.length)
                .mapToObj(index -> new Player(playerNames[index], index))
                .collect(toList());
    }

    private String[] split(String joiningTest){
        return joiningTest.replace(" ", "").split(INPUT_DELIMITER);
    }

    public List<String> getGameResultsFromUser(int playerCount){
        String gameResult = getGameResultInput();
        return getGameResults(gameResult, playerCount);
    }

    private String getGameResultInput() {
        System.out.println(GAME_RESULT_INPUT_MESSAGE);
        String gameResult = SCANNER.nextLine();

        if(gameResult.isBlank()){
            throw new IllegalArgumentException("게임 결과를 입력해주세요");
        }
        return gameResult;
    }

    private List<String> getGameResults(String gameResult, int playerCount) {
        List<String> gameResults = Arrays.stream(split(gameResult))
                .collect(toList());

        if(gameResults.size() != playerCount){
            throw new IllegalArgumentException("플레이어의 수만큼 게임 결과를 입력하세요");
        }
        return gameResults;
    }

    public int getMaxLadderHeightFromUser(){
        System.out.println(MAX_LADDER_HEIGHT_INPUT_MESSAGE);
        int maxheight = SCANNER.nextInt();
        SCANNER.nextLine(); //nextInt() 사용으로 인한 개행 문자 제거
        return maxheight;
    }

    public String getResultPlayerFromUser(){
        System.out.println();
        System.out.println(RESULT_PLAYER_INPUT_MESSAGE);
        String playerName = SCANNER.nextLine();

        if(playerName.isBlank()){
            throw new IllegalArgumentException("결과를 보고 싶은 사람의 이름을 입력하세요");
        }
        return playerName;
    }
}
