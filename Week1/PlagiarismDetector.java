import java.util.*;

class PlagiarismDetector {

    HashMap<String, Set<String>> index = new HashMap<>();

    List<String> generateNgrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder gram = new StringBuilder();

            for (int j = 0; j < n; j++)
                gram.append(words[i + j]).append(" ");

            grams.add(gram.toString().trim());
        }

        return grams;
    }

    void indexDocument(String docId, String text) {

        List<String> grams = generateNgrams(text, 3);

        for (String gram : grams) {

            index.putIfAbsent(gram, new HashSet<>());

            index.get(gram).add(docId);
        }
    }

    public static void main(String[] args) {

        PlagiarismDetector p = new PlagiarismDetector();

        p.indexDocument("essay1", "this is plagiarism detection system");
        p.indexDocument("essay2", "this is plagiarism checking tool");

        System.out.println(p.index.size());
    }
}
