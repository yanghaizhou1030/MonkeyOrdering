package com.monkeylive.monkeyordering;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {

    public boolean isLogin = false;

    private void startLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, 1);//1 is request code
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isLogin) {
            startLogin();
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("OnResume", "Enter");
        Log.e("isLogin=", String.valueOf(isLogin));
        if (!isLogin) {
            startLogin();
        } else {
            setContentView(R.layout.activity_main);
        }
        Log.e("OnResume", "Out");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("OnActivity", "Enter");
        if (requestCode == 1 && data != null) { //return from login activity
            isLogin = data.getBooleanExtra("LoginPass", false);
            Log.e("OnActivity, isLogin=", String.valueOf(isLogin));
        }
        Log.e("OnActivity", "Out");
    }
}
