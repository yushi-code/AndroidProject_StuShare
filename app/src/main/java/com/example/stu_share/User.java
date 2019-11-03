package com.example.stu_share;

import java.io.Serializable;

public class User implements Serializable {
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public void setRegisterYear(String registerYear) {
        this.registerYear = registerYear;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  String id;

    public void setEmail(String email) {
        this.email = email;
    }

    public  String email;
    public  String password;
    public  String firstName;
    public  String lastName;
    public  String collegeCode;
    public  String registerYear;
    public  String programCode;
    public  String expireYear;
    public  String question;
    public  String answer;
    public  String role;
    public  String status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + '\n' +
                ", email=" + email + '\n' +
                ", password=" + password + '\n' +
                ", firstName=" + firstName + '\n' +
                ", lastName=" + lastName + '\n' +
                ", collegeCode=" + collegeCode + '\n' +
                ", registerYear=" + registerYear + '\n' +
                ", programCode=" + programCode + '\n' +
                ", expireYear=" + expireYear + '\n' +
                ", question=" + question + '\n' +
                ", answer=" + answer + '\n' +
                ", role=" + role + '\n' +
                ", status=" + status + '\n' +
                '}';
    }

    public User(String id, String email, String pswd, String fn, String ln, String collegeCode,
                String programCode, String registerYear, String expYear, String question,
                String answer, String role, String status ){
        this.id=id;
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


}
