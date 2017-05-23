import java.util.Date;

/**
 * Created by Executor on 22.05.2017.
 */
public class Student {
    private String name;
    private String sur_name;
    private int group_id;
    private Date enrolment_date;
    private double rating_ege;

    public double getRating_ege() {
        return rating_ege;
    }

    public void setRating_ege(double rating_ege) {
        this.rating_ege = rating_ege;
    }

    public String getName() {
        return name;
    }

    public String getSur_name() {
        return sur_name;
    }

    public int getGroup_id() {
        return group_id;
    }

    public Date getEnrolment_date() {
        return enrolment_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSur_name(String sur_name) {
        this.sur_name = sur_name;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setEnrolment_date(Date enrolment_date) {
        this.enrolment_date = enrolment_date;
    }
}
