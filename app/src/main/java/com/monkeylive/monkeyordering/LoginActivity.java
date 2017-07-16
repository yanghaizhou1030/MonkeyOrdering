package com.monkeylive.monkeyordering;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//public class LoginActivity extends AppCompatActivity {
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonDoLogin = (Button)findViewById(R.id.buttonLogin);
        buttonDoLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("OnClick", "Enter");
                Intent intentReturn = new Intent();
                intentReturn.putExtra("LoginPass", true);
                setResult(1, intentReturn);
                LoginActivity.this.finish();
                Log.e("OnClick", "Out");
            }
        });
    }
}
