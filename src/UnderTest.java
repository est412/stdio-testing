import java.io.IOException;
import java.util.Scanner;

public class UnderTest {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        System.out.println(s.nextInt());
        String str = "";
        while (str.isEmpty()) {
            str = s.nextLine();
        }
        System.out.println(str);

        str = "";
        while (str.isEmpty()) {
            str = s.nextLine();
        }
        System.out.println(str);
    }

}
