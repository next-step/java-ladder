package ladder.service;

import ladder.util.StringParseUtil;
import ladder.view.InputMessages;

import java.util.Arrays;

public class LadderGame {
    private static final String COMMA =",";

    private String[] players;

    private int height;

    public LadderGame() {

    }

    public void setPlayer(String names) {
        this.players = lengthValidate(StringParseUtil.splitString(names,COMMA));
    }

    public void setHeight(String height) {
        this.height = StringParseUtil.parseToInt(height);
    }

    private String[] lengthValidate(String[] names) {
        if(Arrays.stream(names).anyMatch( name -> name.length() > 5))
            throw new IllegalArgumentException("사람에 이름을 최대5글자까지 부여할 수 있습니다");
        return names;
    }


    public int getHeight() {
        return this.height;
    }

    public String[] getPlayers() {
        return players;
    }
}
