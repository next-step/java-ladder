package ladder.domain;

public class Line {

    private static final RandomNumber randomNumber = new RandomNumber();
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int FIVE = 5;
    private static int maxCountOfLadder;
    private StringBuilder sb = new StringBuilder();
    private int countOfPerson;
    private int totalLineSize;
    private boolean[] points;

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        maxCountOfLadder = countOfPerson * TWO - ONE;
        totalLineSize = this.countOfPerson * TWO - ONE;
        points = new boolean[totalLineSize];
    }

    public void drawOneLine() {
        for (int i = 0; i < totalLineSize; i++) {
            drawLadder(i);
        }
    }

    public boolean[] points() {
        return this.points;
    }

    public boolean isDrawAtPosition(int position) {
        if (position < ZERO || position > totalLineSize) {
            throw new IllegalArgumentException("잘못된 위치를 입력했습니다.");
        }
        return this.points[position];
    }

    public int findRoute(int startPosition) {
        int movablePosition = startPosition;

        if (startPosition - ONE >= ZERO && isInstalledLadder(startPosition - ONE)) {
            movablePosition = moveLeft(movablePosition);
        }
        if (startPosition + ONE <= maxCountOfLadder && isInstalledLadder(startPosition + ONE)) {
            movablePosition = moveRight(movablePosition);
        }
        return movablePosition;
    }

    public void addWidthLine(int position) {
        if (isEvenNumber(position)) {
            throw new IllegalArgumentException("이 위치에 세로 사다리를 설치할 수 없습니다.");
        }

        if(!checkAdjacentWidthLine(position)){
            points[position] = true;
        }
    }

    public void addHeightLine(int position) {
        if (!isEvenNumber(position)) {
            throw new IllegalArgumentException("이 위치에 가로 사다리를 설치할 수 없습니다.");
        }
        points[position] = true;
    }

    private int moveLeft(int movablePosition) {
        while (isInstalledLadder(movablePosition - ONE)) {
            movablePosition--;
        }
        return movablePosition;
    }

    private int moveRight(int movablePosition) {
        while (isInstalledLadder(movablePosition + ONE)) {
            movablePosition++;
        }
        return movablePosition;
    }

    private boolean isInstalledLadder(int position) {
        if (position < 0 || position > maxCountOfLadder - ONE) {
            return false;
        }
        return this.points[position];
    }

    private void drawLadder(int position) {
        if (isEvenNumber(position)) {
            addHeightLine(position);
        }
        if (!isEvenNumber(position) && isInstallWidthLadder()) {
            addWidthLine(position);
        }
    }

    private boolean isEvenNumber(int position) {
        return position % TWO == ZERO;
    }

    private boolean checkAdjacentWidthLine(int position) {
        if(position == ONE){
            return false;
        }
        return this.points[position - TWO];
    }

    private boolean isInstallWidthLadder() {
        int number = randomNumber.randomNumber();
        return number > FIVE;
    }
}
