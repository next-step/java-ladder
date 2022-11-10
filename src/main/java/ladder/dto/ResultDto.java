package ladder.dto;

public class ResultDto {
    private final String member;
    private final String result;

    public ResultDto(String member, String result) {
        this.member = member;
        this.result = result;
    }

    public String memberName() {
        return member;
    }

    public String result() {
        return result;
    }
}
