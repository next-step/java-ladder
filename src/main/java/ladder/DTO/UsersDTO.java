package ladder.DTO;

import java.util.List;

public class UsersDTO {

    private final List<String> users;

    public UsersDTO(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }
}
