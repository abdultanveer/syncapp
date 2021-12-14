package com.abdul.syncapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation - layout inflater

        nameEditText = findViewById(R.id.etName); //initialization
    }

    public void showToastMessage(View view) {
        //Toast.makeText(this, R.string.message, Toast.LENGTH_SHORT).show();

        String name = nameEditText.getText().toString();
        Intent mIntent = new Intent(this,HomeActivity.class); //explicit intent
        mIntent.putExtra("waterkey",name);
        startActivity(mIntent);
    }


    int add(int fnum, int snum){
        return fnum + snum;
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case  R.id.btnAlarm:
                createAlarm("ravi plz wake up",13,0);
                break;
            case R.id.btnDial:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9845098450"));
                startActivity(dialIntent);
                break;
            case R.id.btnContact:
                Intent hIntent = new Intent(this,HomeActivity.class);
                startActivityForResult(hIntent,123);
                break;
        }

    }


    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK){
           String contact =  data.getExtras().getString("con");
            TextView tvMain = findViewById(R.id.tvMain);
            tvMain.setText(contact);
        }
    }
}