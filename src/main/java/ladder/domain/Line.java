package ladder.domain;

import ladder.enums.Numeric;

public class Line {

    private static final RandomNumber randomNumber = new RandomNumber();
    private static int maxCountOfLadder;
    private StringBuilder sb = new StringBuilder();
    private int countOfPerson;
    private int totalLineSize;
    private boolean[] points;

    public Line(int countOfPerson, boolean[] points) {
        this(countOfPerson);
        this.points = points;
    }

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        maxCountOfLadder = countOfPerson * Numeric.TWO.number() - Numeric.ONE.number();
        totalLineSize = this.countOfPerson * Numeric.TWO.number() - Numeric.ONE.number();
        points = new boolean[countOfPerson];
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
        if (position < Numeric.ZERO.number() || position > totalLineSize) {
            throw new IllegalArgumentException("잘못된 위치를 입력했습니다.");
        }
        return this.points[position];
    }

    public int findRoute(int startPosition) {
        int movablePosition = startPosition;

        if (isNotUnderFlow(startPosition) && isInstalledLadder(startPosition - Numeric.ONE.number())) {
            movablePosition = moveLeft(movablePosition);
        }
        if (isNotOverFlow(startPosition) && isInstalledLadder(startPosition + Numeric.ONE.number())) {
            movablePosition = moveRight(movablePosition);
        }
        return movablePosition;
    }

    public void addWidthLine(int position) {
        if (isEvenNumber(position)) {
            throw new IllegalArgumentException("이 위치에 세로 사다리를 설치할 수 없습니다.");
        }

        if (!checkAdjacentWidthLine(position)) {
            points[position] = true;
        }
    }

    private boolean isNotUnderFlow(int startPosition) {
        return startPosition - Numeric.ONE.number() >= Numeric.ZERO.number();
    }

    private boolean isNotOverFlow(int startPosition) {
        return startPosition + Numeric.ONE.number() <= maxCountOfLadder;
    }

    public void addHeightLine(int position) {
        if (!isEvenNumber(position)) {
            throw new IllegalArgumentException("이 위치에 가로 사다리를 설치할 수 없습니다.");
        }
        points[position] = true;
    }

    private int moveLeft(int movablePosition) {
        while (isInstalledLadder(movablePosition - Numeric.ONE.number())) {
            movablePosition--;
        }
        return movablePosition;
    }

    private int moveRight(int movablePosition) {
        while (isInstalledLadder(movablePosition + Numeric.ONE.number())) {
            movablePosition++;
        }
        return movablePosition;
    }

    private boolean isInstalledLadder(int position) {
        if (position < Numeric.ZERO.number() || position > maxCountOfLadder - Numeric.ONE.number()) {
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
        return position % Numeric.TWO.number() == Numeric.ZERO.number();
    }

    private boolean checkAdjacentWidthLine(int position) {
        if (position == Numeric.ONE.number()) {
            return false;
        }
        return this.points[position - Numeric.TWO.number()];
    }

    private boolean isInstallWidthLadder() {
        int number = randomNumber.randomNumber();
        return number > Numeric.FIVE.number();
    }
}
