package com.example.sam.demo;

import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.CheckBox;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import java.util.Scanner;

import static java.lang.System.in;

public class InputActivity extends AppCompatActivity implements View.OnClickListener{

    //PublicStaticFinal
    public static final String extra_masterString = "com.example.sam.demo.extra_masterString";

    //Declarations
    TextView strand_text;
    TextView subjects_text;
    TextView errorBox_text;

    CheckBox check_stem;
    CheckBox check_abm;
    CheckBox check_humss;
    CheckBox check_gas;

    CheckBox check_phy;
    CheckBox check_cle;
    CheckBox check_inq;
    CheckBox check_med;
    CheckBox check_ent;
    CheckBox check_rec;
    CheckBox check_per;
    CheckBox check_peh;

    Button btn_next;

    String masterString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        //Linking
        strand_text = findViewById(R.id.textView_strand);
        subjects_text = findViewById(R.id.textView_subjects);
        errorBox_text = findViewById(R.id.textView_errorBox);

        check_stem = findViewById(R.id.checkBoxStem);
        check_abm = findViewById(R.id.checkBoxAbm);
        check_humss = findViewById(R.id.checkBoxHumss);
        check_gas = findViewById(R.id.checkBoxGas);

        check_phy = findViewById(R.id.checkBoxSubPhy);
        check_cle = findViewById(R.id.checkBoxSubCle);
        check_inq = findViewById(R.id.checkBoxSubInq);
        check_med = findViewById(R.id.checkBoxSubMed);
        check_ent = findViewById(R.id.checkBoxSubEnt);
        check_rec = findViewById(R.id.checkBoxSubRec);
        check_per = findViewById(R.id.checkBoxSubPer);
        check_peh = findViewById(R.id.checkBoxSubPeh);

        btn_next = findViewById(R.id.button_next);

