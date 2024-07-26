class Solution {
    public String solution(String s) {
        String[] words = s.split(" ");

        StringBuilder JadenCaseStringBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                JadenCaseStringBuilder.append(" ");
                continue;
            }

            char start = words[i].charAt(0);

            if ((start >= 'A' && start <= 'Z') || (start >= 'a' && start <= 'z')) {
                JadenCaseStringBuilder.append(words[i].substring(0, 1).toUpperCase());
                JadenCaseStringBuilder.append(words[i].substring(1).toLowerCase());
            } else {
                JadenCaseStringBuilder.append(words[i].toLowerCase());
            }

            if (i < words.length - 1) {
                JadenCaseStringBuilder.append(" ");
            }
        }

        // 입력받은 문자열의 맨 끝이 공백이면 공백을 추가해준다.
        if (s.endsWith(" ")) {
            JadenCaseStringBuilder.append(" ");
        }

        return JadenCaseStringBuilder.toString();
    }
}