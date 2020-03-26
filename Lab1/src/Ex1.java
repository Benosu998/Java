public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Hello Word");
        String language[] = {"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_0000);
        int hex = Integer.parseInt("FF", 16);
        int bin = Integer.parseInt("10101", 2);
        int result = (n * 3 + bin + hex) * 6;
        int aux=0;
        result = result%9!=0?result&9:9;
        System.out.println("Willy-nilly, this semester I will learn " + language [ result ] ) ;
    }
}
