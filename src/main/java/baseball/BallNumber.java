package baseball;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    private final int num;

    public BallNumber(int num) {
        if (num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
