package app;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class LocaleExplorer {
    private final String baseName = "resources.Messages";
    private Locale locale;
    private ResourceBundle resourceBundle;

    public void run() {
        setLocale("en-US");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales" : displayLocales(); break;
                case "set"     : setLocale(params[1]); getInfo(); break;
                case "info"    : localeInfo(); break;
                default        : System.out.println(message("invalid"));
            }
        }
    }
    private String message(String key, String ... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }
    private void setLocale(String languageTag) {
        this.locale = Locale.forLanguageTag(languageTag);
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        System.out.println(message("locale.set", languageTag));
    }
    private void displayLocales() {
        System.out.println(message("locales"));
        Locale available[] = Locale.getAvailableLocales();
        for(Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + " " +
                    locale.getDisplayLanguage(locale) + "\n");
        }
    }
    private void localeInfo() {
        String pattern = message("locale.set", locale.toString());
        System.out.println(pattern);
    }
    private void getInfo() {
        System.out.println(message("info", locale.getDefault().toString()));
        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Currency: " + Currency.getInstance(locale));
        List<String> days=new ArrayList<>();
        for(DayOfWeek day:DayOfWeek.values()){
            days.add(day.getDisplayName(TextStyle.FULL,locale));
        }
        System.out.println("Days of the week:"+days);
        List<String> months = new ArrayList<>();
        for (Month m : Month.values()) {
            months.add(m.getDisplayName(TextStyle.FULL, locale));
        }
        System.out.println("Month: " + months);

        LocalDate date=LocalDate.now();
        DayOfWeek day=date.getDayOfWeek();
        String currentDay=day.getDisplayName(TextStyle.FULL,locale);
        System.out.println("Current day:"+currentDay);
    }
    public static void main(String args[]) {
        new LocaleExplorer().run();
    }
}