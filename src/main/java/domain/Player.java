package domain;

import utils.StringUtils;

public class Player {
    private static final int NAME_LENGTH_LIMIT = 5;
    private String playerName;

    public Player(String playerName) {
        if(playerName.length() > NAME_LENGTH_LIMIT){
            throw new RuntimeException("글자수를 초과했습니다.");
        }
        this.playerName = playerName;
    }

    public boolean isPlayerName(String playerName) {
        return this.playerName.equals(playerName);
    }

    @Override
    public String toString() {
        String str =  StringUtils.getReplace(StringUtils.SPACE, NAME_LENGTH_LIMIT + 1);
        StringBuilder sb = new StringBuilder(str);
        sb.replace(0,playerName.length(),playerName);
        return sb.toString();
    }
}
