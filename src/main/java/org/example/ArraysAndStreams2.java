package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)             
               .map(String::toUpperCase)   
               .collect(Collectors.toList()));

      // strings less than "n" (case insensitive) sorted ascending
      System.out.printf("strings less than n sorted ascending: %s%n",
         Arrays.stream(strings)                            
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .collect(Collectors.toList()));             

      // strings less than "n" (case insensitive) sorted descending
      System.out.printf("strings less than n sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .collect(Collectors.toList()));

      /**
       * ## 1. Filter strings that start with a vowel (case-insensitive)
       *
       * Uses a regular expression with `(?i)` to enable case‑insensitive matching.
       *
       * ### Stream Logic
       * ```java
       * Arrays.stream(words)
       *       .filter(s -> s.matches("(?i)^[aeiou].*"))
       *       .toList();
       * This produces a list of all strings beginning with A, E, I, O, or U.
       */
      System.out.println("\n--- Strings Starting With a Vowel ---");
      List<String> vowelStart = Arrays.stream(words)
           .filter(s -> s.matches("(?i)^[aeiou].*"))
           .toList();
      vowelStart.forEach(System.out::println);

      /**
       * ## 2. Concatenate all strings into a comma-separated string
       * Uses `Collectors.joining(", ")` to merge all elements into a single line.
       * ### Stream Logic
       * ```java
       * Arrays.stream(words)
       *       .collect(Collectors.joining(", "));
       * This produces a readable, comma‑separated representation of the array.
       */
      System.out.println("\n--- Concatenated String (Comma-Separated) ---");
      String concatenated = Arrays.stream(words)
           .collect(Collectors.joining(", "));
      System.out.println(concatenated);

      /**
       * ## 3. Count strings with more than 5 characters
       *
       * Counts how many strings exceed 5 characters in length.
       * ### Stream Logic
       * ```java
       * Arrays.stream(words)
       *       .filter(s -> s.length() > 5)
       *       .count();
       * ```
       * This demonstrates filtering + terminal counting using streams.
       */
      System.out.println("\n--- Count of Strings With More Than 5 Characters ---");
      long countLongerThan5 = Arrays.stream(words)
           .filter(s -> s.length() > 5)
           .count();
      System.out.println("Count: " + countLongerThan5);
   }
} 

