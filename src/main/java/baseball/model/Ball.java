package baseball.model;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber ballNum;

    public Ball(int position, int ballNum) {
        this.position = position;
        this.ballNum = new BallNumber(ballNum);
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.isEqualBallNum(ballNum)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isEqualBallNum(BallNumber ballNum) {
        return this.ballNum.equals(ballNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(ballNum, ball.ballNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNum);
    }
}
