package com.anirudh.anirudhswami.delta_2016_2;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;
    String command;
    String shap;
    String size;

    //float maxX,maxY;

    CanvasJav vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vi = new CanvasJav(MainActivity.this);
        //setContentView(R.layout.activity_main);
        //Inflate custom view
        setContentView(vi);
        //Defaults
        shap = "square";
        size = "small";

        //Setiing the notification
        StringBuffer buff = new StringBuffer();
        buff.append("POSITION\n'UP': Move the drawable up\n'Down': Move the drawable down\n'Left': Move the drawable left\n'Right': Move the drawable right\nSHAPE" +
                "\n'Circle': Change shape of drawable to circle\n'Square': Change shape of drawable to square\n'Rectangle': Change shape of drawable to a rectangle" +
                "\n'Oval': Change the shape of the drawable to oval\nSIZE\n'Small': Make the drawable small\n'Medium': Make the drawable medium size" +
                "\n'Large': Make the drawable large size\nPLEASE HAVE INTERNET CONNECTION\nPress COMMAND button in top right to give commands to the app");
        //showMessage("COMMANDS",buff.toString());

        AlertDialog.Builder abu= new AlertDialog.Builder(MainActivity.this);
        abu.setMessage(buff.toString()).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = abu.create();
        alert.setTitle("COMMANDS");
        alert.show();

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

        int id=item.getItemId();
        switch(id) {
            case R.id.speech:
                //Toast.makeText(getApplicationContext(), "Command icon is selected", Toast.LENGTH_SHORT).show();
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
            //Toast.makeText(MainActivity.this,"The spoken word was "+spokenText,Toast.LENGTH_SHORT).show();
        }
        //Move the drawable
        moveDrawab();
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void moveDrawab(){
        //Toast.makeText(MainActivity.this,"Command was "+command,Toast.LENGTH_SHORT).show();
        //setPos and setSize are defined by me(Anirudh Swaminathan)
        //setPos sets the position, while setSize changes the size and shape of the drawable
        switch (command){
            case "up":
                vi.setPos(0,-30);
                break;
            case "down":
                vi.setPos(0,30);
                break;
            case "left":
                vi.setPos(-30,0);
                break;
            case "right":
                vi.setPos(30,0);
                break;
            case "small":
                size = "small";
                vi.setSize(shap,size);
                break;
            case "medium":
                size = "medium";
                vi.setSize(shap,size);
                break;
            case "large":
                size = "large";
                vi.setSize(shap,size);
                break;
            case "square":
                shap = "square";
                vi.setSize(shap,size);
                break;
            case "rectangle":
                shap = "rect";
                vi.setSize(shap,size);
                break;
            case "circle":
                shap = "circle";
                vi.setSize(shap,size);
                break;
            case "oval":
                shap = "oval";
                vi.setSize(shap,size);
                break;
            default:
                Toast.makeText(MainActivity.this,"Wrong command",Toast.LENGTH_SHORT).show();
        }
    }
}
