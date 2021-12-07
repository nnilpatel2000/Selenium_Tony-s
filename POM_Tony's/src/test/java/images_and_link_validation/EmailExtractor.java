package images_and_link_validation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {

    private URL url;
    private StringBuilder contents;
    private Set<String> emailAddresses;
    
  public static class Main {
        public static void main(String[] args) {
            EmailExtractor extract;
            Scanner scanner = new Scanner(System.in);
            String url;
            System.out.print("Enter the webpage URL: ");
            url = scanner.nextLine();
            extract = new EmailExtractor(url);
            extract.readContents();
            extract.extractEmail();
            extract.printEmailAddresses();
        }
        
    } 

    public EmailExtractor(String url) {
        try {
            this.url = new URL(url);
            emailAddresses = new HashSet<>();
        } catch (MalformedURLException ex) {
            System.out.println("\tPlease include Protocol in your URL!");
            System.exit(1);
        }
    }

    public void readContents() {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            contents = new StringBuilder();
            String input;
            while ((input = read.readLine()) != null) {
                contents.append(input);
            }
        } catch (IOException ex) {
            System.out.println("\tUnable to read URL due to Unknown Host..");
        }
    }

    public void extractEmail() {
        String pattern = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b";
        Pattern pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(contents);
        while (match.find()) {
            emailAddresses.add(match.group());
        }
    }

    public void printEmailAddresses() {
        if (emailAddresses.size() > 0) {
            System.out.println("\tThe Email Addresses extracted are: ");
            for (String emails : emailAddresses) {
                System.out.println(emails);
            }
        } else {
            System.out.println("\tNo emails were extracted!");
        }
    }
}

 


