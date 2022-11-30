package com.example.pappdavid_varosok;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private Button back;
    private TextView datas;
    private List<Varosok> varosokList = new ArrayList<>();
    private static final String baseUrl = "https://retoolapi.dev/tBJYiU/varosok";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    init();



    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(ListActivity.this,MainActivity.class));
            finish();
        }
    });
    }
    private void init(){
        back = findViewById(R.id.back);
        datas = findViewById(R.id.datas);
        datas.setMovementMethod(new ScrollingMovementMethod());
        RequestTask task = new RequestTask("Get");
        task.execute();
    }

    private class RequestTask extends AsyncTask<Void,Void,Response> {
        private String requestUrl;
        public String requestMethod;
        private String requestBody;

        public RequestTask(String requestUrl) {
            this.requestUrl = requestUrl;
            this.requestMethod = "GET";
        }

        public RequestTask(String requestUrl, String requestMethod) {
            this.requestUrl = requestUrl;
            this.requestMethod = requestMethod;
        }

        public RequestTask(String requestUrl, String requestMethod, String requestBody) {
            this.requestUrl = requestUrl;
            this.requestMethod = requestMethod;
            this.requestBody = requestBody;
        }

        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                switch (requestMethod) {
                    case "GET":
                        response = RequestHandler.get(baseUrl);
                        break;
                    case "POST":
                        response = RequestHandler.post(requestUrl, requestBody);
                        break;
                    case "PUT":
                        response = RequestHandler.put(requestUrl, requestBody);
                        break;
                    case "DELETE":
                        response = RequestHandler.delete(requestUrl);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

    }


    protected void onPostExecute(Response response){
        Gson converter = new Gson();
        onPostExecute(response);
        if(response == null){
            Toast.makeText(ListActivity.this, "unable_to_connect", Toast.LENGTH_SHORT).show();
            return;
        }
        if(response.getResponseCode() >= 400){
            Toast.makeText(ListActivity.this, response.getContent(), Toast.LENGTH_SHORT).show();
            return;
        }
        /*switch (requestMethod){
            case "GET":
                String content = response.getContent();
                varosokList = Arrays.asList(converter.fromJson(content, Varosok[].class));
                System.out.println("!"+varosokList);
                datas.setText(varosokList.toString());
                break;
            default:
                if (response.getResponseCode() >= 201 && response.getResponseCode() < 300){
                    datas.setText("");
                    RequestTask task = new RequestTask(baseUrl);
                    task.execute();
                }
                break;*/
        }
    }


