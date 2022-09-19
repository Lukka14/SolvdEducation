package xml;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name="school")
@XmlType(propOrder = {"name","grade","students","subjects"})
public class School {
    private String name;
    private String grade;
    private long students;
    private ArrayList<String> subjects;

    public School(){}

    public School(String name, String grade, long students, ArrayList<String> subjects) {
        this.name = name;
        this.grade = grade;
        this.students = students;
        this.subjects = subjects;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public void setGrade(String grade) {
        this.grade = grade;
    }
    @XmlElement
    public void setStudents(long students) {
        this.students = students;
    }
    @XmlElement
    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public long getStudents() {
        return students;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", students=" + students +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        return new EqualsBuilder().append(students, school.students).append(name, school.name).append(grade, school.grade).append(subjects, school.subjects).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(grade).append(students).append(subjects).toHashCode();
    }
}
