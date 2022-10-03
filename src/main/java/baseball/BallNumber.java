package baseball;

public class BallNumber {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    private int num;

    public BallNumber(int num) {
        if (num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
