import java.time.LocalDate;

public abstract class Project {
    private String name;
    private LocalDate deadline;
    protected Project(String name,LocalDate deadline)
    {
        this.name=name;
        this.deadline=deadline;
    }
    protected Project()
    {

    }
    public String getName() {
        return name;
    }
    public LocalDate getDeadline() {
        return deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "{" + this.name + " , " + this.deadline + "}" ;
    }
}
