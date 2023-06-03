package ladder.domain;

public class Prize {
    public static final String DELIMITER = ",";
    private final String[] descriptions;

    private Prize(String[] descriptions, int countOfPerson) {
        if (descriptions.length != countOfPerson) {
            throw new IllegalArgumentException("입력한 상품의 개수가 참여자 수와 맞지 않습니다.");
        }

        this.descriptions = descriptions;
    }

    public static Prize of(String prizes, int countOfPerson) {
        if (prizes == null || prizes.trim().isEmpty()) {
            throw new IllegalArgumentException("상품이 입력되지 않았습니다.");
        }

        return new Prize(prizes.split(DELIMITER), countOfPerson);
    }

    public String getPrize(int position) {
        if (position > descriptions.length) {
            throw new IndexOutOfBoundsException("입력된 수가 상품의 개수보다 큽니다.");
        }

        if (position < 0) {
            throw new IndexOutOfBoundsException("입력된 수는 0 이상이어야 합니다.");
        }

        return descriptions[position];
    }

    public String[] getDescriptions() {
        return this.descriptions;
    }
}
