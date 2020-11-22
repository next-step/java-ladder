package step4.domain.ladder.dto;

public class LadderResultDTO {
    private final String result;
    private final int position;

    public LadderResultDTO(String result, int position) {
        this.result = result;
        this.position = position;
    }

    public String getResult() {
        return result;
    }

}