        //OnClickListeners
        btn_next.setOnClickListener(this);


    }


    @Override
    public void onClick(View view)
    {

        Scanner scanChar;
        scanChar = new Scanner(System.in);

        //Declaration of boolean if checked
        boolean checked = ((CheckBox)view).isChecked();

        switch(view.getId())
        {
            //Strand Boxes
            case R.id.checkBoxStem:
                if (checked)
                {
                    StringBuilder sbStem = new StringBuilder(masterString);
                    sbStem.setCharAt(1, 'a');
                    masterString = sbStem.toString();
                }
                else
                {
                    StringBuilder sbStem = new StringBuilder(masterString);
                    sbStem.setCharAt(1, 'z');
                    masterString = sbStem.toString();
                }
                break;

            case R.id.checkBoxAbm:
                if (checked)
                {
                    StringBuilder sbAbm = new StringBuilder(masterString);
                    sbAbm.setCharAt(2, 'a');
                    masterString = sbAbm.toString();
                }
                else
                {
                    StringBuilder sbAbm = new StringBuilder(masterString);
                    sbAbm.setCharAt(2, 'z');
                    masterString = sbAbm.toString();
                }
                break;

            case R.id.checkBoxHumss:
                if (checked)
                {
                    StringBuilder sbHumss = new StringBuilder(masterString);
                    sbHumss.setCharAt(3, 'a');
                    masterString = sbHumss.toString();
                }
                else
                {
                    StringBuilder sbHumss = new StringBuilder(masterString);
                    sbHumss.setCharAt(3, 'z');
                    masterString = sbHumss.toString();
                }
                break;

            case R.id.checkBoxGas:
                if (checked)
                {
                    StringBuilder sbGas = new StringBuilder(masterString);
                    sbGas.setCharAt(4, 'a');
                    masterString = sbGas.toString();
                }
                else
                {
                    StringBuilder sbGas = new StringBuilder(masterString);
                    sbGas.setCharAt(4, 'z');
                    masterString = sbGas.toString();
                }
                break;

            //Subject Boxes
            case R.id.checkBoxSubPhy:
                if (checked)
                {
                    StringBuilder sbSubPhy = new StringBuilder(masterString);
                    sbSubPhy.setCharAt(5, 'a');
                    masterString = sbSubPhy.toString();
                }
                else
                {
                    StringBuilder sbSubPhy = new StringBuilder(masterString);
                    sbSubPhy.setCharAt(5, 'z');
                    masterString = sbSubPhy.toString();
                }
                break;

            case R.id.checkBoxSubCle:
                if (checked)
                {
                    StringBuilder sbSubCle = new StringBuilder(masterString);
                    sbSubCle.setCharAt(6, 'a');
                    masterString = sbSubCle.toString();
                }
                else
                {
                    StringBuilder sbSubCle = new StringBuilder(masterString);
                    sbSubCle.setCharAt(6, 'z');
                    masterString = sbSubCle.toString();
                }
                break;

            case R.id.checkBoxSubInq:
                if (checked)
                {
                    StringBuilder sbSubInq = new StringBuilder(masterString);
                    sbSubInq.setCharAt(7, 'a');
                    masterString = sbSubInq.toString();
                }
                else
                {
                    StringBuilder sbSubInq = new StringBuilder(masterString);
                    sbSubInq.setCharAt(7, 'z');
                    masterString = sbSubInq.toString();
                }
                break;

            case R.id.checkBoxSubMed:
                if (checked)
                {
                    StringBuilder sbSubMed = new StringBuilder(masterString);
                    sbSubMed.setCharAt(8, 'a');
                    masterString = sbSubMed.toString();
                }
                else
                {
                    StringBuilder sbSubMed = new StringBuilder(masterString);
                    sbSubMed.setCharAt(8, 'z');
                    masterString = sbSubMed.toString();
                }
                break;

            case R.id.checkBoxSubEnt:
                if (checked)
                {
                    StringBuilder sbSubEnt = new StringBuilder(masterString);
                    sbSubEnt.setCharAt(9, 'a');
                    masterString = sbSubEnt.toString();
                }
                else
                {
                    StringBuilder sbSubEnt = new StringBuilder(masterString);
                    sbSubEnt.setCharAt(9, 'z');
                    masterString = sbSubEnt.toString();
                }
                break;

            case R.id.checkBoxSubRec:
                if (checked)
                {
                    StringBuilder sbSubRec = new StringBuilder(masterString);
                    sbSubRec.setCharAt(10, 'a');
                    masterString = sbSubRec.toString();
                }
                else
                {
                    StringBuilder sbSubRec = new StringBuilder(masterString);
                    sbSubRec.setCharAt(10, 'z');
                    masterString = sbSubRec.toString();
                }
                break;

            case R.id.checkBoxSubPer:
                if (checked)
                {
                    StringBuilder sbSubPer = new StringBuilder(masterString);
                    sbSubPer.setCharAt(11, 'a');
                    masterString = sbSubPer.toString();
                }
                else
                {
                    StringBuilder sbSubPer = new StringBuilder(masterString);
                    sbSubPer.setCharAt(11, 'z');
                    masterString = sbSubPer.toString();
                }
                break;

            case R.id.checkBoxSubPeh:
                if (checked)
                {
                    StringBuilder sbSubPeh = new StringBuilder(masterString);
                    sbSubPeh.setCharAt(12, 'a');
                    masterString = sbSubPeh.toString();
                }
                else
                {
                    StringBuilder sbSubPeh = new StringBuilder(masterString);
                    sbSubPeh.setCharAt(12, 'z');
                    masterString = sbSubPeh.toString();
                }
                break;


        }


        //if (view.getId()==R.id.button_next)
        //{
            //if (ms1=='z' && ms2=='z' && ms3=='z' && ms4=='z')
            //{
            //    errorBox_text.setText(R.string.errorBox);
            //}
            //else if (ms5=='z' && ms6=='z' && ms7=='z' && ms8=='z' && ms9=='z' && ms10=='z' && ms11=='z' && ms12=='z')
            //{
            //    errorBox_text.setText(R.string.errorBox);
            //}
            //else if(ms1=='z' && ms2=='z' && ms3=='z' && ms4=='z' && ms5=='z' && ms6=='z' && ms7=='z' && ms8=='z' && ms9=='z' && ms10=='z' && ms11=='z' && ms12=='z')
            //{
            //    errorBox_text.setText(R.string.errorBox);
            //}
            //else
            //{
            //    String text_masterString = masterString;

            //    Intent intent = new Intent (this, InputActivity2.class);
            //    intent.putExtra("stemChecked", check_stem.isChecked());
            //    intent.putExtra("abmChecked", check_abm.isChecked());
            //    intent.putExtra("humssChecked", check_humss.isChecked());
            //   intent.putExtra("gasChecked", check_gas.isChecked());
            //    intent.putExtra("subPhyChecked", check_phy.isChecked());
            //    intent.putExtra("subCleChecked", check_cle.isChecked());
            //    intent.putExtra("subInqChecked", check_inq.isChecked());
            //    intent.putExtra("subMedChecked", check_med.isChecked());
            //    intent.putExtra("subEntChecked", check_ent.isChecked());
            //    intent.putExtra("subRecChecked", check_rec.isChecked());
            //    intent.putExtra("subPerChecked", check_per.isChecked());
            //    intent.putExtra("subPehChecked", check_peh.isChecked());

            //    startActivity(intent);

            //}


        }

    }

