package id.ac.polinema.utsandroid.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.polinema.utsandroid.R;
import id.ac.polinema.utsandroid.util.HasilKuis;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Presiden Indonesia yang keenam adalah",
            "2. Lambang Negara Indonesia adalah",
            "3. Ibukota Indonesia adalah",
            "4. Lagu Kebangsaan Indonesia adalah",
            "5. Bendera Negara Indonesia adalah"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Soekarno", "Habibie", "Susilo Bambang Yudhoyono", "Joko Widodo",
            "Gajah Putih", "Garuda", "Macan", "Elang",
            "Jakarta", "Bogor", "Tangerang", "Bekasi",
            "Indonesia Raya", "Tanah Airku", "Indonesia Pusaka", "Indonesia Merdeka",
            "Merah Biru Putih", "Merah Putih", "Putih Merah", "Belang-belang"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "Susilo Bambang Yudhoyono",
            "Garuda",
            "Jakarta",
            "Indonesia Raya",
            "Merah Putih"
    };

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        pertanyaan = (TextView) view.findViewById(R.id.pertanyaan);
        rg = (RadioGroup) view.findViewById(R.id.radio_group);
        PilihanA = (RadioButton) view.findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) view.findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) view.findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) view.findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;

        Button next = view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PilihanA.isChecked()||PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()) {
                    RadioButton jawaban_user = (RadioButton) getActivity().findViewById(rg.getCheckedRadioButtonId());
                    String ambil_jawaban_user = jawaban_user.getText().toString();
                    rg.check(0);
                    if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
                    else salah++;
                    nomor++;
                    if (nomor < pertanyaan_kuis.length) {
                        pertanyaan.setText(pertanyaan_kuis[nomor]);
                        PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                        PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                        PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                        PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
                    } else {
                        hasil = benar * 20;
                        Intent selesai = new Intent(getActivity().getApplicationContext(), HasilKuis.class);
                        startActivity(selesai);
                    }
                }
                else{
                    Toast.makeText(getContext(), "Pilih Jawaban Dulu", Toast.LENGTH_SHORT).show();
                }
            }

        });return view;
    }
}
