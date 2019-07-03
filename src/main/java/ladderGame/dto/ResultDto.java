package ladderGame.dto;

public class ResultDto {

    private final String name;
    private final String content;

    private ResultDto(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public static ResultDto of(String name, String content) {
        return new ResultDto(name, content);
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
