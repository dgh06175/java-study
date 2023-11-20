package onboarding;

public class Problem4 {
    static String alpha = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            answer.append(getReverseChar(word.charAt(i)));
        }
        return answer.toString();
    }

    private static Character getReverseChar(Character w)
    {
        if (!Character.isAlphabetic(w)) return w;
        int reverseIndex = alpha.length() - 1 - alpha.indexOf(Character.toLowerCase(w));
        if (Character.isUpperCase(w)) return Character.toUpperCase(alpha.charAt(reverseIndex));
        return alpha.charAt(reverseIndex);
    }
}
