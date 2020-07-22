package com.ddvader44.trackcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CoronaCasesCountry extends AppCompatActivity {
    private int positionCountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_cases_country);
        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);
        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);

        tvCountry.setText(Countries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(Countries.countryModelList.get(positionCountry).getCases());
        tvRecovered.setText(Countries.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(Countries.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(Countries.countryModelList.get(positionCountry).getActive());
        tvTodayCases.setText(Countries.countryModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(Countries.countryModelList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(Countries.countryModelList.get(positionCountry).getTodayDeaths());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(CoronaCasesCountry.this,MainActivity.class));
        finish();
    }
}
