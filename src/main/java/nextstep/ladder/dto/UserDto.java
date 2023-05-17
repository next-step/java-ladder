package nextstep.ladder.dto;

public class UserDto {
    private String name;
    private String result;

    public UserDto(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public UserDto(String name) {
        this(name, "");
    }

    public String getName() {
        return name;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }


}
