package ladder.dto;


public class UserStatusDto {

    private final String name;
    private final String prize;

    public UserStatusDto(String name, String prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public String getPrize() {
        return prize;
    }
}