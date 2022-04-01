package ru.skypro;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> listofnumbers = new ArrayList<>(List.of(8, 9, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        oddNumbersFromList(listofnumbers);
        evenNumbersFromListWithoutDoubles(listofnumbers);
        String str = "Кто он такой? Кто он такой? Тайро - маленький автобус!";
        unicalWords(str);
        System.out.println("В строке: " + str + " " + numberOfDoubles(str) + " повторений");
    }

    public static void oddNumbersFromList(List<Integer> list) {
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    public static void evenNumbersFromListWithoutDoubles(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        List<Integer> newlist = new ArrayList<>(set);
        Collections.sort(newlist);
        for (Integer integer : newlist) {
            if (integer % 2 != 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    public static void unicalWords(String s) {
        String[] words = strToWords(s);
        Set<String> setofwords = new HashSet<>(Arrays.asList(words));
        if (setofwords.contains("")) {
            setofwords.remove("");
        }
        System.out.println(setofwords);

    }

    /*Это довольно длинный и кривой метод. По большому счёту, тут можно и без списков обойтись.
     * Но мне хотелось попробовать как можно больше функционала*/
    public static int numberOfDoubles(String s) {
        String[] words = strToWords(s);
        List<String> listOfWords = new ArrayList<>(Arrays.asList(words));
        /*На случай, если в тексте было тире*/
        if (listOfWords.contains("")) {
            listOfWords.remove("");
        }
        /*Проверяем количество дублирующихся слов*/
        int countOfDoubles = 0;
        for (int i = 0; i < listOfWords.size() - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < listOfWords.size() - 1; j++) {
                if (listOfWords.get(i).equals(listOfWords.get(j))) {
                    count++;
                    break;
                }
            }
            countOfDoubles += count;
        }
        /*С помощью разницы в длинах списка и сета выясняем количество повторений и прибавляем количество
         * самих дублирующихся слов*/
        Set<String> setofwords = new HashSet<>(listOfWords);
        return countOfDoubles + listOfWords.size() - setofwords.size();
    }

    /*Метод перевода строки в массив слов с удалением знаков препинаний. Тире удаляем совсем*/
    public static String[] strToWords(String s) {
        String s1 = s.toLowerCase(Locale.ROOT);
        String[] words = s1.split(" ");
        String[] words1 = s1.split(" ");
        for (int i = 0; i < words.length; i++) {
            words1[i] = words[i].replace("?", "").replace(".", "").
                    replace("!", "").replace(":", "").
                    replace(";", "").replace(",", "").replace("-", "");
        }
        return words1;
    }
}
