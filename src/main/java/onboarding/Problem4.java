package onboarding;

public class Problem4 {

    private enum CharValue {
        VALUE_UPPER_A('A'),
        VALUE_UPPER_Z('Z'),
        VALUE_LOWER_A('a'),
        VALUE_LOWER_Z('z');

        private final int value;

        CharValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public static String solution(String word) {
        String answer = "";

        for (char value : word.toCharArray()) {
            answer += getNewValue(value);
        }
        return answer;
    }

    private static char getNewValue(char value) {
        if(Character.isUpperCase(value)){
            return getNewUpperCaseValue(value);
        }if (Character.isLowerCase(value)) {
            return getNewLowerCaseValue(value);
        }
        return value;
    }

    private static char getNewLowerCaseValue(char value) {
        return (char) (CharValue.VALUE_LOWER_A.getValue() + CharValue.VALUE_LOWER_Z.getValue() - value);
    }

    private static char getNewUpperCaseValue(char value) {
        return (char) (CharValue.VALUE_UPPER_A.getValue() + CharValue.VALUE_UPPER_Z.getValue() - value);
    }
}
