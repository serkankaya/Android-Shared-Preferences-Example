package net.serkankaya.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editText=(EditText) findViewById(R.id.data);

    }

    public void fncSaveToSharedPreferences(View view){
        editor.putString("name",editText.getText().toString());
        editor.commit();
        String sharedPreferencesData=sharedPreferences.getString("name","");
        Toast.makeText(MainActivity.this,"Saved Name : "+ sharedPreferencesData,Toast.LENGTH_SHORT).show();

    }

    public void fncDeleteToSharedPreferences(View view){
        editor.remove("name");
        editor.commit();
    }

    public void fncShowDataToSharedPreferences(View view){
        String sharedPreferencesData=sharedPreferences.getString("name","");
        Toast.makeText(MainActivity.this,"Saved Name : "+ sharedPreferencesData,Toast.LENGTH_SHORT).show();
    }
}
