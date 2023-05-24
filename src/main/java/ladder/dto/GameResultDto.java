package ladder.dto;

public class GameResultDto {
    private final String name;
    private final String result;

    public GameResultDto(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
