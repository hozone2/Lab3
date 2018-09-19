import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        System.out.println("Ran");
        String text = WebScraper.urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] textArray = text.split(" ");
        int count = 0;
        String target = "prince";
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].toLowerCase().contains(target)) {
                count += 1;
                System.out.println(textArray[i]);
            }
        }
        System.out.println(count);
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}

