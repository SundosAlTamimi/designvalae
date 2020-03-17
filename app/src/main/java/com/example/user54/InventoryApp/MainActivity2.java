package com.example.user54.InventoryApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user54.InventoryApp.Model.MainSetting;
import com.example.user54.InventoryApp.Model.Password;
import com.example.user54.InventoryApp.R;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity2 extends AppCompatActivity {
//    Button exit, collecting, item, setting, report,send;
    LinearLayout  collecting, item, report,send;
    Button exit,  setting;
    Animation animFadein;
    private ScaleAnimation scale;
//    LinearLayout master;
    InventoryDatabase InventoryDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3_new);
        if(controll.isYellow){
            setContentView(R.layout.activity_main3_yellow);
        }else{
            setContentView(R.layout.activity_main3);
        }

        InventoryDb=new InventoryDatabase(MainActivity2.this);

//        new SweetAlertDialog(MainActivity2.this)
//                .setTitleText("Here's a message!")
//                .show();


//        new SweetAlertDialog(MainActivity2.this, SweetAlertDialog.WARNING_TYPE)
//                .setTitleText("Are you sure?")
//                .setContentText("You won't be able to recover this file!")
//                .setConfirmText("Delete!")
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog.dismissWithAnimation();
//                    }
//                })
//                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog.dismissWithAnimation();
//                    }
//                })
//                .show();







//
//         master=(LinearLayout)findViewById(R.id.master);
       
        item = (LinearLayout) findViewById(R.id.item);
        setting = (Button) findViewById(R.id.setting);
        report = (LinearLayout) findViewById(R.id.report);
        exit = (Button) findViewById(R.id.exit);
        collecting = (LinearLayout) findViewById(R.id.collectData);
        send = (LinearLayout) findViewById(R.id.send);
//

//        Date currentTimeAndDate = Calendar.getInstance().getTime();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        String today = df.format(currentTimeAndDate);
//        date.setText(today);

        collecting.setOnClickListener(mainMenu);
        exit.setOnClickListener(mainMenu);
        item.setOnClickListener(mainMenu);
        setting.setOnClickListener(mainMenu);
        report.setOnClickListener(mainMenu);
        send.setOnClickListener(mainMenu);

        send.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final EditText editText = new EditText(MainActivity2.this);
                final TextView textView = new EditText(MainActivity2.this);
                editText.setHint("Enter Password");
                editText.setTextColor(Color.BLACK);
                textView.setTextColor(Color.RED);
                if (SweetAlertDialog.DARK_STYLE) {
                    editText.setTextColor(Color.BLACK);
                }
                LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.addView(editText);
                linearLayout.addView(textView);

                SweetAlertDialog dialog = new SweetAlertDialog(MainActivity2.this, SweetAlertDialog.NORMAL_TYPE)
                        .setTitleText("Password")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                               String password=editText.getText().toString();
                                textView.setText("");
                                if(!password.equals("")){

                                    if(password.equals("2222")){

                                        textView.setText("");
                                        getChoesDialog();

                                        sweetAlertDialog.dismissWithAnimation();

                                    }else{
                                        textView.setText(getResources().getString(R.string.NotCorrectPassword));
                                    }

                                }

                            }
                        });
//                        .hideConfirmButton();

                dialog.setCustomView(linearLayout);
                dialog.show();


                return false;
            }
        });


//        master.setVisibility(View.GONE);

//        animFadein = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.fade_in);
//        collecting.startAnimation(animFadein);
//        item.startAnimation(animFadein);
//        report.startAnimation(animFadein);
//        send.startAnimation(animFadein);
        callAnimation();
    }

    public void callAnimation(){
        scale = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.INFINITE, .2f, ScaleAnimation.RELATIVE_TO_SELF, .2f);
        scale.setStartOffset(100);
        scale.setDuration(500);
        scale.setInterpolator(new OvershootInterpolator());
        collecting.startAnimation(scale);

        scale = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_SELF, .5f, ScaleAnimation.RELATIVE_TO_SELF, .5f);
        scale.setStartOffset(300);
        scale.setDuration(500);
        scale.setInterpolator(new OvershootInterpolator());
        item.startAnimation(scale);

        scale = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RESTART, .5f, ScaleAnimation.RELATIVE_TO_SELF, .5f);
        scale.setStartOffset(500);
        scale.setDuration(500);
        scale.setInterpolator(new OvershootInterpolator());
        send.startAnimation(scale);

        scale = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RESTART, .5f, ScaleAnimation.RELATIVE_TO_SELF, .5f);
        scale.setStartOffset(700);
        scale.setDuration(500);
        scale.setInterpolator(new OvershootInterpolator());
        report.startAnimation(scale);

    }


    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.collectData:

                    Intent coll = new Intent(MainActivity2.this, CollectingData.class);
                    startActivity(coll);

                    break;
                case R.id.item:

