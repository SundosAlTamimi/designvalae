package com.example.user54.InventoryApp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.user54.InventoryApp.R;

public class Report2 extends AppCompatActivity {

    Button main, home,exportText, ExportTransfer, exportExpDate, ExportAlternative,
            item, tools, report,exit,exitAll2,setting,collecting;

    Dialog dialog;

    String today;
    InventoryDatabase InventDB;
    LinearLayout menue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_menu);

        initialization();

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menue.setVisibility(View.VISIBLE);
                exit.setVisibility(View.VISIBLE);
                main.setVisibility(View.INVISIBLE);
                home.setVisibility(View.INVISIBLE);
                notClickable();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menue.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.INVISIBLE);
                main.setVisibility(View.VISIBLE);
                home.setVisibility(View.VISIBLE);
                Clickable();
            }
        });



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                           }
        });


    }


    View.OnClickListener mainMenu =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.collec:
                    Intent coll = new Intent( Report2.this,  CollectingData.class);
                    startActivity(coll);
                    finish();
                    break;
                case R.id.items:
                    Intent item = new Intent( Report2.this, Item.class);
                    startActivity(item);
                    finish();
                    break;
                case R.id.report:

                    break;
                case R.id.setting:
                    Intent tools = new Intent( Report2.this, Tools.class);
                    startActivity(tools);
                    finish();
                    break;
//                case R.id.:
//                    Intent coll = new Intent(MainActivity.this, CllectingData.class);
//                    startActivity(coll);
//                    break;
                case R.id.exit2:
                    alertMessageDialog("Exit From App ...", "you are sorry you want to Exit From App ?", 0, "", "");
                    break;
            }

            menue.setVisibility(View.INVISIBLE);
            exit.setVisibility(View.INVISIBLE);
            main.setVisibility(View.VISIBLE);
            home.setVisibility(View.VISIBLE);

        }
    };



    View.OnClickListener showDialogOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.expText:
                    showExportToTextDialog();
                    break;
                case R.id.expTransfer:
                    showExportTransferItemDialog();
                    break;
                case R.id.expExp:
                    showExportItemDataByExpiryDateDialog();
                    break;
                case R.id.expAlternative:
                    showExportAlternativeCodeDialog();
                    break;
            }
        }
    };


    void alertMessageDialog(String title, String message, final int swith, final String itemName , final String ItemCode) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Report2.this);
        dialog.setTitle(title)
                .setMessage(message)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        switch (swith) {
                            case 0:
                                finish();
                                moveTaskToBack(true);

                                break;
//                            case 1:
//                                InventDB.deleteAllItem("ITEM_CARD");
//                                Toast.makeText(CollectingData.this, "All Item Delete ", Toast.LENGTH_SHORT).show();
////                             progressDialog();
//                                break;
//                            case 2:
//                                InventDB.delete(ItemCode,itemName);
//                                break;

                        }
                    }
                }).show();
    }

    void showExportToTextDialog() {
        dialog = new Dialog(Report2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.export_item_data_to_text);
        dialog.setCanceledOnTouchOutside(false);

        Button exit;

        exit = (Button) dialog.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    void showExportTransferItemDialog() {
        dialog = new Dialog(Report2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.export_transfer_item_data);
        dialog.setCanceledOnTouchOutside(false);

        Button exit;

        exit = (Button) dialog.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    void showExportItemDataByExpiryDateDialog() {
        dialog = new Dialog(Report2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.export_item_data_by_expiry);
        dialog.setCanceledOnTouchOutside(false);

        Button exit;

        exit = (Button) dialog.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    void showExportAlternativeCodeDialog() {
        dialog = new Dialog(Report2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.export_alternatev_code);
        dialog.setCanceledOnTouchOutside(false);

        Button exit;

        exit = (Button) dialog.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }




    public void notClickable() {
        exportText.setClickable(false);
        ExportTransfer.setClickable(false);
        exportExpDate.setClickable(false);
        ExportAlternative.setClickable(false);
    }


    public void Clickable() {

        exportText.setClickable(true);
        ExportTransfer.setClickable(true);
        exportExpDate.setClickable(true);
        ExportAlternative.setClickable(true);
    }

    void initialization() {

        exitAll2 = (Button) findViewById(R.id.exit2);
        item= (Button) findViewById(R.id.items);
        setting= (Button) findViewById(R.id.setting);

        report= (Button) findViewById(R.id.report);

        menue = (LinearLayout) findViewById(R.id.main);
        exit = (Button) findViewById(R.id.exi);
        collecting = (Button) findViewById(R.id.collec);

        collecting.setOnClickListener(mainMenu);
        exitAll2.setOnClickListener(mainMenu);
        item.setOnClickListener(mainMenu);
        setting.setOnClickListener(mainMenu);
        report.setOnClickListener(mainMenu);


        home =(Button)findViewById(R.id.home);
        main=(Button)findViewById(R.id.men2);


        exportText = (Button) findViewById(R.id.expText);
        ExportTransfer = (Button) findViewById(R.id.expTransfer);
        exportExpDate = (Button) findViewById(R.id.expExp);
        ExportAlternative = (Button) findViewById(R.id.expAlternative);

        exportText.setOnClickListener(showDialogOnClick);
        ExportTransfer.setOnClickListener(showDialogOnClick);
        exportExpDate.setOnClickListener(showDialogOnClick);
        ExportAlternative.setOnClickListener(showDialogOnClick);

         Clickable();

    }



}
