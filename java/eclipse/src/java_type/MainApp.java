package java_type;

import java.io.Console;

public class MainApp {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("ERROR console == null !!!");
            System.exit(1);
        }
        String name = console.readLine("User name: ");
        char[] passwd = console.readPassword("Mr/Miss %s Please input your pass word: ", name);

        System.out.printf("USER NAME [%s]%n", name);
        System.out.printf("PASS WORD [%s]%n", new String(passwd));
    }
}
