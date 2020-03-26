package context;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class LocaleC {
    private static final String baseName = "Messages";
    private static Locale locale;
    private static ResourceBundle resourceBundle;

    public static String message(String key, String... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }

    public static void setLocale(String languageTag) {
        locale = java.util.Locale.forLanguageTag(languageTag);
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
        message("locale.set", languageTag);
    }

    public static void displayLocales() {
        System.out.println(LocaleC.message("locales"));
        Locale available[] = Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + " " +
                    locale.getDisplayLanguage(locale) + "\n");
        }
    }

    public static void localeInfo() {
        String pattern = LocaleC.message("locale.set");
        for (Locale lc : Locale.getAvailableLocales()) {
            System.out.println(lc.getDisplayName() + lc.getDisplayLanguage() + lc.getDisplayVariant() + lc.getDisplayScript());
        }
    }
}
