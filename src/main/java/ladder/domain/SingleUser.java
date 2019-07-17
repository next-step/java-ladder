package ladder.domain;

import java.util.List;

public class SingleUser {
    private final static int COUNT_OF_MAXIMUM_INPUT = 5;

    private final String name;
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

    void playLadderGame(List<LadderLine> ladder) {
        for (LadderLine line : ladder) {
            for (int i = 0; i < line.getPoints().size(); ++i) {
                if (line.getPoints().get(i).compareUserPosition(this.position)) {
                    updatePosition(line.move(i));
                    break;
                }
            }
        }
    }

    boolean matchPosition(int index) {
        return this.position.matchIndex(index);
    }

    private static String checkName(String input) {
        if (input.equals(LadderUtil.SEPARATOR_BLANK.getValue()) || input.equals(LadderUtil.SEPARATOR_BLANK2.getValue()) || input.equals(LadderUtil.SEPARATOR_ENTER.getValue()) || input.length() > COUNT_OF_MAXIMUM_INPUT) {
            throw new IllegalArgumentException("이름이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }
        return input;
    }

    private void updatePosition(int result) {
        this.position.updateIndex(result);
    }

    @Override
    public String toString() {
        return "SingleUser: " + "UserName: " + name + " " + position;
    }
}
