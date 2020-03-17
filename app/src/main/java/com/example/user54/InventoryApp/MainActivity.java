package com.example.user54.InventoryApp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user54.InventoryApp.R;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button men, exit, collecting, exitAll, exitAll2, item, setting, report,
             upM,  upN, yourNote;
    LinearLayout menue;
    TextView UserName, date;
TableLayout tabMessage,tabNote;
    boolean upMB = false, upNB = false;
    TableRow row;
    boolean isYellow=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        UserName = (TextView) findViewById(R.id.userName1);
        date = (TextView) findViewById(R.id.date);
        exitAll = (Button) findViewById(R.id.exitAll);
        exitAll2 = (Button) findViewById(R.id.exit2);
        item = (Button) findViewById(R.id.items);
        setting = (Button) findViewById(R.id.setting);
        yourNote=(Button)findViewById(R.id.note);
        report = (Button) findViewById(R.id.report);
        upM = (Button) findViewById(R.id.up1);
        upN = (Button) findViewById(R.id.up2);
        tabMessage=(TableLayout) findViewById(R.id.tab1);
        tabNote=(TableLayout) findViewById(R.id.tab2);

        initBmb(R.id.bmb1);
        Date currentTimeAndDate = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String today = df.format(currentTimeAndDate);
        date.setText(today);

        String userNames = getIntent().getStringExtra("USER_NAME");



        UserName.setText(userNames);


        men = (Button) findViewById(R.id.men);
        menue = (LinearLayout) findViewById(R.id.main);
        exit = (Button) findViewById(R.id.textView4);
        collecting = (Button) findViewById(R.id.collec);

        collecting.setOnClickListener(mainMenu);
        exitAll2.setOnClickListener(mainMenu);
        item.setOnClickListener(mainMenu);
        setting.setOnClickListener(mainMenu);
        report.setOnClickListener(mainMenu);

        upM.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                if(upMB){
                    upM.setBackground(getResources().getDrawable(R.drawable.arrowup));

                    String message ="name 123DialogInterface.OnClickListener( mesaage" +
                            " ";
                    for(int i=0;i<10;i++){
                    addList(tabMessage, message);}

                    upMB=false;


                }else{
                    upM.setBackground(getResources().getDrawable(R.drawable.arrowdown));
                    tabMessage.removeAllViews();

                    upMB=true;
                }

            }
        });


        upN.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                if(upNB){
                    upN.setBackground(getResources().getDrawable(R.drawable.arrowup));

                    String message ="name 123 DialogInterface.OnClickListener( ";
                    for(int i=0;i<10;i++){
                        addList(tabNote, message);}

                    upNB=false;


                }else{
                    upN.setBackground(getResources().getDrawable(R.drawable.arrowdown));
                    tabNote.removeAllViews();

                    upNB=true;
                }

            }
        });


        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menue.setVisibility(View.VISIBLE);
                exit.setVisibility(View.VISIBLE);
                men.setVisibility(View.INVISIBLE);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menue.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.INVISIBLE);
                men.setVisibility(View.VISIBLE);
            }
        });

        exitAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessageDialog(getResources().getString(R.string.exitfromapp), getResources().getString(R.string.exitMessage), 0, "", "");
            }
        });


        yourNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddNoteDialog();

            }
        });


    }



    void AddNoteDialog(){
        final Dialog dialogNew = new Dialog(MainActivity.this);
        dialogNew.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogNew.setCancelable(false);
        dialogNew.setContentView(R.layout.note_dialog);
        dialogNew.setCanceledOnTouchOutside(true);


        Button ok ,not_Ok;
        final EditText noteEdit;

        noteEdit=(EditText)dialogNew.findViewById(R.id.noteM) ;

        ok =(Button)dialogNew.findViewById(R.id.ok) ;
        not_Ok=(Button)dialogNew.findViewById(R.id.deny);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!noteEdit.getText().toString().equals("")){

                    addList(tabNote, noteEdit.getText().toString());

                    dialogNew.dismiss();

                }else {
                    Toast.makeText(MainActivity.this, "Don't have Any note please add note or exit ... ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        not_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogNew.dismiss();
            }
        });

        dialogNew.show();

    }


   void addList(TableLayout recipeTable,String message){

       row = new TableRow(MainActivity.this);
       TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
       row.setLayoutParams(lp);
       row.setPadding(5, 10, 5, 5);

       final CheckBox textView = new CheckBox(MainActivity.this);
       textView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
       TableRow.LayoutParams lp2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

       textView.setLayoutParams(lp2);
       textView.setText(message);
       row.addView(textView);
       recipeTable.addView(row);

    }

    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.collec:
                    Intent coll = new Intent(MainActivity.this, CollectingData.class);
                    startActivity(coll);

                    break;
                case R.id.items:
                    Intent item = new Intent(MainActivity.this, Item.class);
                    startActivity(item);
                    break;
                case R.id.report:
                    Intent report = new Intent(MainActivity.this, Report.class);
                    startActivity(report);
                    break;
                case R.id.setting:
                    Intent tools = new Intent(MainActivity.this, Tools.class);
                    startActivity(tools);
                    break;
//                case R.id.:
//                    Intent coll = new Intent(MainActivity.this, CllectingData.class);
//                    startActivity(coll);
//                    break;
                case R.id.exit2:
                    alertMessageDialog( getResources().getString(R.string.exitfromapp),  getResources().getString(R.string.exitMessage), 0, "", "");
                    break;
            }

            menue.setVisibility(View.INVISIBLE);
            exit.setVisibility(View.INVISIBLE);
            men.setVisibility(View.VISIBLE);

        }
    };


    void alertMessageDialog(String title, String message, final int swith, final String itemName, final String ItemCode) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle(title)
                .setMessage(message)
                .setNegativeButton( getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }
                })
                .setPositiveButton( getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        switch (swith) {
                            case 0:
                                finish();
                                System.exit(0);
                                break;
                            case 1:

                                Toast.makeText(MainActivity.this,  getResources().getString(R.string.delete_all_item), Toast.LENGTH_SHORT).show();
//                             progressDialog();
                                break;
                            case 2:
                                break;

                        }
                    }
                }).show();
    }


    private BoomMenuButton initBmb(int res) {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(res);
        assert bmb != null;
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
            bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());

        bmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {

                switch (index){
                    case 0:
                        Intent coll = new Intent(MainActivity.this, CollectingData.class);
                        startActivity(coll);
                        break;
                    case 1:
                        Intent item = new Intent(MainActivity.this, Item.class);
                        startActivity(item);

                        break;
                    case 2:
                        Intent report = new Intent(MainActivity.this, Report.class);
                        startActivity(report);
                        break;
                    case 3:
                        Intent tools = new Intent(MainActivity.this, Tools.class);
                        startActivity(tools);
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "index"+index, Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        alertMessageDialog("Exit From App ...", "you are sorry you want to Exit From App ?", 0, "", "");
                        break;

                }


            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

            }
        });
        return bmb;
    }




}
