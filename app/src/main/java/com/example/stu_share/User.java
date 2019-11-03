package com.example.stu_share;

import java.io.Serializable;

public class User implements Serializable {
    public final String id;
    public  String email;
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

    public User(String id,String email,String pswd,String fn,String ln,String collegeCode,
                String programCode,String registerYear,String expYear,String question,
                String answer,String role,String status ){
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
