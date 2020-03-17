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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user54.InventoryApp.Model.Password;
import com.example.user54.InventoryApp.R;

import java.util.ArrayList;

public class Tools2 extends AppCompatActivity {
    Button main, home, pSetting, changePassword, sendServer, receiveServer,
            item, tools, report, exit, exitAll2, setting, collecting;
    Dialog dialog;
    LinearLayout menue;
    InventoryDatabase InventDB;
    ArrayList<Password> passImport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_menu);

        InventDB = new InventoryDatabase(Tools2.this);
        passImport = new ArrayList<>();
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


    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.collec:
                    Intent coll = new Intent(Tools2.this, CollectingData.class);
                    startActivity(coll);
                    finish();
                    break;
                case R.id.items:
                    Intent item = new Intent(Tools2.this, Item.class);
                    startActivity(item);
                    finish();
                    break;
                case R.id.report:
                    Intent report = new Intent(Tools2.this, Report.class);
                    startActivity(report);
                    finish();
                    break;
                case R.id.setting:

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

                case R.id.password:
                    showChangePasswordDialog();
                    break;
                case R.id.pSetting:
                    showPrintSettingDialog();
                    break;
                case R.id.sendSer:
                    showSendToServerDialog();
                    break;
                case R.id.reciveSer:
                    showReceiveFromServerDialog();
                    break;
            }
        }
    };


    void alertMessageDialog(String title, String message, final int swith, final String itemName, final String ItemCode) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Tools2.this);
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


    void showChangePasswordDialog() {
        dialog = new Dialog(Tools2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.change_password);
        dialog.setCanceledOnTouchOutside(false);


        Button exit, update, reset;
        final EditText oldPass, newPass;

        oldPass = (EditText) dialog.findViewById(R.id.oldPass);
        newPass = (EditText) dialog.findViewById(R.id.newPass);

        exit = (Button) dialog.findViewById(R.id.exit);
        update = (Button) dialog.findViewById(R.id.updaCh);
        reset = (Button) dialog.findViewById(R.id.reset);

        final boolean[] passFound = {false};
        final boolean[] passFoundNew = {false};

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passFound[0] = false;
                passFoundNew[0]=false;
                passImport = InventDB.getAllPassword();

                if (!oldPass.getText().toString().equals("") && !newPass.getText().toString().equals("")) {

                    for (int i = 0; i < passImport.size(); i++) {
                        if (oldPass.getText().toString().equals(passImport.get(i).getPasswords())) {

                            passFound[0] = true;
                            break;
                        }
                        }


                    for (int x = 0; x < passImport.size(); x++) {

                        if(newPass.getText().toString().equals(passImport.get(x).getPasswords())){

                            passFoundNew[0]=true;
                            break;

                        }

                    }

                    if (passFound[0]&&!passFoundNew[0]) {

                        InventDB.updatePasswordTable(newPass.getText().toString(), "0", oldPass.getText().toString());
                        Toast.makeText(Tools2.this, "Update Successful ", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(Tools2.this, " old password or new  password not correct ", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(Tools2.this, "Please insert all data ", Toast.LENGTH_SHORT).show();
                }

            }
        });


        dialog.show();
    }


    void showPrintSettingDialog() {
        dialog = new Dialog(Tools2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_collecting_data);
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


    void showSendToServerDialog() {
        dialog = new Dialog(Tools2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_collecting_data);
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


    void showReceiveFromServerDialog() {
        dialog = new Dialog(Tools2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_collecting_data);
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

        pSetting.setClickable(false);
        changePassword.setClickable(false);
        sendServer.setClickable(false);
        receiveServer.setClickable(false);

    }

    public void Clickable() {

        pSetting.setClickable(true);
        changePassword.setClickable(true);
        sendServer.setClickable(true);
        receiveServer.setClickable(true);

    }

    void initialization() {

//        date = (TextView) findViewById(R.id.date);
//        UserName=(TextView) findViewById(R.id.userName1);

//        main = (Button) findViewById(R.id.mainB);
//        main2 = (Button) findViewById(R.id.mainB2);
//        collectButton = (Button) findViewById(R.id.coll);
//        item = (Button) findViewById(R.id.item);
//        tools = (Button) findViewById(R.id.tools);
//        report = (Button) findViewById(R.id.report);
//        ExitAll = (Button) findViewById(R.id.exitALL);
//        exit = (Button) findViewById(R.id.exit2);


        exitAll2 = (Button) findViewById(R.id.exit2);
        item = (Button) findViewById(R.id.items);
        setting = (Button) findViewById(R.id.setting);
        report = (Button) findViewById(R.id.report);

        menue = (LinearLayout) findViewById(R.id.main);
        exit = (Button) findViewById(R.id.exi);
        collecting = (Button) findViewById(R.id.collec);

        collecting.setOnClickListener(mainMenu);
        exitAll2.setOnClickListener(mainMenu);
        item.setOnClickListener(mainMenu);
        setting.setOnClickListener(mainMenu);
        report.setOnClickListener(mainMenu);

        home = (Button) findViewById(R.id.home);
        main = (Button) findViewById(R.id.men2);


        pSetting = (Button) findViewById(R.id.pSetting);
        changePassword = (Button) findViewById(R.id.password);
        sendServer = (Button) findViewById(R.id.sendSer);
        receiveServer = (Button) findViewById(R.id.reciveSer);


        pSetting.setOnClickListener(showDialogOnClick);
        changePassword.setOnClickListener(showDialogOnClick);
        sendServer.setOnClickListener(showDialogOnClick);
        receiveServer.setOnClickListener(showDialogOnClick);

        Clickable();


    }


}
