import org.w3c.dom.TypeInfo;

public class wrapper {
    public static void main(String[] args) {
        String a = "2";
        int b = Integer.parseInt(a); // parseInt(string,radix) where radix defines the base of conversion
        System.out.println(b);

        String s = "4.5";
        float f = Float.parseFloat(s); // parseFloat(string) where string is float
        System.out.println(f);

    }
}
