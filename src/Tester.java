import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Tester {

    // задать тестируемый класс вместо UnderTest
    static Class classUnderTest = UnderTest.class;

    public static void main(String[] args) throws Exception {
        // задать тестовый ввод данных
        mainTest(() -> {
            System.out.println("10");
            System.out.println("qwerty");
            System.out.println("щшгщшгщшгщшг");
            System.out.println("зззззззззззззззз");
        });

        mainTest(() -> {
            System.out.println("100");
            System.out.println("ytrytrytrytr");
            System.out.println("ccccccc");
            System.out.println("яяяяяяяяяяяяяяяяяяя");
        });

    }

    static void mainTest(Runnable runnable) throws Exception {
        System.out.println("===================== Начало теста =====================");
        System.out.println("------ Введенные данные ------");
        runnable.run();
        System.out.println("------ Результат работы ------");
        PrintStream ps = System.out;
        InputStream systemIn = System.in;
        ByteArrayInputStream bais = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(100000)){
            System.setOut(new PrintStream(baos));
            runnable.run();
            System.setOut(ps);
            bais = new ByteArrayInputStream(baos.toByteArray());
            System.setIn(bais);
            classUnderTest.getMethod("main", String[].class).invoke(null, (Object) null);
        } finally {
            System.setOut(ps);
            System.setIn(systemIn);
            if (bais != null) bais.close();
        }
        System.out.println("===================== Конец теста =====================");
    }

}
