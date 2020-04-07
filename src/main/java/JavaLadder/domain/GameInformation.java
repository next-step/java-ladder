package JavaLadder.domain;

import java.util.ArrayList;

public class GameInformation {
    private Users users;
    private Prizes prizes;

    public GameInformation(String name, String prize) {
        this.users = new Users(name);
        this.prizes = new Prizes(prize);
        validateSize(users, prizes);
    }

    private void validateSize(Users users, Prizes prizes) {
        if(users.size() != prizes.size()){
            throw new IllegalArgumentException("사용자수[" +users.size() + "]와 상품수[" +prizes.size() +"]가 동일해야합니다.");
        }
    }

    public Users getUser() {
        return users;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
