package JavaLadder.domain;

public class GameInformation {
    private Users users;
    private Prizes prizes;

    public GameInformation(String inputName, String prize) {
        this.users = new Users(inputName);
        this.prizes = new Prizes(prize);
        validateSize(users, prizes);
    }

    public void validateSize(Users users, Prizes prizes) {
        if (users.size() != prizes.size()) {
            throw new IllegalArgumentException("사람입력 수(" + users.size() + ")와 실행결과입력 수(" + prizes.size() + ")같아야합니다.");
        }
    }

    public Users getUsers() {
        return users;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
