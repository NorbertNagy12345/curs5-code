import java.util.Scanner;

public class ConfidentialAppNorbert {
    public static void main(String[] args) {
        String randomString = "whoknowswhat";
        char randomCharacter = 'w';

        howManyTimes(randomString, randomCharacter);
        String stars = startConverter(randomString);
        System.out.println(stars);

        String[] threString = {"Ana", "are", "mere"};
        String oneString = "are";
        System.out.println(doesItContains(threString, oneString));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please introduce your phrase: ");
        String newString = scanner.nextLine();

        System.out.println("Please introduce the number of sensitive words");
        int sizeOfArr = scanner.nextInt();
        String[] sensitiveWords = arrCreator(sizeOfArr);


        String[] confidential = phraseCruncher(coder(sensitiveWords, newString));

        for (String s : confidential) System.out.print(s+" ");

    }


    private static String coder(String[] sensitiveWords, String newArr) {
        for (String sensitiveWord : sensitiveWords) {
            newArr = newArr.replaceAll(sensitiveWord, startConverter(sensitiveWord));
        }
        return newArr;
    }

    private static String[] arrCreator(int num) {
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please introduce your sensitive word one by one: ");
            arr[i] = scanner.next();
        }
        return arr;
    }


    private static String[] phraseCruncher(String newString) {
        return newString.split(" ");
    }

    private static Boolean doesItContains(String[] threString, String oneString) {
        for (String s : threString)
            if (s.equals(oneString)) {
                return true;
            }
        ;
        return false;
    }


    private static String startConverter(String randomString) {
        int length = randomString.length();
        return "*".repeat(length);
    }

    private static void howManyTimes(String randomString, char randomCharacter) {
        int counter = 0;
        for (int i = 0; i < randomString.length(); i++) {
            if (randomString.charAt(i) == randomCharacter) {
                counter++;
            }
        }
        System.out.println(counter);
    }


}
