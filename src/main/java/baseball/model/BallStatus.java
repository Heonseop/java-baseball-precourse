package baseball.model;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
