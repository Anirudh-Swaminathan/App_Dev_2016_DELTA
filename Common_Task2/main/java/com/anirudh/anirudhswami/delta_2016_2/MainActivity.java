package com.anirudh.anirudhswami.delta_2016_2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.transition.TransitionManager;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;
    String command;

    float maxX,maxY;
    DisplayMetrics dm = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflate the menu. This adds options to the actionbar if it is present
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle ActionBar item clicks here. The actionbar will
        //automatically handle clicks on the home/up button as long
        //as you specify a parent activity in android manifests.xml
        int id=item.getItemId();
        /*
        if(id==R.id.action_settings){
            return true;
        }
        */
        switch(id) {
            case R.id.speech:
                Toast.makeText(getApplicationContext(), "Command icon is selected", Toast.LENGTH_SHORT).show();
                displaySpeechRecognizer();
                //moveDrawab();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Start the activity, the intent will be populated with the speech text
        try {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } catch (ActivityNotFoundException a){
            Toast.makeText(MainActivity.this,"Sorry, But no speech today!!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            command = spokenText;
            // Do something with spokenText
            Toast.makeText(MainActivity.this,"The spoken word was "+spokenText,Toast.LENGTH_SHORT).show();
        }
        moveDrawab();
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void moveDrawab(){
        Toast.makeText(MainActivity.this,"Command was "+command,Toast.LENGTH_SHORT).show();
        ViewGroup AniLay = (ViewGroup) findViewById(R.id.AniLayout);
        TransitionManager.beginDelayedTransition(AniLay);
        View image = findViewById(R.id.moveIt);
        ImageView img = (ImageView) image;
        float x,y;
        x = img.getX();
        y = img.getY();
        //change position
        //RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams sizeRules = image.getLayoutParams();
        switch (command){
            case "up":
                /*
                if(positionRules.topMargin>=10) {
                    Toast.makeText(MainActivity.this,"Positon top is "+positionRules.topMargin,Toast.LENGTH_SHORT).show();
                    positionRules.topMargin = positionRules.topMargin - 10;
                    Toast.makeText(MainActivity.this,"Positon top is "+positionRules.topMargin,Toast.LENGTH_SHORT).show();
                }
                */
                if(y>=74){
                    Toast.makeText(MainActivity.this,"Positon top was "+y,Toast.LENGTH_SHORT).show();
                    y-=50;
                    img.setX(x);
                    img.setY(y);
                    Toast.makeText(MainActivity.this,"Positon top is "+y,Toast.LENGTH_SHORT).show();
                }
                break;
            case "down":
                /*
                if(positionRules.bottomMargin>=10){
                    positionRules.bottomMargin = positionRules.bottomMargin -10;
                }
                */
                Toast.makeText(MainActivity.this,"Positon top was "+y,Toast.LENGTH_SHORT).show();
                if(y<=630) {
                    y += 50;
                }
                img.setX(x);
                img.setY(y);
                Toast.makeText(MainActivity.this,"Positon top is "+y,Toast.LENGTH_SHORT).show();
                break;
            case "left":
                if(x>=74){
                    x-=50;
                    img.setX(x);
                    img.setY(y);
                }
                break;
            case "right":
                if(x<=390) {
                    x += 50;
                }
                img.setX(x);
                img.setY(y);
                Toast.makeText(MainActivity.this,"Left now is "+x,Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this,"Wrong command",Toast.LENGTH_SHORT).show();
        }
        //image.setLayoutParams(positionRules);
    }
}
