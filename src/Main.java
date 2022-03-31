import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args)  {

        System.out.println("Sorting tools program - sort numbers or strings");

        chooseType();
    }

    public static void chooseType() {

        System.out.println("Choose dataType ");
        System.out.println("1. Numbers");
        System.out.println("2. Words");
        System.out.println("3. Lines");

        Scanner scanner = new Scanner(System.in);
        int dataType = scanner.nextInt();
        switch (dataType) {
            case 1 -> {
                System.out.println("Choose type of sorting");
                System.out.println("1. Natural");
                System.out.println("2. Count");
                int sortTypeInt = scanner.nextInt();
                switch (sortTypeInt) {
                    case 1 -> sortIntegersNaturally();
                    case 2 -> sortIntegersByCount();
                    default -> System.out.println("Wrong number");
                }
            }
            case 2 -> {
                System.out.println("Choose type of sorting");
                System.out.println("1. Natural");
                System.out.println("2. Count");
                int sortTypeWords = scanner.nextInt();
                switch (sortTypeWords) {
                    case 1 -> sortWordsNaturally();
                    case 2 -> sortWordsByCount();
                    default -> System.out.println("Wrong number");
                }
            }
            case 3 -> {
                System.out.println("Choose type of sorting");
                System.out.println("1. Natural");
                System.out.println("2. Count");
                int sortTypeLines = scanner.nextInt();
                switch (sortTypeLines) {
                    case 1 -> sortLinesNaturally();
                    case 2 -> sortLinesByCount();
                    default -> System.out.println("Wrong number");
                }
            }
            default -> System.out.println("Wrong number");
        }
    }

    public static Map<Object, Integer> countMapObjects(List list) {

        Map<Object, Integer> map = new HashMap<>();

        for (Object i : list
        ) {
            if (map.containsKey(i)) {
                int newValue = map.get(i) + 1;
                map.put(i, newValue);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    public static void sortIntegersNaturally() {
        Scanner scanner = new Scanner(System.in);
        List<Long> longs = new ArrayList<>();

        while (scanner.hasNext()) {
            String number = scanner.next();

            try {
                longs.add(Long.parseLong(number));
            } catch (NumberFormatException e) {
                System.out.format("\"%s\" isn't a long. It's skipped.\n", number);
            }
        }

        List<Long> sortedLongs = longs.stream().sorted().collect(Collectors.toList());

        System.out.println("Total numbers: " + longs.size() + ".");
        System.out.format("Sorted data: ");
        sortedLongs.forEach(n -> System.out.print(n + " "));
    }

    public static void sortIntegersByCount() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> longs = new ArrayList<>();

        while (scanner.hasNext()) {
            String number = scanner.next();

            try {
                longs.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                System.out.format("\"%s\" isn't a long. It's skipped.\n", number);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : longs
        ) {
            if (map.containsKey(i)) {
                int newValue = map.get(i) + 1;
                map.put(i, newValue);
            } else {
                map.put(i, 1);

            }
        }

        System.out.println("Total numbers: " + longs.size() + ".");
        map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(x -> (int) x.getKey()))
                .sorted(Map.Entry.comparingByValue())
                .forEach(n ->
                        System.out.println(
                                n.getKey()
                                        + ": "
                                        + n.getValue()
                                        + " times(s), "
                                        + 100L * n.getValue() / (long) longs.size()
                                        + "%"));
    }

    public static void sortWordsByCount() {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.next();
            words.add(line);
        }

        Map<Object, Integer> stringMap = countMapObjects(words);

        System.out.println("Total numbers: " + words.size());
        stringMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> (String) x.getKey()))
                .sorted(Map.Entry.comparingByValue())
                .forEach(n ->
                        System.out.println(
                                n.getKey()
                                        + ": "
                                        + n.getValue()
                                        + " times(s), "
                                        + 100L * n.getValue() / (long) words.size()
                                        + "%"));

    }

    public static void sortWordsNaturally() {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.next();
            words.add(line);
        }

        System.out.println("Sorted data: ");
        words.stream().sorted().forEach(x -> System.out.print(x + " "));
    }

    public static void sortLinesNaturally() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        System.out.println("Sorted data: ");
        lines.stream().sorted().forEach(System.out::println);
    }

    public static void sortLinesByCount() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        Map<Object, Integer> stringMap = countMapObjects(lines);


        System.out.println("Total numbers: " + lines.size());
        stringMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> (String) x.getKey()))
                .sorted(Map.Entry.comparingByValue())
                .forEach(n ->
                        System.out.println(
                                n.getKey()
                                        + ": "
                                        + n.getValue()
                                        + " times(s), "
                                        + 100L * n.getValue() / (long) lines.size()
                                        + "%"));
    }

    public static void countLongs() {
        Scanner scanner = new Scanner(System.in);
        List<Long> longs = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            longs.add(number);
        }

        long greatestNumber = longs.stream().mapToLong(n -> n).max().orElseThrow(NoSuchElementException::new);
        long countOfGreatestNumber = longs.stream().filter(v -> v == greatestNumber).count();
        long percent = 100L * countOfGreatestNumber / (long) longs.size();

        System.out.println("Total numbers: " + longs.size() + ".");
        System.out.println("The greatest number: " + greatestNumber
                + " (" + countOfGreatestNumber + " times(s), " + percent + "%).");
    }

    public static void countLines() {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringList.add(line);
        }

        long numberOfLines = stringList.size();
        String longestLine = stringList.stream()
                .max(Comparator.comparingLong(String::length))
                .orElseThrow(NoSuchFieldError::new);

        long countOfLongestLines = stringList.stream().filter(longestLine::equals).count();
        long percent = 100L * countOfLongestLines / (long) stringList.size();

        System.out.println("Total lines: " + numberOfLines + ".");
        System.out.println("The longest line: \n" + longestLine);

        System.out.println(
                "(" + countOfLongestLines + " times(s), " + percent + "%).");
    }

    public static void countWords() {
        Scanner scanner = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.next();
            wordList.add(line);
        }

        long numberOfWords = wordList.size();
        String longestWord = wordList.stream()
                .max(Comparator.comparingLong(String::length))
                .orElseThrow(NoSuchFieldError::new);

        long countOfGreatestWord = wordList.stream().filter(v -> v.equals(longestWord)).count();
        long percent = 100L * countOfGreatestWord / (long) wordList.size();

        System.out.println("Total words: " + numberOfWords + ".");
        System.out.println("The longest word: " + longestWord
                + " (" + countOfGreatestWord + " times(s), " + percent + "%).");
    }
}