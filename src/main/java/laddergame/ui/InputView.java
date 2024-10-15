package laddergame.ui;

import java.util.Scanner;

public class InputView {
    private static final String PLAYER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getPlayerFromUser(){
        System.out.println(PLAYER_INPUT_MESSAGE);
        String players = SCANNER.nextLine();

        if(players.isBlank()){
            throw new IllegalArgumentException("사다리 게임에 참여할 사람 이름을 입력해주세요");
        }
        return players;
    }
}
