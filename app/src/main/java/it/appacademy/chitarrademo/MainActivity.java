package it.appacademy.chitarrademo;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import static android.util.Log.*;

//TODO implementare l'interfaccia View.OnTouchListener
public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    // Costanti
    private final int NR_OF_SIMULTANEOUS_SOUND = 6;

    // TODO: Aggiungere member variables

    private int mSE;
    private int mSA;
    private int mSD;
    private int mSG;
    private int mSB;
    private int mSe6;

    private SoundPool mStringsSound;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint({"SourceLockedOrientationActivity", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Impostare l'orientation dell'activity su Landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        // TODO: Impostare la visualizzazione dell'activity fullscreen. Supportare le versioni precedenti ad Android 4.4
        int currentAPIVersion;

        final int flags;
        currentAPIVersion = Build.VERSION.SDK_INT;

        if(currentAPIVersion >= Build.VERSION_CODES.KITKAT){

            flags = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;

            getWindow().getDecorView().setSystemUiVisibility(flags);


        } else {

            flags = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

            getWindow().getDecorView().setSystemUiVisibility(flags);

        }

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // TODO: Collegare le ImageView sfruttando il loro ID
        ImageView mStrE = (ImageView) findViewById(R.id.stringE);
        mStrE.setOnTouchListener(this);
        ImageView mStrA = (ImageView) findViewById(R.id.stringA);
        mStrA.setOnTouchListener(this);
        ImageView mStrD = (ImageView) findViewById(R.id.stringD);
        mStrD.setOnTouchListener(this);
        ImageView mStrG = (ImageView) findViewById(R.id.stringG);
        mStrG.setOnTouchListener(this);
        ImageView mStrB = (ImageView) findViewById(R.id.stringB);
        mStrB.setOnTouchListener(this);
        ImageView mStre6 = (ImageView) findViewById(R.id.stringe);
        mStre6.setOnTouchListener(this);
        // TODO: Gestione del costruttore SoundPool che è un API deprecata dalla versione API 21
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            mStringsSound = new SoundPool.Builder().setAudioAttributes(audioAttrib).setMaxStreams(NR_OF_SIMULTANEOUS_SOUND).build();




        } else {

            mStringsSound = new SoundPool(NR_OF_SIMULTANEOUS_SOUND, AudioManager.STREAM_MUSIC,0);
        }



        // TODO: Caricare i suoni

        mSE = mStringsSound.load(getApplicationContext(),R.raw.note6_e,1);
        mSA = mStringsSound.load(getApplicationContext(),R.raw.note5_a,1);
        mSD = mStringsSound.load(getApplicationContext(),R.raw.note4_d,1);
        mSG = mStringsSound.load(getApplicationContext(),R.raw.note3_g,1);
        mSB = mStringsSound.load(getApplicationContext(),R.raw.note2_b,1);
        mSe6 = mStringsSound.load(getApplicationContext(),R.raw.note1_e,1);



    }



    // TODO: facoltativo Ascoltare l'evento click, commentando le parti relative alla gestion dell'evento touch per capire la differenza


    // TODO: Aggiungere il metodo per la gestione dell'evento touch sulle corde

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(v.getId()){

            case R.id.stringE:
                Log.d("Chitarra","corda toccata MI basso");
                //TODO: Emetti suono
                mStringsSound.play(mSE,1.0f,1.0f,0,0,1.0f);
                break;
            case R.id.stringA:
                Log.d("Chitarra","corda toccata LA");
                //TODO: Emetti suono
                mStringsSound.play(mSA,1.0f,1.0f,0,0,1.0f);
                break;
            case R.id.stringD:
                Log.d("Chitarra","corda toccata RE");
                //TODO: Emetti suono
                mStringsSound.play(mSD,1.0f,1.0f,0,0,1.0f);
                break;
            case R.id.stringG:
                Log.d("Chitarra","corda toccata SOL");
                //TODO: Emetti suono
                mStringsSound.play(mSG,1.0f,1.0f,0,0,1.0f);
                break;
            case R.id.stringB:
                Log.d("Chitarra","corda toccata SI");
                //TODO: Emetti suono
                mStringsSound.play(mSB,1.0f,1.0f,0,0,1.0f);
                break;
            case R.id.stringe:
                Log.d("Chitarra","corda toccata MI cantino");
                //TODO: Emetti suono
                mStringsSound.play(mSe6,1.0f,1.0f,0,0,1.0f);
                break;
        }

        return false;
    }

}
