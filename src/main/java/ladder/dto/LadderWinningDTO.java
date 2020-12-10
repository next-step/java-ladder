package ladder.dto;

public class LadderWinningDTO {

    private String name;
    private String result;

    public LadderWinningDTO(String name, String result) {
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
