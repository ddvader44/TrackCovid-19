package com.ddvader44.trackcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView cases,recovered,critical,active,todayCases,totalDeaths,todayDeaths,affectedCountries;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cases = findViewById(R.id.tvCases);
        recovered = findViewById(R.id.tvRecovered);
        critical = findViewById(R.id.tvCritical);
        active = findViewById(R.id.tvActive);
        todayCases = findViewById(R.id.tvTodayCases);
        totalDeaths = findViewById(R.id.tvTotalDeaths);
        todayDeaths = findViewById(R.id.tvTodayDeaths);
        affectedCountries = findViewById(R.id.tvAffectedCountries);

        simpleArcLoader = findViewById(R.id.loader);
        scrollView = findViewById(R.id.scrollStats);
        pieChart = findViewById(R.id.piechart);

        getCovidDetails();
    }

    private void getCovidDetails() {
        String URL = "https://corona.lmao.ninja/v2/all/";
        simpleArcLoader.start();
        //Usage of Volley now:-
        StringRequest request = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            cases.setText(jsonObject.getString("cases"));
                            recovered.setText(jsonObject.getString("recovered"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void trackYourCountry(View view) {

    }
}
