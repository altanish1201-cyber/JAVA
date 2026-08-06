public class revString {
    public static void main(String[] args) {

        // --------legacy
        String str = "Hello World!";
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char d = str.charAt(i);
            rev += d;
        }
        System.out.println("Reversed string: " + rev);

        // efficient way using StringBuffer class:
        StringBuffer sb = new StringBuffer("HELLO buffer!");
        sb.reverse();
        System.out.println("Reversed string: " + sb);

        // efficient way using StingBuilder class:
        StringBuilder sd = new StringBuilder("HELLO builder!");
        sd.reverse();
        System.out.println("Reversed string: " + sd);

    }

}
