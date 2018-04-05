package com.example.sam.demo;

import android.database.Cursor;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.CheckBox;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Scanner;

public class InputActivity2 extends AppCompatActivity{

    //Declarations
    TextView input2_text;
    EditText taskId_edit;
    TextView daysToComp_text;
    Spinner daysToComp_spin;
    Button btn_next2;
    Spinner monthDead_spin;
    Spinner sub1_spin;
    Spinner sub2_spin;
    Button btn_viewAll;
    Button btn_load;
    Button btn_update;
    EditText id_edit;
    Button btn_delete;


    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input2);
        mydb = new DatabaseHelper(this);

        //Casting
        input2_text = findViewById(R.id.textView_input2);
        taskId_edit = findViewById(R.id.editText_taskId);
        daysToComp_text = findViewById(R.id.textView_daysToComp);
        daysToComp_spin = findViewById(R.id.spinner_daysComp);
        btn_next2 = findViewById(R.id.button_next2);
        monthDead_spin = findViewById(R.id.spinner_deadline_month);
        sub1_spin = findViewById(R.id.spinner_sub1);
        sub2_spin = findViewById(R.id.spinner_sub2);
        btn_viewAll = findViewById(R.id.button_viewAll);
        btn_load = findViewById(R.id.button_load);
        btn_update = findViewById(R.id.button_update);
        id_edit = findViewById(R.id.editText_id);
        btn_delete = findViewById(R.id.button_delete);

        //Spinners
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.dayNums, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daysToComp_spin.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.deadlines, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthDead_spin.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub1_spin.setAdapter(adapter4);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub2_spin.setAdapter(adapter5);

        AddData();
        viewAll();
        Presets();
        updateData();
        deleteData();


    }

    public void viewAll(){
        btn_viewAll.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Cursor res = mydb.getAllData();
                        if (res.getCount() == 0)
                        {
                            //Show Message
                            showMessage("Error", "No data found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext())
                        {
                            buffer.append("id: " + res.getString(0) + "\n");
                            buffer.append("name: " + res.getString(1) + "\n");
                            buffer.append("weeks: " + res.getString(2) + "\n");
                            buffer.append("deadline: " + res.getString(3) + "\n");
                            buffer.append("subj1: " + res.getString(4) + "\n");
                            buffer.append("subj2: " + res.getString(5) + "\n\n");
                        }

                        //Show all data
                        showMessage("Data", buffer.toString());

                    }
                }
        );

    }

    public void showMessage (String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void AddData(){
        btn_next2.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        boolean isInserted = mydb.insertData(taskId_edit.getText().toString(), daysToComp_spin.getSelectedItem().toString(), monthDead_spin.getSelectedItem().toString(), sub1_spin.getSelectedItem().toString(), sub2_spin.getSelectedItem().toString());

                        if(isInserted = true)
                        {
                            Toast.makeText(InputActivity2.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(InputActivity2.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

    public void Presets(){
        btn_load.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //Physics
                        mydb.insertData("PHY1: Lab Activity A", "1 week", "Month 1 Week 3", "GNPHY2", "N/A");
                        mydb.insertData("PHY2: Lab Activity B", "1 week", "Month 2 Week 2", "GNPHY2", "N/A");
                        mydb.insertData("PHY3: Lab Activity C", "1 week", "Month 3 Week 1", "GNPHY2", "N/A");
                        mydb.insertData("PHY4: Lab Activity D", "1 week", "Month 4 Week 1", "GNPHY2", "N/A");
                        //Cledu
                        mydb.insertData("CLE1: Movie Reflection", "1 week", "Month 1 Week 2", "CLEDU4", "N/A");
                        mydb.insertData("CLE2: Roleplay", "2 weeks", "Month 2 Week 2", "CLEDU4", "N/A");
                        mydb.insertData("CLE3: PPT Presentation", "2 weeks", "Month 3 Week 2", "CLEDU4", "N/A");
                        mydb.insertData("CLE4: Quarterly Reflection", "1 week", "Month 4 Week 2", "CLEDU4", "N/A");
                        //Inquir
                        mydb.insertData("INQ1: Research Proposal", "2 weeks", "Month 2 Week 1", "INQUIR", "RECAPP");
                        mydb.insertData("INQ2: Chapter I and II", "2 weeks", "Month 2 Week 3", "INQUIR", "N/A");
                        mydb.insertData("INQ3: Chapter III", "2 weeks", "Month 3 Week 2", "INQUIR", "N/A");
                        mydb.insertData("INQ4: Defense", "3 weeks", "Month 4 Week 2", "INQUIR", "RECAPP");
                        //Medlit
                        mydb.insertData("MED4: Photography", "1 week", "Month 5 Week 1", "MEDLIT", "N/A");
                        //Entrep
                        mydb.insertData("ENT1: Business Proposal", "2 weeks", "Month 1 Week 2", "ENTREP", "N/A");
                        mydb.insertData("ENT2: Presentation A", "1 week", "Month 1 Week 4", "ENTREP", "N/A");
                        mydb.insertData("ENT3: Presentation B", "1 week", "Month 3 Week 1", "ENTREP", "N/A");
                        mydb.insertData("ENT4: Business Execution", "3 weeks", "Month 4 Week 4", "ENTREP", "N/A");
                        //Recapp
                        mydb.insertData("REC2: Journal Entry A", "2 weeks", "Month 2 Week 2", "RECAPP", "N/A");
                        mydb.insertData("REC4: Journal Entry B", "2 weeks", "Month 3 Week 1", "RECAPP", "N/A");
                        //Perdev
                        mydb.insertData("PER1: Talk Show", "3 weeks", "Month 2 Week 2", "PERDEV", "MEDLIT");
                        mydb.insertData("PER2: Video Presentation", "2 weeks", "Month 3 Week 1", "PERDEV", "MEDLIT");
                        mydb.insertData("PER3: Short Film", "4 weeks", "Month 4 Week 1", "PERDEV", "MEDLIT");
                        mydb.insertData("PER3: Attendance for PERDEV", "1 week", "Month 5 Week 5", "PERDEV", "MEDLIT");
                        //PE
                        mydb.insertData("PEH1: Dance A", "2 weeks", "Month 2 Week 3", "PEHLT4", "N/A");
                        mydb.insertData("PEH2: Dance B", "2 weeks", "Month 3 Week 2", "PEHLT4", "N/A");
                        mydb.insertData("PEH3: Dance C", "3 weeks", "Month 4 Week 3", "PEHLT4", "N/A");
                        mydb.insertData("PEH4: Attendance for PE", "1 week", "Month 5 Week 5", "PEHLT4", "N/A");
                        //Toast
                        Toast.makeText(InputActivity2.this, "Presets loaded", Toast.LENGTH_LONG).show();

                    }
                }
        );

        }

    public void updateData(){
        btn_update.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        boolean isUpdated = mydb.updateData(id_edit.getText().toString(), taskId_edit.getText().toString(), daysToComp_spin.getSelectedItem().toString(), monthDead_spin.getSelectedItem().toString(), sub1_spin.getSelectedItem().toString(), sub2_spin.getSelectedItem().toString());

                        if (isUpdated == true)
                        {
                            Toast.makeText(InputActivity2.this, "Data Updated", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(InputActivity2.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void deleteData(){
        btn_delete.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Integer deletedRows = mydb.deleteData(id_edit.getText().toString());
                        if (deletedRows > 0)
                        {
                            Toast.makeText(InputActivity2.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(InputActivity2.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    }




