import javafx.util.Pair;

import java.util.ArrayList;

public class Problem {
    private ArrayList<Student> students= new ArrayList<Student>();
    private ArrayList<Pair<Student,Project>> matching = new ArrayList<Pair<Student,Project>>();
    public void setStudents(Student ... students) {
        for(int i=0;i<students.length;i++)
        {
            this.students.add(students[i]);
        }
    }
    public ArrayList<Project> getProjects()
    {
        ArrayList<Project> projectList = new ArrayList<Project>();
        for(int i=0;i<students.size();i++)
        {
            for(int j=0;j<students.get(i).preferences.size();j++)
            {
                if(!projectList.contains(students.get(i).preferences.get(j)))
                        projectList.add(students.get(i).preferences.get(j));
            }
        }
        return projectList;
    }
    public void matching()
    {
        ArrayList<Project> projectsTaken = new ArrayList<>();
        for(int i=0;i<students.size();i++) {
            for (int j = 0; j < this.students.get(i).preferences.size(); j++) {
                if(!projectsTaken.contains(this.students.get(i).preferences.get(j))) {
                    this.matching.add(new Pair<Student, Project>(this.students.get(i), this.students.get(i).preferences.get(j)));
                    projectsTaken.add(this.students.get(i).preferences.get(j));
                    break;
                }
            }
        }
    }

    public String getMatching() {
        String matchingString = new String();
        for(int i=0;i<this.matching.size();i++)
        {
            matchingString = matchingString + "{" + this.matching.get(i).getKey().toString()+" -> " +this.matching.get(i).getValue().toString() + "}\n";
        }
        return matchingString;
    }

    @Override
    public String toString() {
        String aux=" Studenti: { " +this.students.get(0)  ;
        for(int i=1;i<this.students.size();i++)
        {
            aux=aux + " , " + this.students.get(i);
        }
        return aux+ " } ";
    }
}
