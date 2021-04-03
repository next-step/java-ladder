package nextstep.ladder.dto;

public class PlayerDto {

    private final NameDto nameDto;

    public PlayerDto(NameDto nameDto) {
        this.nameDto = nameDto;
    }

    public String getNameDto() {
        return nameDto.getName();
    }

}
