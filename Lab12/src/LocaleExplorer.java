import context.LocaleC;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class LocaleExplorer {
    private final String baseName = "Messages";
    private Properties commands;

    public void run() {
        LocaleC.setLocale("en-US");
        Scanner scanner = new Scanner(System.in);
        commands = new Properties();
        try{
            commands.load(this.getClass().getClassLoader().getResourceAsStream("Commands.properties"));
        }catch (IOException e){
            System.out.println(e);
        }
        while (true) {
            System.out.print(LocaleC.message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            try {
                Class set = Class.forName(commands.getProperty(params[0]));
                if(params[0].equals("set"))
                    set.getConstructor(String.class).newInstance(params[1]);
                else
                    set.getConstructor().newInstance();
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(e);

            }
        }
    }

    public static void main(String[] args) {
        new LocaleExplorer().run();
    }
}