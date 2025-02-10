package org.example;

import java.util.Locale;
import java.util.Stack;

public class Main {
    public static boolean checkForPalindrome(String str) {
        // Önce büyük 'I' harfini 'İ' harfine çeviriyoruz, sonra küçük harfe çeviriyoruz.
        str = str.replace("I", "İ").toLowerCase(Locale.ENGLISH);

        // Türkçe karakter dönüşümünü manuel olarak yapalım
        str = str.replace("ı", "i")  // 'ı' harfini 'i' olarak değiştir
                .replace("İ", "i")  // 'İ' harfini 'i' olarak değiştir
                .replace("ç", "c")  // 'ç' harfini 'c' olarak değiştir
                .replace("Ç", "c")  // 'Ç' harfini 'c' olarak değiştir
                .replace("ş", "s")  // 'ş' harfini 's' olarak değiştir
                .replace("Ş", "s")  // 'Ş' harfini 's' olarak değiştir
                .replace("ğ", "g")  // 'ğ' harfini 'g' olarak değiştir
                .replace("Ğ", "g")  // 'Ğ' harfini 'g' olarak değiştir
                .replace("ü", "u")  // 'ü' harfini 'u' olarak değiştir
                .replace("Ü", "u")  // 'Ü' harfini 'u' olarak değiştir
                .replace("ö", "o")  // 'ö' harfini 'o' olarak değiştir
                .replace("Ö", "o"); // 'Ö' harfini 'o' olarak değiştir

        // Tüm harfleri küçük harfe çevir ve sadece harf ve rakamları koru
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Cleaned String: " + cleaned);  // Temizlenmiş string'i kontrol edelim

        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public static String convertDecimalToBinary(int number) {
        if (number == 0) {
            return "0"; // Özel durum: 0'ın binary karşılığı yine 0'dır.
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder binaryString = new StringBuilder();

        // Bölerek binary'ye çevirme işlemi
        while (number > 0) {
            stack.push(number % 2); // Kalanı stack'e ekle
            number /= 2;
        }

        // Stack'ten çekerek binary string oluştur
        while (!stack.isEmpty()) {
            binaryString.append(stack.pop());
        }

        return binaryString.toString();
    }

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(checkForPalindrome("Racecar")); // true
        System.out.println(checkForPalindrome("hello")); // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?")); // true
        System.out.println(convertDecimalToBinary(5));  // 101
        System.out.println(convertDecimalToBinary(6));  // 110
        System.out.println(convertDecimalToBinary(13)); // 1101
        System.out.println(convertDecimalToBinary(0));  // 0
    }
}