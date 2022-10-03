package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        if (isNotValidSize(answers)) {
            throw new IllegalArgumentException();
        }

        balls = mapToBall(answers);
    }

    public Balls(String answers) {
        if (isNotValidSize(answers)) {
            throw new IllegalArgumentException();
        }

        if (isNotDigit(answers)) {
            throw new IllegalArgumentException();
        }

        balls = mapToBall(answers);
    }

    private List<Ball> mapToBall(String answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, Character.getNumericValue(answers.charAt(i))));
        }
        if (isDuplicateNumbers(balls)) {
            throw new IllegalArgumentException();
        }
        return balls;
    }

    private List<Ball> mapToBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        if (isDuplicateNumbers(balls)) {
            throw new IllegalArgumentException();
        }
        return balls;
    }

    private boolean isDuplicateNumbers(List<Ball> answers) {
        HashSet<BallNumber> result = new HashSet<>();
        for (Ball ball : answers) {
            result.add(ball.getBallNum());
        }
        return result.size() < 3;
    }

    private boolean isNotValidSize(List<Integer> answers) {
        return answers.isEmpty() || answers.size() > 3;
    }

    private boolean isNotDigit(String answers) {
        try {
            Integer.parseInt(answers);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isNotValidSize(String answers) {
        return answers.isEmpty() || answers.length() > 3;
    }

    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        for (Ball answer : balls) {
            BallStatus status = userBalls.play(answer);
            result.setResult(status);
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
        int count = 0;
        BallStatus result = BallStatus.NOTHING;
        while (count < 3 && result.isNothing()) {
            result = balls.get(count).play(userBall);
            count++;
        }
        return result;
    }
}