//                    master.setVisibility(View.VISIBLE);

                    Intent item = new Intent(MainActivity2.this, Item.class);
                    startActivity(item);
                    break;
                case R.id.report:
                    Intent report = new Intent(MainActivity2.this, Report.class);
                    startActivity(report);
                    break;
                case R.id.setting:
                    Intent tools = new Intent(MainActivity2.this, Tools.class);
                    startActivity(tools);
                    break;
                case R.id.send:
//                    Intent coll = new Intent(MainActivity.this, CllectingData.class);
//                    startActivity(coll);
//                      importJson sendCloud = new importJson(MainActivity2.this,"");
//                      sendCloud.startSending("ItemCard");
//                     sendCloud.startSending("ItemSwitch");
                    List<MainSetting> mainSetting=InventoryDb.getAllMainSetting();
                    if(mainSetting.size()!=0) {

                        alertMessageDialog(getResources().getString(R.string.importData), getResources().getString(R.string.importDataMessage), 2, "", "");
                    }else{

                        new SweetAlertDialog(MainActivity2.this, SweetAlertDialog.WARNING_TYPE)
                                 .setTitleText(getResources().getString(R.string.mainSetting) + "!")
                                .setContentText(getResources().getString(R.string.nomainSetting))
                                .setConfirmText(getResources().getString(R.string.cancel))
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null).show();


                    }
                    break;
                case R.id.exit:
                    alertMessageDialog(getResources().getString(R.string.exitfromapp), getResources().getString(R.string.exitMessage), 0, "", "");
                    break;
            }


        }
    };


    void getChoesDialog(){
        final Button itemCard = new Button(this);
        final Button itemSwitch = new Button(this);
        final Button itemStore = new Button(this);
        itemCard.setText(getResources().getString(R.string.Import_Item_Card));
        itemSwitch.setText(getResources().getString(R.string.ImportItemSwitch));
        itemStore.setText(getResources().getString(R.string.ImporItemStore));
        if (SweetAlertDialog.DARK_STYLE) {
            itemCard.setTextColor(Color.WHITE);
            itemSwitch.setTextColor(Color.WHITE);
            itemStore.setTextColor(Color.WHITE);
        }
//        itemCard.setBackgroundColor(Color.parseColor("#FDD835"));
//        itemSwitch.setBackgroundColor(Color.parseColor("#1F6381"));
//        itemStore.setBackgroundColor(Color.parseColor("#A5DC86"));


        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(itemCard);
        linearLayout.addView(itemSwitch);
        linearLayout.addView(itemStore);

        final SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(getResources().getString(R.string.importData))
                .hideConfirmButton();

        dialog.setCustomView(linearLayout);
        dialog.show();


        itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages(2);
                dialog.dismissWithAnimation();
            }
        });

        itemSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages(3);
                dialog.dismissWithAnimation();

            }
        });

        itemStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages(4);
                dialog.dismissWithAnimation();


            }
        });



    }

    void messages(int y){
        List<MainSetting> mainSetting=InventoryDb.getAllMainSetting();
        if(mainSetting.size()!=0) {

            alertMessageDialog(getResources().getString(R.string.importData), getResources().getString(R.string.importDataMessage), y, "", "");
        }else{

            new SweetAlertDialog(MainActivity2.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText(getResources().getString(R.string.mainSetting) + "!")
                    .setContentText(getResources().getString(R.string.nomainSetting))
                    .setConfirmText(getResources().getString(R.string.cancel))
                    .showCancelButton(false)
                    .setCancelClickListener(null)
                    .setConfirmClickListener(null).show();


        }
    }


    void alertMessageDialog(String title, String message, final int swith, final String itemName, final String ItemCode) {
//        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity2.this);
//        dialog.setTitle(title)
//                .setMessage(message)
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialoginterface, int i) {
//                        dialoginterface.cancel();
//                    }
//                })
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialoginterface, int i) {
//                        switch (swith) {
//                            case 0:
//                                finish();
//                                System.exit(0);
//                                break;
//                            case 1:
//
//                                Toast.makeText(MainActivity2.this, "All Item Delete ", Toast.LENGTH_SHORT).show();
////                             progressDialog();
//                                break;
//                            case 2:
//                                importJson sendCloud = new importJson(MainActivity2.this,"");
//                                sendCloud.startSending("ItemCard");
//
////                                importJson sendCloud2 = new importJson(MainActivity2.this,"");
////                                sendCloud2.startSending("ItemSwitch");
//
////                                importJson sendCloud3 = new importJson(MainActivity2.this,"");
////                                sendCloud3.startSending("GetStory");
//
//                                break;
//
//                        }
//                    }
//                }).show();


        new SweetAlertDialog(MainActivity2.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .setCancelText(getResources().getString(R.string.cancel))
                .setConfirmText(getResources().getString(R.string.ok))
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        // reuse previous dialog instance, keep widget user state, reset them if you need



                        switch (swith) {
                            case 0:
                                sDialog.setTitleText(getResources().getString(R.string.cancel)+"!")
                                        .setContentText(getResources().getString(R.string.canselexit))
                                        .setConfirmText(getResources().getString(R.string.ok))
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.ERROR_TYPE);
                                break;
                            case 1:
//
//                                Toast.makeText(MainActivity2.this, "All Item Delete ", Toast.LENGTH_SHORT).show();
////                             progressDialog();
                                break;
                            case 2:

                                   sDialog.setTitleText(getResources().getString(R.string.cancel) + "!")
                                           .setContentText(getResources().getString(R.string.cancelImport))
                                           .setConfirmText(getResources().getString(R.string.ok))
                                           .showCancelButton(false)
                                           .setCancelClickListener(null)
                                           .setConfirmClickListener(null)
                                           .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                                break;
                            case 3:

                                sDialog.setTitleText(getResources().getString(R.string.cancel) + "!")
                                        .setContentText(getResources().getString(R.string.cancelImport))
                                        .setConfirmText(getResources().getString(R.string.ok))
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                                break;
                            case 4:

                                sDialog.setTitleText(getResources().getString(R.string.cancel) + "!")
                                        .setContentText(getResources().getString(R.string.cancelImport))
                                        .setConfirmText(getResources().getString(R.string.ok))
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                                break;

                        }




                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        switch (swith) {
                            case 0:
                                finish();
                                System.exit(0);
                                break;
                            case 1:

                                Toast.makeText(MainActivity2.this, "All Item Delete ", Toast.LENGTH_SHORT).show();
//                             progressDialog();
                                break;
                            case 2:
                                importJson sendCloud = new importJson(MainActivity2.this,"",1);
                                sendCloud.startSending("ItemCard");

//                                importJson sendCloud2 = new importJson(MainActivity2.this,"");
//                                sendCloud2.startSending("ItemSwitch");

//                                importJson sendCloud3 = new importJson(MainActivity2.this,"");
//                                sendCloud3.startSending("GetStory");
                                sDialog.dismissWithAnimation();
                                break;
                            case 3:
                                importJson sendCloud2 = new importJson(MainActivity2.this,"",1);
                                sendCloud2.startSending("ItemSwitch");

//                                importJson sendCloud2 = new importJson(MainActivity2.this,"");
//                                sendCloud2.startSending("ItemSwitch");

//                                importJson sendCloud3 = new importJson(MainActivity2.this,"");
//                                sendCloud3.startSending("GetStory");
                                sDialog.dismissWithAnimation();
                                break;
                            case 4:
                                importJson sendCloud3 = new importJson(MainActivity2.this,"",1);
                                sendCloud3.startSending("GetStory");

//                                importJson sendCloud2 = new importJson(MainActivity2.this,"");
//                                sendCloud2.startSending("ItemSwitch");

//                                importJson sendCloud3 = new importJson(MainActivity2.this,"");
//                                sendCloud3.startSending("GetStory");
                                sDialog.dismissWithAnimation();
                                break;

                        }


//                        sDialog.setTitleText(getResources().getString(R.string.delete))
//                                .setContentText(getResources().getString(R.string.rowdelete))
//                                .setConfirmText(getResources().getString(R.string.ok))
//                                .showCancelButton(false)
//                                .setCancelClickListener(null)
//                                .setConfirmClickListener(null)
//                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                })
                .show();


    }

}
