package ladder.dto;


public class UserStatusDto {

    private String name;
    private int position;

    public UserStatusDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
