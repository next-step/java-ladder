package nextstep.ladder.domain.reward;

class RewardAmount implements RewardString {

    private static final int MINIMUM_AMOUNT = 0;
    private static final int MAXIMUM_AMOUNT = 9999;

    private final String amount;

    RewardAmount(String amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(String amount) {
        int intAmount = Integer.parseInt(amount);

        if (intAmount < MINIMUM_AMOUNT || intAmount > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("10000원 미만의 보상만 허용됩니다.");
        }
    }

    @Override
    public String export() {
        return amount;
    }

}
