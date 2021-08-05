package ladder.domain;

public class LadderGame {

    private Users users;
    private Lines lines;

    public LadderGame(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public Users start(){

        User newUser;
        for(User user : this.users.userList()){
            newUser = new User(user.name(),lines.calulateGameResult(user.position()));
        }


        return null;
    }

}
