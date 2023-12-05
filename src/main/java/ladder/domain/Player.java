package ladder.domain;

public class Player {

    private static final String MAX_PLAYER_DIGITS = "이름은 최대 5글자까지 입력 가능합니다.";
    private static final int PLAYER_DIGITS_SIZE = 5;

    private String player;

    public Player(String player){
        memberLengthValidation(player);
        this.player = player;
    }

    private void memberLengthValidation(String player){
        if(player.length() > PLAYER_DIGITS_SIZE){
            throw new IllegalArgumentException(MAX_PLAYER_DIGITS);
        }
    }

    public String getPlayer(){
        return player;
    }

}
