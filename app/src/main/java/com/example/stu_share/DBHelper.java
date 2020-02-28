package com.example.stu_share;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


import static com.example.stu_share.AdminEventList.AdminEventAdapter;
import static com.example.stu_share.AdminUserList.AdminUserAdapter;
import static com.example.stu_share.EventCoordinator.EVENTS;
import static com.example.stu_share.User.USERS;

public class DBHelper extends AppCompatActivity
{   public static String a="";
    private final Context context;

    public DBHelper(Context context) {
        this.context = context;
    }
    public void suspendEvent(final String urlWebService,final EventCoordinator.Event event1) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    //jsonParam.put("userId", user2.id);

                    jsonParam.put("eventId", event1.id);

                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));

                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG", conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is = new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": ");


                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();



    }
    public void updateEvent(final EventCoordinator.Event event, final String url) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url1 = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("eventID", event.id);
                    jsonParam.put("startDate", event.startDate);
                    jsonParam.put("startTime", event.startTime);
                    jsonParam.put("endDate", event.endDate);
                    jsonParam.put("endTime", event.endTime);
                    jsonParam.put("title", event.eventTitle);
                    jsonParam.put("detail", event.eventDetail);
                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG", conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is = new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": ");
                } catch (UnsupportedEncodingException | JSONException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
        thread.start();
    }

    public  void updateEventStatus(final String urlWebService,final String id) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("eventId", id);

                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG", conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is = new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": ");


                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
    public  void joinEvent(final String urlWebService,final User user,final EventCoordinator.Event event) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    JSONObject jsonParam = new JSONObject();

                    jsonParam.put("eventId", event.id);
                    jsonParam.put("userId", user.id);
                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG", conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is = new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": ");


                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
    public String  mainPullUser(final String urlweb, final String email) {
        //final User userTest=new User();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL(urlweb);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("email", email);


                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is=new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": " );
                    User user1=jsonToUser(total.toString().trim());


                    if(user1.id==null ||user1.id.isEmpty()){
                        a="no account";
                    }else if (user1.role.equals("admin")){

                        Log.d("User", "User is: " + user1.toString() + ": " );
                        Intent i=new Intent(context, AdminDashboard.class);
                        i.putExtra("user",user1);
                        context.startActivity(i);
                    }else if (user1.role.equals("student")){

                        Log.d("User", "User is: " + user1.toString() + ": " );
                        Intent i=new Intent(context, MainMenu.class);
                        i.putExtra("user",user1);
                        context.startActivity(i);
                    }
                } catch (ProtocolException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }

            }
        });
        thread.start();
        return a;
    }
    public String  pullAUser(final String urlweb, final String email) {
        //final User userTest=new User();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL(urlweb);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("email", email);


                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is=new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": " );
                    User user1=jsonToUser(total.toString().trim());


                    if(user1.id==null ||user1.id.isEmpty()){
                        a="no account";
                    }else {

                        Log.d("User", "User is: " + user1.toString() + ": " );
                        Intent i=new Intent(context, ResetPassword.class);
                        i.putExtra("args",user1);
                        context.startActivity(i);
                    }
                } catch (ProtocolException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }

            }
        });
        thread.start();
        return a;
    }

    private User jsonToUser(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        USERS.clear();
        User user1=new User();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            user1.setId( obj.getString("id"));
            user1.setEmail( obj.getString("email"));
            user1.setPassword(obj.getString("password"));
            user1.setFirstName( obj.getString("firstName"));
            user1.setLastName(obj.getString("lastName"));
            user1.setCollegeCode( obj.getString("collegeCode"));
            user1.setProgramCode( obj.getString("programCode"));
            user1.setRegisterYear(obj.getString("registeredYear"));
            user1.setExpireYear( obj.getString("expireYear"));
            user1.setStatus( obj.getString("status"));
            user1.setQuestion(obj.getString("question"));
            user1.setAnswer( obj.getString("answer"));
            user1.setRole( obj.getString("role"));
        }
        return user1;



    }

    public void createAccount(final String url2,String email, String password, String firstName, String lastName, String collegeCode, String programCode, String registeredYear, String exprireYear,String status, String question, String answer, String role){
        String urlSuffix = "?email=" + email + "&password=" + password + "&firstName=" + firstName + "&lastName=" + lastName + "&collegeCode=" + collegeCode + "&programCode=" + programCode
                + "&registeredYear=" + registeredYear + "&expireYear=" + exprireYear +"&status=" + status + "&question=" + question + "&answer=" + answer +"&role=" + role;
        class CreateUserAccount extends AsyncTask<String, Void, String> {

            //ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loading = ProgressDialog.show(Signup2.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //loading.dismiss();
               // Toast.makeText(MainActivity.class,"Registered", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Menu.class, this);
//                startActivity(intent);
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(url2+s);

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
    public void updateUser(final User user, final String urlWebService) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("userId", user.id);
                    jsonParam.put("firstname", user.firstName);
                    jsonParam.put("lastname", user.lastName);
                    jsonParam.put("question", user.question);
                    jsonParam.put("answer", user.answer);
                    jsonParam.put("password", user.password);


                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG", conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is = new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": ");
                } catch (UnsupportedEncodingException | JSONException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
        thread.start();
    }
    public void createEvent(final EventCoordinator.Event event,final String url) {
        String urlSuffix = "?organizer_id=" + event.orgID +"&status=" + event.status +"&startDate=" + event.startDate + "&startTime=" + event.startTime + "&endDate=" + event.endDate + "&endTime=" + event.endTime
                + "&title=" + event.eventTitle + "&detail=" + event.eventDetail;
        class CreateEvent extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader = null;
                try {
                    URL url1 = new URL(url + s);
                    HttpURLConnection con = (HttpURLConnection) url1.openConnection();
                    con.setRequestMethod("POST");
                    bufferReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result = bufferReader.readLine();
                    return result;

                } catch (Exception e) {
                    return null;
                }
            }
        }
        CreateEvent eventC = new CreateEvent();
        eventC.execute(urlSuffix);
        //AdminEventAdapter.notifyDataSetChanged();
    }
    public  void adminUpdateUser(final String urlWebService,final String status,final User userDetail) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://w0044421.gblearn.com/stu_share/user_status_update.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("status", status);
                    jsonParam.put("userId", userDetail.id);



                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is=new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": " );

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
    public void downloadEventJSON(final String urlWebService, final User user) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    loadIntoEventListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("userid", user.id);
                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is=new DataInputStream(conn.getInputStream());
                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": " );
                    return total.toString().trim();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();

    }

    public void loadIntoEventListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        EVENTS.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            EventCoordinator.Event event1 = new EventCoordinator.Event();
            event1.setId( obj.getString("id"));
            event1.setOrgID(obj.getString("organizerId"));
            event1.setStatus(obj.getString("status"));
            event1.setStartDate(obj.getString("startDate"));
            event1.setStartTime(obj.getString("startTime"));
            event1.setEndDate(obj.getString("endDate"));
            event1.setEndTime(obj.getString("endTime"));
            event1.setEventTitle(obj.getString("title"));
            event1.setEventDetail(obj.getString("detail"));
            EVENTS.add(event1);

        }
        AdminEventAdapter.notifyDataSetChanged();
    }
    public void downloadUserJSON(final String urlWebService) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                try {
                    loadIntoUserListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    con.setRequestMethod("POST");
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }
    public void loadIntoUserListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] stocks = new String[jsonArray.length()];
        String[] userShort = new String[jsonArray.length()];
        USERS.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            User user1=new User();
            user1.setId( obj.getString("id"));
            user1.setEmail( obj.getString("email"));
            user1.setPassword(obj.getString("password"));
            user1.setFirstName( obj.getString("firstName"));
            user1.setLastName(obj.getString("lastName"));
            user1.setCollegeCode( obj.getString("collegeCode"));
            user1.setProgramCode( obj.getString("programCode"));
            user1.setRegisterYear(obj.getString("registeredYear"));
            user1.setExpireYear( obj.getString("expireYear"));
            user1.setStatus( obj.getString("status"));
            user1.setQuestion(obj.getString("question"));
            user1.setAnswer( obj.getString("answer"));
            user1.setRole( obj.getString("role"));
            USERS.add(user1);
            userShort[i] = user1.getFirstName() + " " + user1.getLastName();
            stocks[i] = user1.getFirstName() ;

        }
        AdminUserAdapter.notifyDataSetChanged();



    }

    public void downloadOwnedEventJSON(final String urlWebService,final User user) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                try {
                    loadIntoEventListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }



            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("userid", user.id);
                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is=new DataInputStream(conn.getInputStream());
                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": " );
                    //loadIntoListView(total.toString().trim(),evt);
                    return total.toString().trim();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }
}


