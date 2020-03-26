package commands;

import context.LocaleC;

public class SetLocaleCommand {
    public SetLocaleCommand(String string) {
        LocaleC.setLocale(string);
    }
}
