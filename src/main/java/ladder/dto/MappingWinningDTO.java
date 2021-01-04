package ladder.dto;

public class MappingWinningDTO {

    private String name;
    private String winning;

    public MappingWinningDTO(String name, String winning) {
        this.name = name;
        this.winning = winning;
    }

    public String getName() {
        return name;
    }

    public String getWinning() {
        return winning;
    }
}
