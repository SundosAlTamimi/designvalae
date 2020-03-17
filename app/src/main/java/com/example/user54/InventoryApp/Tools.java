package com.example.user54.InventoryApp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user54.InventoryApp.Model.ItemInfo;
import com.example.user54.InventoryApp.Model.MainSetting;
import com.example.user54.InventoryApp.Model.Password;
import com.example.user54.InventoryApp.Model.Stk;
import com.example.user54.InventoryApp.Model.TransferItemsInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Tools extends AppCompatActivity {
    //    LinearLayout   pSetting, changePassword, sendServer, receiveServer;
    LinearLayout sendServer, mainSetting;

    Dialog dialog;

    InventoryDatabase InventDB;
    ArrayList<Password> passImport;
    TextView home;
    Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(controll.isYellow){
        setContentView(R.layout.tools_yellow);
//        }else{
//            setContentView(R.layout.tools_menu2);
//        }


        InventDB = new InventoryDatabase(Tools.this);
        passImport = new ArrayList<>();
        initialization();


        animFadein = AnimationUtils.loadAnimation(Tools.this, R.anim.fade_in);
//        pSetting.startAnimation(animFadein);
//        changePassword.startAnimation(animFadein);
        sendServer.startAnimation(animFadein);
        mainSetting.startAnimation(animFadein);
//        receiveServer.startAnimation(animFadein);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    View.OnClickListener showDialogOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

//                case R.id.password:
//                    showChangePasswordDialog();
//                    break;
//                case R.id.pSetting:
//                    showPrintSettingDialog();
//                    break;
                case R.id.sendSer:
//                    importJson sendCloud = new importJson(Tools.this,"");
//                    sendCloud.startSending("GetStory");
                        List<MainSetting> mainSetting=InventDB.getAllMainSetting();
                    if(mainSetting.size()!=0) {

                        List<ItemInfo> itemInfos = InventDB.getAllItemInfo();
                        List<TransferItemsInfo> itemTransInfos = InventDB.getAllTransferItemInfo();
                        sendToServer(itemInfos,itemTransInfos);
                    }else{

                        new SweetAlertDialog(Tools.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText(getResources().getString(R.string.mainSetting) + "!")
                                .setContentText(getResources().getString(R.string.nomainSetting))
                                .setConfirmText(getResources().getString(R.string.cancel))
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null).show();


                    }



//                    showSendToServerDialog();
                    break;
//                case R.id.reciveSer:
//                    showReceiveFromServerDialog();
//                    break;
                case R.id.mainSetting:
                    showReceiveFromServerDialog();
                    break;

            }
        }
    };


    void alertMessageDialog(String title, String message, final int swith, final String itemName, final String ItemCode) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Tools.this);
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
        dialog = new Dialog(Tools.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        if (controll.isYellow) {
            dialog.setContentView(R.layout.change_password_yellow1);
        } else {
            dialog.setContentView(R.layout.change_password);
        }

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
                passFoundNew[0] = false;
                passImport = InventDB.getAllPassword();

                if (!oldPass.getText().toString().equals("") && !newPass.getText().toString().equals("")) {

                    for (int i = 0; i < passImport.size(); i++) {
                        if (oldPass.getText().toString().equals(passImport.get(i).getPasswords())) {

                            passFound[0] = true;
                            break;
                        }
                    }


                    for (int x = 0; x < passImport.size(); x++) {

                        if (newPass.getText().toString().equals(passImport.get(x).getPasswords())) {

                            passFoundNew[0] = true;
                            break;

                        }

                    }

                    if (passFound[0] && !passFoundNew[0]) {

                        InventDB.updatePasswordTable(newPass.getText().toString(), "0", oldPass.getText().toString());
//                        Toast.makeText(Tools.this, getResources().getString(R.string.upsucess), Toast.LENGTH_SHORT).show();
                        TostMesage(getResources().getString(R.string.upsucess));
                    } else {

//                        Toast.makeText(Tools.this,  getResources().getString(R.string.oldornewnotcorect), Toast.LENGTH_SHORT).show();
                        TostMesage(getResources().getString(R.string.oldornewnotcorect));
                    }

                } else {
//                    Toast.makeText(Tools.this,  getResources().getString(R.string.insertData), Toast.LENGTH_SHORT).show();
                    TostMesage(getResources().getString(R.string.insertData));
                }

            }
        });


        dialog.show();
    }


    void showPrintSettingDialog() {
        dialog = new Dialog(Tools.this);
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
        dialog = new Dialog(Tools.this);
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
        final Dialog MainSettingdialog = new Dialog(Tools.this, R.style.Theme_Dialog);
        MainSettingdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MainSettingdialog.setCancelable(false);
        MainSettingdialog.setContentView(R.layout.main_setting_dialog_new);
        MainSettingdialog.setCanceledOnTouchOutside(false);

        LinearLayout exit, save;

        final TextView StoreName = MainSettingdialog.findViewById(R.id.StoreName);
        final EditText ipSetting = MainSettingdialog.findViewById(R.id.ipSetting);
        exit = MainSettingdialog.findViewById(R.id.exit);
        save = MainSettingdialog.findViewById(R.id.saveSetting);
        String StkNo = "";

        final Spinner stkSpinner = MainSettingdialog.findViewById(R.id.spinner);
        ArrayAdapter<String> StkAdapter = null;


        final List<MainSetting> mainSettings = InventDB.getAllMainSetting();
        final List<Stk> STKList = InventDB.getAllStk();
        final List<String> StokNo = new ArrayList<>();
        if (STKList.size() != 0) {
            StokNo.clear();
            for (int i = 0; i < STKList.size(); i++) {
                StokNo.add(STKList.get(i).getStkNo());
            }

            StkAdapter = new ArrayAdapter<String>(Tools.this, R.layout.spinner_style, StokNo);
            stkSpinner.setAdapter(StkAdapter);



        }



        stkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StoreName.setText(STKList.get(position).getStkName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (mainSettings.size() != 0) {
            ipSetting.setText(mainSettings.get(0).getIP());
            StoreName.setText(InventDB.getStkName(mainSettings.get(0).getStorNo()));

            int index = StokNo.indexOf(mainSettings.get(0).getStorNo());
//            StkNo = StkAdapter.getItem(index);
            Log.e("indexofSpinner = ", "= " + index + "   " + StkNo + "    " + mainSettings.get(0).getStorNo());
            stkSpinner.setSelection(index);
        }
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainSettingdialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ipSetting.getText().toString().equals("")) {
                    InventDB.deleteAllItem("MAIN_SETTING_TABLE");
                    String Store="0";
                   if(StokNo.size()!=0){
                       Store=stkSpinner.getSelectedItem().toString();
                   }else{
                       Store="0";
                   }

                    InventDB.addAllMainSetting(new MainSetting(ipSetting.getText().toString(), Store));
//                    Toast.makeText(Tools.this, getResources().getString(R.string.saveMainSetting), Toast.LENGTH_SHORT).show();
                    MainSettingdialog.dismiss();

                    new SweetAlertDialog(Tools.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText( getResources().getString(R.string.sucess))
                            .setContentText( getResources().getString(R.string.saveMainSetting))
                            .show();




                }
            }
        });

        MainSettingdialog.show();
    }


    public void notClickable() {

//        pSetting.setClickable(false);
//        changePassword.setClickable(false);
        sendServer.setClickable(false);
//        receiveServer.setClickable(false);
        mainSetting.setClickable(false);

    }

    public void Clickable() {

//        pSetting.setClickable(true);
//        changePassword.setClickable(true);
        sendServer.setClickable(true);
//        receiveServer.setClickable(true);
        mainSetting.setClickable(true);


    }
    void TostMesage(String message){

        SweetAlertDialog sd2 = new SweetAlertDialog(this);
        sd2.setCancelable(true);
        sd2.setCanceledOnTouchOutside(true);
        sd2.setContentText(message);
        sd2.hideConfirmButton();
        sd2.show();


    }

    void sendToServer(List<ItemInfo> itemInfo , List<TransferItemsInfo>transferItemsInfos) {
        if (itemInfo.size() != 0 || transferItemsInfos.size()!=0) {
            boolean isExported=false,isExportedTranse=false;
            try {

                JSONArray obj2 = new JSONArray();
                for (int i = 0; i < itemInfo.size(); i++) {
                if (Integer.parseInt(itemInfo.get(i).getIsExport())!=1) {
                    Log.e("ExportData_", itemInfo.get(i).getSalePrice()+"");
                    obj2.put(itemInfo.get(i).getJSONObject2());
                    isExported=true;
                }
                }


                JSONObject obj = new JSONObject();
                obj.put("JRD", obj2);


                Log.e("ExportDataJrd_=", obj2.toString());

                Log.e("ExportData_", obj.toString());

                if(isExported){
                    ExportJeson exportJeson = new ExportJeson(Tools.this, obj);
                    exportJeson.startSending("ExportData");
                }else{
//                    Toast.makeText(Tools.this, getResources().getString(R.string.allExport), Toast.LENGTH_SHORT).show();
                    TostMesage(getResources().getString(R.string.allExport));

                }




                JSONArray objTrans = new JSONArray();
                for (int t = 0;t< transferItemsInfos.size(); t++) {
                    if (Integer.parseInt(transferItemsInfos.get(t).getIsExport())!=1) {
                        objTrans.put(transferItemsInfos.get(t).getJSONObjectTranse());
                        isExportedTranse=true;
                    }
                }


                JSONObject objTrans1 = new JSONObject();
                objTrans1.put("TRNS", objTrans);


                if(isExportedTranse){
                    ExportJeson exportJesons = new ExportJeson(Tools.this, objTrans1);
                    exportJesons.startSending("ExportTransferData");
                }else{
//                    Toast.makeText(Tools.this,  getResources().getString(R.string.allTexoprt), Toast.LENGTH_SHORT).show();
                    TostMesage(getResources().getString(R.string.allTexoprt));
                }
                Log.e("ExportData_Transe", "send"+objTrans1.toString());

                Log.e("ExportData_", "send");
            } catch (JSONException e) {
                Log.e("Tag", "JSONException");
            }
        } else {
//            Toast.makeText(Tools.this, getResources().getString(R.string.noexport), Toast.LENGTH_SHORT).show();
            TostMesage(getResources().getString(R.string.noexport));
        }
    }

    void initialization() {

        home = (TextView) findViewById(R.id.home);

//        pSetting = (LinearLayout) findViewById(R.id.pSetting);
//        changePassword = (LinearLayout) findViewById(R.id.password);
        sendServer = (LinearLayout) findViewById(R.id.sendSer);
        mainSetting = (LinearLayout) findViewById(R.id.mainSetting);
//        receiveServer = (LinearLayout) findViewById(R.id.reciveSer);


//        pSetting.setOnClickListener(showDialogOnClick);
//        changePassword.setOnClickListener(showDialogOnClick);
        sendServer.setOnClickListener(showDialogOnClick);
        mainSetting.setOnClickListener(showDialogOnClick);
//        receiveServer.setOnClickListener(showDialogOnClick);

        Clickable();


    }


}
