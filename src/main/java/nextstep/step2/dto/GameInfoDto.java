package nextstep.step2.dto;

public class GameInfoDto {

    private final String names;
    private final String gifts;

    private GameInfoDto(String names, String gifts) {
        this.names = names;
        this.gifts = gifts;
    }

    public static GameInfoDto of(String namesString, String giftsString) {
        return new GameInfoDto(namesString, giftsString);
    }

    public String getNames() {
        return names;
    }

    public String getGifts() {
        return gifts;
    }
}
