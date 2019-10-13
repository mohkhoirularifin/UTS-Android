package id.ac.polinema.utsandroid.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.ac.polinema.utsandroid.R;
import id.ac.polinema.utsandroid.activities.MainActivity;
import id.ac.polinema.utsandroid.fragment.QuizFragment;

public class HasilKuis extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView hasil = findViewById(R.id.hasil);
        TextView nilai = findViewById(R.id.nilai);

        hasil.setText("Zimzalabim, Jawaban Benar :"+ QuizFragment.benar+"\nJawaban Salah :"+QuizFragment.salah);
        nilai.setText(""+QuizFragment.hasil);
    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(a);
    }
}