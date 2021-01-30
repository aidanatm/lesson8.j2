package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("человек", new String[]{"сапиенс", "индивид", "личность"});
        dictionary.put("телефон", new String[] {"сотка","аппарат", "смартфон"});
        dictionary.put("демон", new String[]{"нечесть", "черт", "сатана"});
        dictionary.put("красивый", new String[]{"милый","симпотичный","привлекательный"});

        HashMap<String, String[]> bigDictionary = new HashMap<>(dictionary);
        Set<String> keys = dictionary.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String oldKey = iterator.next();
            String[] oldValues = dictionary.get(oldKey);
            for (int i = 0; i < oldValues.length; i++) {
                String newKeys = oldValues[i];
                ArrayList<String> listOfValues = new ArrayList<>();
                Collections.addAll(listOfValues, oldValues);
                listOfValues.remove(newKeys);
                listOfValues.add(oldKey);
                String[] newValues = new String[listOfValues.size()];
                listOfValues.toArray(newValues);
                bigDictionary.put(newKeys, newValues);
            }
        }

        for (Map.Entry<String, String[]>item:bigDictionary.entrySet()) {
            System.out.println(item.getKey()+ "-"+ Arrays.toString(item.getValue()));

        }

        Scanner scanner = new Scanner(System.in);
        while (true){
        System.out.println("Введите слово:");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
            for (String word: words) {
                if (bigDictionary.get(word) != null) {
                    String[] synonyms = bigDictionary.get(word);
                    Random random = new Random();
                    int index = random.nextInt(synonyms.length);
                    System.out.print(synonyms[index]+ " ");
                }else {
                    System.out.println("Такого слова нет");
                }
            }
            System.out.println();
        }
    }


}
