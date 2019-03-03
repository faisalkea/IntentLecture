package test.com.intentlecture;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    private String firstName;
    private String lastName;
    private String cpr;
    private String email;
    private String password;

    public Student() {
    }

    public Student(String firstName, String lastName, String cpr, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpr = cpr;
        this.email = email;
        this.password = password;
    }

    protected Student(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        cpr = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpr='" + cpr + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(cpr);
        parcel.writeString(email);
        parcel.writeString(password);
    }
}
