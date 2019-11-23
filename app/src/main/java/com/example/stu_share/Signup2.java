package com.example.stu_share;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Signup2 extends AppCompatActivity {
    Button btnSign;
    EditText txtPC,txtRY,txtExp;
    private User userReg;
    //    DBHelper dbHelper=null;
    SignUpEmailPass signUpEmailPass;
    Signup signup;
    private static final String REGISTER_URL="https://f9team1.gblearn.com/stu_share/user_account_create.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);


        txtPC=findViewById(R.id.txtPC);
        txtRY=findViewById(R.id.txtRY);
        txtExp=findViewById(R.id.txtExp);
        btnSign = findViewById(R.id.btnSign);
//        dbHelper=new DBHelper(this);
//        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserAccount();
//                if (txtPC.getText().toString().equals("") || txtRY.getText().toString().equals("") || txtExp.getText().toString().equals("")
//                        || txtPC.getText().toString().equals("") || txtRY.getText().toString().equals("") || txtExp.getText().toString().equals("")) {
//                    Toast.makeText(getBaseContext(), "Can't leave fields empty! ",
//                            Toast.LENGTH_LONG).show();
//                } else {

//                    userReg=(User)getIntent().getSerializableExtra("user");
//                    userReg.setProgramCode(txtPC.getText().toString());
//                    userReg.setRegisterYear(txtRY.getText().toString());
//                    userReg.setExpireYear(txtExp.getText().toString());
//                    dbHelper.insertUser(db,userReg);
//                    Toast.makeText(getBaseContext(), "You have been registered in our system",
//                        Toast.LENGTH_LONG).show();
                logout();
            }
        });

        Button btnCancel=findViewById(R.id.btnSignup2Cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
//              intent.putExtra("args", userReg);
                startActivity(intent);
            }
        });
    }

    private void createUserAccount() {
        userReg=(User)getIntent().getSerializableExtra("args");
        userReg.setProgramCode(txtPC.getText().toString());
        userReg.setRegisterYear(txtRY.getText().toString());
        userReg.setExpireYear(txtExp.getText().toString());
        String email = userReg.email;
        String password = userReg.password;
        String first_name = userReg.firstName;
        String last_name = userReg.lastName;
        String question = userReg.question;
        String answer = userReg.answer;
        String program_code = userReg.programCode;
        String registered_year = userReg.registerYear;
        String expire_year = userReg.expireYear;

        createAccount(email, password, first_name, last_name,"gbc" ,program_code, registered_year, expire_year,"active", question, answer,"student");
    }


    private void createAccount(String email, String password, String firstName, String lastName, String collegeCode, String programCode, String registeredYear, String exprireYear,String status, String question, String answer, String role){
        String urlSuffix = "?email=" + email + "&password=" + password + "&firstName=" + firstName + "&lastName=" + lastName + "&collegeCode=" + collegeCode + "&programCode=" + programCode
                + "&registeredYear=" + registeredYear + "&expireYear=" + exprireYear +"&status=" + status + "&question=" + question + "&answer=" + answer +"&role=" + role;
        class CreateUserAccount extends AsyncTask<String, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Signup2.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),"Registered", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Menu.class, this);
//                startActivity(intent);
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(REGISTER_URL+s);

                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    con.setRequestMethod("POST");
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    return  result;

                }catch (Exception e){
                    return null;
                }
            }

        }
        CreateUserAccount account=new CreateUserAccount();
        account.execute(urlSuffix);
    }

    public void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
