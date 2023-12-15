package menu.util.validator;

public class CoachValidator {
    public static void validate(String[] input) {
        validateCoachNumber(input.length);

        for (String name : input) {
            validateName(name);
        }
    }

    public static void validateCoachNumber(int number) {
        if (number <= 1) {
            throw new IllegalArgumentException("[ERROR] 2명 이상의 코치를 입력해주세요.");
        }
    }
    public static void validateName(String name) {
        int length = name.length();
        if (length < 2 || length > 4) {
            throw new IllegalArgumentException("[ERROR] " + name + ": 코치 이름이 2글자에서 4글자가 아닙니다. 다시 입력해주세요.");
        }
    }
}
