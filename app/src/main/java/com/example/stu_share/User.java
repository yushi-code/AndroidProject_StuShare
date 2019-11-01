package com.example.stu_share;

public class User {

    public final String email;
    public final String password;
    public final String firstName;
    public final String lastName;
    public final String collegeCode;
    public final String registerYear;
    public final String programCode;
    public final String expireYear;
    public final String question;
    public final String answer;
    public final String role;
    public final String status;

    public User(String email,String pswd,String fn,String ln,String collegeCode,
                String programCode,String registerYear,String expYear,String question,
                String answer,String role,String status ){
        this.email=email;
        this.password=pswd;
        firstName=fn;
        lastName=ln;
        this.collegeCode=collegeCode;
        this.programCode=programCode;
        this.registerYear=registerYear;
        this.expireYear=expYear;
        this.question=question;
        this.answer=answer;
        this.role=role;
        this.status=status;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public String getRegisterYear() {
        return registerYear;
    }

    public String getProgramCode() {
        return programCode;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }
}
