import java.time.LocalDate;
import java.time.Month;

public class SPA {
    public static void main(String[] args)
    {
        Student s1 = new Student("S1", 2);
        Student s2 = new Student("S2", 3);
        Student s3 = new Student("S2", 3);
        Student s4 = new Student("S4", 3);
        Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        Application a2 = new Application("A2", LocalDate.of(2019, Month.JANUARY, 1), Language.JAVA);
        Application a3 = new Application("A3", LocalDate.of(2014, Month.JUNE, 1), Language.JAVA);
        Essay e1 = new Essay("E1", LocalDate.parse("2019-06-01"), Topic.ALGORITHMS);
        s1.setPreferences(a1, a2, a3);
        s2.setPreferences(a1, e1);
        s3.setPreferences(a3);
        s4.setPreferences(a2);
        Problem problem = new Problem();
        problem.setStudents(s1, s2, s3, s4);
        for(int i=0;i<problem.getProjects().size();i++)
        {
            System.out.println(problem.getProjects().get(i));
        }
        System.out.println(problem);
        problem.matching();
        System.out.println(problem.getMatching());
    }
}
