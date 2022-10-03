package baseball.validator;

public class InputFinishValidator {

    int restart;
    int finish;
    int size;
    String regx;

    public InputFinishValidator(int restart, int finish, int size) {
        this.restart = restart;
        this.finish = finish;
        this.size = size;
        this.regx = "[" + restart + "-" + finish + "]+";
    }

    public boolean isInputValidate(String checkString) {

        if (isOutOfSize(checkString)) {
            throw new IllegalArgumentException();
        }

        if (isNotNumber(checkString)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    private boolean isNotNumber(String checkString) {
        return !checkString.matches(regx);
    }

    private boolean isOutOfSize(String checkString) {
        return checkString.length() != size;
    }

}
