import java.util.ArrayList;

public class Student {
    private String name;
    private int yearOfStudy;
    ArrayList<Project> preferences = new ArrayList<Project>();
    Student(String name,int yearOfStudy)
    {
        this.name=name;
        this.yearOfStudy=yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setPreferences(Project ... projects) {
        for(int i=0;i<projects.length;i++)
        {
            this.preferences.add(projects[i]);
        }
    }

    @Override
    public String toString() {
        return " { " + this.getName() + " , " + this.getYearOfStudy() + " } " ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null)
        {
            return false;
        }
        if(this.toString().equals(obj.toString()))
            return true;
        else
            return false;

    }
}
