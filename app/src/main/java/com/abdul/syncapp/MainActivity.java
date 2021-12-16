package com.abdul.syncapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {
    EditText nameEditText; //declaration
    Spinner namesSpinner;
    Button contactButton;

    public static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation - layout inflater

        contactButton = findViewById(R.id.btnContact);
        registerForContextMenu(contactButton);

        nameEditText = findViewById(R.id.etName); //initialization

        nameEditText.setOnFocusChangeListener(this);

        namesSpinner = findViewById(R.id.spinnerNames);
        namesSpinner.setOnItemSelectedListener(this);

        Log.i(TAG,"oncreate"); //i=info
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"onstart"); //w=warning
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresume"); //e= error

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onstop"); //verbose

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"ondestroy"); //d=debug

    }

    public void showToastMessage(View view) {
        //Toast.makeText(this, R.string.message, Toast.LENGTH_SHORT).show();

        String name = nameEditText.getText().toString();
        Intent mIntent = new Intent(this,HomeActivity.class); //explicit intent
        mIntent.putExtra("waterkey",name);
        startActivity(mIntent);
    }


    void add(int fnum, int snum){

        int d = 90 - 40;
         d += 20;
         d *=4;
       // return fnum + snum;
        throw new NullPointerException("i am not going to open alarm for you, i am angry");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);

         switch (item.getItemId()){
             case R.id.miSettings:
                 Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.miLogout:
                 Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();

                 break;
         }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);
         switch (item.getItemId()){
             case R.id.miEdit:
                 Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.miDelete:
                 Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();

                 break;
         }
        return true;
    }

    public void clickHandler(View view) {

        switch (view.getId()){
            case  R.id.btnAlarm:
                //sendTwilioMsg();
                //add(10,20);
                createAlarm("ravi plz wake up",13,0);
                break;
            case R.id.btnDial:
                Intent dialIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yahoo.com"));
                startActivity(dialIntent);
                break;
            case R.id.btnContact:
                Intent hIntent = new Intent(this,HomeActivity.class);
                startActivityForResult(hIntent,123);
                break;
            case R.id.btnCalendar:
                Intent calIntent = new Intent("ineed.abduls.calendar");
                startActivity(calIntent);
                break;
        }


    }

    /*public void sendTwilioMsg(){
        String ACCOUNT_SID = "";
        String AUTH_TOKEN = "";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+919880979732"),
                new com.twilio.type.PhoneNumber("whatsapp:+19383003774"),
                "Hello there!")
                .create();

    }*/


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

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if(isFocussed){
            Toast.makeText(this, "focussed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "not focussed", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String itemSelected = (String) adapterView.getItemAtPosition(position);
        Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}