package ru.skypro;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> listofnumbers = new ArrayList<>(List.of(8, 9, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        oddNumbersFromList(listofnumbers);
        evenNumbersFromListWithoutDoubles(listofnumbers);
        String str = "Кто он такой? Кто он такой? Тайро - маленький автобус!";
        unicalWords(str);
        System.out.println("В строке: " + str + " " + numberOfDoubles(str) + " повторений");
        List<Integer> list = new ArrayList<>(List.of(8, 6, 2, 9, 2, 3, 4, 4, 4, 2, 6, 7));
        System.out.println("Усложнённое задание:");
        System.out.println(list);
        listChangeToNullAndOne(list);
        System.out.println("Проверяем на одни и теже буквы");
        System.out.println(compareWords("abbabdk", "bbaddaab"));
        System.out.println("Проверяем на онограмму");
        System.out.println(isOnogramma("cat", "act"));
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

    /*Методы усложненногт задания*/
    /*Можно сделать метод, который возвращает значения, но я сделал метод void,
     * чтобы он печатал и новый список и значение, для проверки*/
    public static void listChangeToNullAndOne(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i != list.lastIndexOf(list.get(i))) {
                for (int j = i; j < list.size(); j++) {
                    if (i != j && list.get(i).equals(list.get(j))) {
                        list.set(j, 0);
                    }
                }
                list.set(i, 0);
            } else {
                if (list.get(i) != 0) {
                    list.set(i, 1);
                }
            }
        }
        System.out.println(list);
        Integer sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println("Количество уникальных чисел в списке равно " + sum);
    }

    public static boolean compareWords(String s1, String s2) {
        Set<Character> set1 = new HashSet<>(listFromString(s1));
        Set<Character> set2 = new HashSet<>(listFromString(s2));
        if (set1.size() == set2.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOnogramma(String s1, String s2) {
        List<Character> list1 = listFromString(s1);
        List<Character> list2 = listFromString(s2);
        Set<Character> set = new HashSet<>(list1);
        int count1 = 0, count2 = 0;
        for (Character character : set) {
            for (int i = 0; i < list1.size(); i++) {
                if (character.equals(list1.get(i))) {
                    count1++;
                }
            }
        }
        for (Character character : set) {
            for (int i = 0; i < list2.size(); i++) {
                if (character.equals(list2.get(i))) {
                    count2++;
                }
            }
        }
        if (count1 == count2) {
            return true;
        } else {
            return false;
        }
    }

    /*Метод последних двух заданий, делающий из слова список Character*/
    public static List<Character> listFromString(String s) {
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Character.valueOf(arr[i]));
        }
        return list;
    }
}

