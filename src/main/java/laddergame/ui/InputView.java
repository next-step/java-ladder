package laddergame.ui;

import laddergame.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private  static final String PLAYER_NAME_SEPERATOR = ",";
    private static final String PLAYER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Player> getPlayerFromUser(){
        System.out.println(PLAYER_INPUT_MESSAGE);
        String players = SCANNER.nextLine();

        if(players.isBlank()){
            throw new IllegalArgumentException("사다리 게임에 참여할 사람 이름을 입력해주세요");
        }

        return Arrays.stream(splitNames(players))
                .map(Player::new)
                .collect(toList());
    }

    private String[] splitNames(String playerNames){
        return playerNames.replace(" ", "").split(PLAYER_NAME_SEPERATOR);
    }

    public int getMaxLadderHeightFromUser(){
        System.out.println(MAX_LADDER_HEIGHT_INPUT_MESSAGE);
        return SCANNER.nextInt();
    }
}
