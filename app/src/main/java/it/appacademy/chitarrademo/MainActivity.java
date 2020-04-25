package it.appacademy.chitarrademo;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

//TODO implementare l'interfaccia View.OnTouchListener
public class MainActivity extends AppCompatActivity {


    // Costanti
    private final int NR_OF_SIMULTANEOUS_SOUND = 6;

    // TODO: Aggiungere member variables




    @SuppressLint("SourceLockedOrientationActivity")
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
        ImageView iwstringE = (ImageView) findViewById(R.id.stringE);
        ImageView iwstringA = (ImageView) findViewById(R.id.stringA);
        ImageView iwstringD = (ImageView) findViewById(R.id.stringD);
        ImageView iwstringB = (ImageView) findViewById(R.id.stringB);
        ImageView iwstringG = (ImageView) findViewById(R.id.stringG);
        ImageView iwstringe = (ImageView) findViewById(R.id.stringe);

        // TODO: Gestione del costruttore SoundPool che è un API deprecata dalla versione API 21


        // TODO: Caricare i suoni



    }

    // TODO: facoltativo Ascoltare l'evento click, commentando le parti relative alla gestion dell'evento touch per capire la differenza


    // TODO: Aggiungere il metodo per la gestione dell'evento touch sulle corde

}
