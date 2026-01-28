package main.java;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static String generateChars(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";

        String allChars = upper + lower;


        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));

        for (int i = 2; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }


        char[] passArray = password.toString().toCharArray();
        for (int i = 0; i < passArray.length; i++) {
            int j = random.nextInt(passArray.length);
            char temp = passArray[i];
            passArray[i] = passArray[j];
            passArray[j] = temp;
        }
        return new String(passArray);
    }

    public static String generateNumbers(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";


        String allChars = upper + lower + numbers;


        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        for (int i = 3; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }


        char[] passArray = password.toString().toCharArray();
        for (int i = 0; i < passArray.length; i++) {
            int j = random.nextInt(passArray.length);
            char temp = passArray[i];
            passArray[i] = passArray[j];
            passArray[j] = temp;
        }
        return new String(passArray);
    }

    public static String generateSpecial(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String allChars = upper + lower + special;


        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        for (int i = 3; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }


        char[] passArray = password.toString().toCharArray();
        for (int i = 0; i < passArray.length; i++) {
            int j = random.nextInt(passArray.length);
            char temp = passArray[i];
            passArray[i] = passArray[j];
            passArray[j] = temp;
        }
        return new String(passArray);
    }

    public static String generateFull(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String allChars = upper + lower + numbers + special;


        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }


        char[] passArray = password.toString().toCharArray();
        for (int i = 0; i < passArray.length; i++) {
            int j = random.nextInt(passArray.length);
            char temp = passArray[i];
            passArray[i] = passArray[j];
            passArray[j] = temp;
        }
        return new String(passArray);
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        clearTerminal();

        System.out.println("Olá!");
        System.out.print("Insira a quantidade de caracteres (minimo 4): ");
        int charQt = scanner.nextInt();

        while (charQt < 4) {
            System.out.println("\n❌ A quantidade de caracteres tem que ser acima de 4!");
            System.out.print("Aperte ENTER para voltar...");
            scanner.nextLine();
            scanner.nextLine();
            clearTerminal();

            System.out.println("Olá!");
            System.out.print("Insira a quantidade de caracteres (minimo 4): ");
            charQt = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("Números? (true/false) ");
        Boolean containsNumber = scanner.nextBoolean();

        System.out.print("Símbolos? (true/false) ");
        boolean containsSpecial = scanner.nextBoolean();

        int totalLength = charQt + (containsNumber ? 1 : 0) + (containsSpecial ? 1 : 0);


            if (!containsNumber && !containsSpecial) {
                String password = generateChars(charQt);
                System.out.println("Senha gerada: " + password);
            } else if (containsNumber && !containsSpecial) {
                String password = generateNumbers(totalLength);
                System.out.println("Senha gerada: " + password);
            } else if (!containsNumber && containsSpecial) {
                String password = generateSpecial(totalLength);
                System.out.println("Senha gerada: " + password);
            } else if (containsNumber && containsSpecial) {
                String password = generateFull(totalLength);
                System.out.println("Senha gerada: " + password);
            }

        scanner.close();

        }
    }