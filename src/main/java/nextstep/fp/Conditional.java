package nextstep.fp;

public interface Conditional {
    // 변경되는 부분
    private static int sum(int total, int number) {
        if(number > 3) {
            total += number;
        }
        return total;
    }
}
