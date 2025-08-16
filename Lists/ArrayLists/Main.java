package ArrayLists;

import java.util.ArrayList;

public class Main {
       public static void main(String[] args) {
              ArrayList<Integer> primeNumbers = new ArrayList<>();
              primeNumbers.add(2);
              primeNumbers.add(3);
              primeNumbers.add(5);
              System.out.println("ArrayList: " + primeNumbers);

              ArrayList<String> languages = new ArrayList<>();
              languages.add("Java");
              languages.add("Python");
              languages.add("JavaScript");
              System.out.println("ArrayList: " + languages);
              languages.add(1, "C++");
              System.out.println("ArrayList: " + languages);

              System.out.println("Length of ArrayList: " + languages.size());

              String replaced = languages.set(3, "Go");
              System.out.println("Updated ArrayList: " + languages);
              System.out.println("Replaced Element: " + replaced);

              boolean result = languages.remove("Java");
              System.out.println("Is element Java removed? " + result);
              System.out.println("ArrayList after remove(): " + languages);

              String removed = languages.remove(2);
              System.out.println("ArrayList after remove(): " + languages);
              System.out.println("Removed Element: " + removed);

              System.out.println("ArrayList: " + primeNumbers);
              primeNumbers.remove(2);
              System.out.println("ArrayList after remove(): " + primeNumbers);

              primeNumbers.remove((Integer) 2);
              System.out.println("ArrayList after remove(): " + primeNumbers);

              System.out.println("ArrayList: " + languages);
              String element = languages.get(1);
              System.out.println("Element at index 1: " + element);

              ArrayList<Integer> numbers = new ArrayList<>();
              numbers.add(22);
              numbers.add(13);
              numbers.add(35);
              System.out.println("Number ArrayList: " + numbers);
              int number = numbers.get(2);
              System.out.println("Number at index 2: " + number);

              int pos1 = numbers.indexOf(13);
              System.out.println("Index of 13: " + pos1);
              int pos2 = numbers.indexOf(50);
              System.out.println("Index of 50: " + pos2);

              languages.add(1, "Java");
              languages.add("Java");
              System.out.println("ArrayList: " + languages);
              int position = languages.indexOf("Java");
              System.out.println("First Occurence of Java: " + position);
       }
}
