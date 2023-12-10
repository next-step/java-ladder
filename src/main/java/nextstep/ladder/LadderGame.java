package nextstep.ladder;

public class LadderGame {


    public Ladder makeLadder(Users users, int height) {
        return new Ladder(users.size() ,height);
    }

    public Users registerUser(String[] users) {
        return new Users(users);
    }



}
