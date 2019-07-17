package ladder.domain;

import java.util.List;

public class SingleUser {
    private String name;
    private Position position;

    private SingleUser(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static SingleUser init(String name, int firstPos) {
        String userName = checkName(name);
        Position position = new Position(firstPos);
        return new SingleUser(userName, position);
    }

    public String getName() {
        return name;
    }

    Position getPosition() {
        return position;
    }

    void playLadderGame(List<LadderLine> ladder) {
        for (LadderLine line : ladder) {
            for (int i = 0; i < line.getPoints().size(); ++i) {
                if (line.getPoints().get(i).compareUserPosition(getPosition())) {
                    getPosition().updatePosition(line.move(i));
                    break;
                }
            }
        }
    }

    private static String checkName(String input) {
        if (input.equals("") || input.equals(" ") || input.equals("\n") || input.length() > 5) {
            throw new IllegalArgumentException("이름이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }
        return input;
    }

    @Override
    public String toString() {
        return "SingleUser: " + "UserName: " + getName() + " " + getPosition();
    }
}
