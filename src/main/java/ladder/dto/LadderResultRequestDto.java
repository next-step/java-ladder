package ladder.dto;

public class LadderResultRequestDto {
    private String resultUsername;

    public LadderResultRequestDto(String resultUsername) {
        this.resultUsername = resultUsername;
    }

    public static LadderResultRequestDto of(String resultUsername) {
        return new LadderResultRequestDto(resultUsername);
    }

    public String getResultUsername() {
        return resultUsername;
    }
}
