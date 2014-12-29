package hex.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Useful methods for strings.
 *
 * @author TigerHix
 */
public final class Strings {

    private Strings() {
    }

    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String[] format(String[] strings) {
        return format(Arrays.asList(strings)).toArray(new String[strings.length]);
    }

    public static List<String> format(List<String> strings) {
        List<String> collection = new ArrayList<>();
        for (String string : strings) {
            collection.add(format(string));
        }
        return collection;
    }

    public static String link(List<String> strings) {
        String newString = "";
        for (String string : strings) {
            newString += string + ", ";
        }
        newString = newString.substring(0, newString.length() - 2);
        return newString;
    }

    public static List<String> prefix(List<String> strings, String prefix) {
        List<String> newStrings = new ArrayList<>();
        for (String string : strings) {
            newStrings.add(prefix + string);
        }
        return newStrings;
    }

    /**
     * Found this method a long time ago in Bukkit forums and I can't seem to find the original author.
     * Please tell me if you know who made this ;)
     */
    public static String rainbowlize(String string) {
        int lastColor = 0;
        int currColor;
        String newString = "";
        String colors = "123456789abcde";
        for (int i = 0; i < string.length(); i++) {
            do {
                currColor = new Random().nextInt(colors.length() - 1) + 1;
            }
            while (currColor == lastColor);
            newString += ChatColor.RESET.toString() + ChatColor.getByChar(colors.charAt(currColor)) + "" + string.charAt(i);
        }
        return newString;
    }

    public static String repeat(String string, int count) {
        if (count == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static String stripFormat(String string) {
        return ChatColor.stripColor(string);
    }

    public static String toMMSS(int seconds) {
        int rem = seconds % 3600;
        int mn = rem / 60;
        int sec = rem % 60;
        return (mn < 10 ? "0" : "") + mn + ":" + (sec < 10 ? "0" : "") + sec;
    }

}
