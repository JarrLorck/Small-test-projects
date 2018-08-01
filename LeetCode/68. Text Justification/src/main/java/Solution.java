import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> solution = new ArrayList<>();
        List<List<String>> rows = makeRows(words, maxWidth);
        //adjust rows
        for (List<String> line: rows) {
            List<String> adjustedWords = new ArrayList<>(line.size());
            int lineLength = calculateLength(line);
            int spacesToAddForRow = lineLength >  0 ? maxWidth % lineLength : maxWidth;
            int numberOfGaps = line.size() - 1;
            int spacesToAddForEachWord = numberOfGaps > 0 ? spacesToAddForRow / numberOfGaps : 0;
            int spacesToAddAfterFirstWord = spacesToAddForRow - numberOfGaps * spacesToAddForEachWord;
            StringBuilder first = new StringBuilder();
            if (!line.isEmpty()) {
                first.append(line.get(0));
            }
            addSpaces(first, spacesToAddForEachWord);
            addSpaces(first, spacesToAddAfterFirstWord);
            adjustedWords.add(first.toString());
            for (int i = 1; i < line.size(); i++ ) {
                String word = line.get(i);
                StringBuilder b = new StringBuilder(word.length() + spacesToAddForEachWord);
                b.append(word);
                if (i < line.size() - 1) {
                    addSpaces(b, spacesToAddForEachWord);
                }
                adjustedWords.add(b.toString());
            }


            solution.add(adjustedWords.stream().collect(Collectors.joining()));
        }

        return solution;
    }

    private int calculateLength(List<String> line) {
        return line.stream().mapToInt(String::length).sum();
    }

    private void addSpaces(StringBuilder b, int count) {
        for (int i = 0; i < count; i++) {
            b.append(" ");
        }
    }

    private List<List<String>> makeRows(String[] words, int maxWidth) {
        List<List<String>> rows = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int currentLength = 0;
        for (String word : words) {
            int l = word.length();
            if (l == 0) {
                continue;
            }
            String s = row.isEmpty() ? "" : " ";
            if (currentLength + l + s.length() > maxWidth) {
                rows.add(row);
                row = new ArrayList<>();
                currentLength = l;
                row.add(word);
            } else {
                row.add(s + word);
                currentLength += l + s.length();
            }
        }
        rows.add(row);
        return rows;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = new String[]{"This", "is", "an", "a", "example", "of", "ext", "justification."};
        String[] words = new String[]{""};
//        int maxWidth = 16;
        int maxWidth = 0;
        StringBuilder star = new StringBuilder(maxWidth);
        for (int i = 0; i < maxWidth; i++) {
            star.append("*");
        }
        System.out.println(star.toString());
        List<String> x = s.fullJustify(words, maxWidth);
        for (String lint : x) {
            System.out.print(lint);
            System.out.println("*");
        }
    }
}