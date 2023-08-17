package javacode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZPractice {

    public static boolean isValidURL(String url)
    {
        // Regex to check valid URL
        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (url == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(url);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    public static void main(String[] args) {
        /*final String time = "23:30:00";

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            final Date dateObj = sdf.parse(time);
            System.out.println(dateObj);
            System.out.println(new SimpleDateFormat("h:mm a").format(dateObj));
        } catch (final ParseException e) {
            e.printStackTrace();
        }*/

        System.out.println(isValidURL("http://172.16.205.102:8088/login"));

        Object x = "This";

        for (int i = 0; i < 5; i++) {
            System.out.println(x);
            x = 1.6;
            System.out.println(x);
        }


    }
}
