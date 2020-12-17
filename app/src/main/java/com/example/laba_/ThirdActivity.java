package com.example.laba_;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

public class ThirdActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent newInt = new Intent(this, About.class);
                startActivity(newInt.addFlags(FLAG_ACTIVITY_NO_HISTORY));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
    }

    public void toSec(View view) {
        setResult(RESULT_OK);
        finish();
    }

    public void toFirst(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
