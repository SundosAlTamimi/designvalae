//package com.example.user54.InventoryApp;
//
//import android.app.AlertDialog;
//import android.app.DatePickerDialog;
//import android.app.Dialog;
//import android.app.ProgressDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.text.Editable;
//import android.text.InputType;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.user54.InventoryApp.Model.ItemInfo;
//import com.example.user54.InventoryApp.Model.ItemCard;
//import com.example.user54.InventoryApp.Model.ItemInfoExp;
//import com.example.user54.InventoryApp.Model.MainSetting;
//import com.example.user54.InventoryApp.R;
//import com.google.zxing.integration.android.IntentIntegrator;
//import com.google.zxing.integration.android.IntentResult;
//import com.nightonke.boommenu.BoomButtons.BoomButton;
//import com.nightonke.boommenu.BoomMenuButton;
//import com.nightonke.boommenu.OnBoomListener;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//public class CollectingData2 extends AppCompatActivity {
//    Button main, main2, collectButton, item, tools, report, send,collecting ,exit,home,
//            collectData, collectByORG, transferData, collectingByExpiry,exitAll2,setting,
//            collectByReceipt, pSetting, changePassword, sendServer,
//            receiveServer, newItem, importText, pBarcode, pShelfTag, add,
//            exportText, ExportTransfer, exportExpDate, ExportAlternative, ExitAll;
//
//
//     LinearLayout menue ;
//    //    RelativeLayout mainR, secondR, collectR, itemR, reportR, toolsR;
//    Dialog dialog;
//    boolean open = false, collDOpen = false, collExOpen = false, collReceipt = false;
//    String today;
//    InventoryDatabase InventDB;
//    EditText editText;
//
//    ArrayList<ItemInfo> itemUpdate = new ArrayList<>();
//    ArrayList<ItemInfoExp> itemUpdateExp = new ArrayList<>();
//    ArrayList<ItemInfoExp> itemUpdateExpRec = new ArrayList<>();
//    boolean updateOpen = false, openSearch = false, openSave = false;
//    int textId = 0;
//    ArrayList<ItemCard> itemCardsList = new ArrayList<ItemCard>();
//
//    TableRow row;
//    TableLayout noteTable;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.menue3);
//
//        InventDB = new InventoryDatabase(CollectingData2.this);
//
//        initialization();
//        initBmb(R.id.bmb1);
//
//
////       main.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                menue.setVisibility(View.VISIBLE);
////                exit.setVisibility(View.VISIBLE);
////               main.setVisibility(View.INVISIBLE);
////                home.setVisibility(View.INVISIBLE);
////                notClickable();
////            }
////        });
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                menue.setVisibility(View.INVISIBLE);
//                exit.setVisibility(View.INVISIBLE);
////                main.setVisibility(View.VISIBLE);
////                home.setVisibility(View.VISIBLE);
//                 Clickable();
//            }
//        });
//
//
//        Date currentTimeAndDate = Calendar.getInstance().getTime();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        today = df.format(currentTimeAndDate);
////        date.setText(today);
//
////        home.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                finish();
////            }
////        });
//
////
////        String userNames = getIntent().getStringExtra("USER_NAME");
////
////        UserName.setText(userNames);
//
////        ExitAll.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                alertMessageDialog("Exit From App ...", "you are sorry you want to Exit From App ?", 0,"","");
////            }
////        });
//
////        add.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                addDialog(noteTable);
////
////            }
////        });
//
//
//    }
//
//
////    View.OnClickListener mainClick = new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            if (!open) {
//////                visibilityLayout(secondR);
////                secondR.setVisibility(View.VISIBLE);
////                ExitAll.setVisibility(View.INVISIBLE);
////                notClickable();
////                open = true;
////            } else {
//////                    visibilityLayout(mainR);
////                secondR.setVisibility(View.INVISIBLE);
////                ExitAll.setVisibility(View.VISIBLE);
////                Clickable();
////                open = false;
////            }
////        }
////    };
//
////    View.OnClickListener showOnClick = new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            switch (v.getId()) {
////                case R.id.coll:
////                    visibilityLayout(collectR);
////                    open = false;
////                    ExitAll.setVisibility(View.VISIBLE);
////                    Clickable();
////                    break;
////                case R.id.item:
////                    visibilityLayout(itemR);
////                    open = false;
////                    ExitAll.setVisibility(View.VISIBLE);
////                    Clickable();
////                    break;
////                case R.id.tools:
////                    visibilityLayout(toolsR);
////                    open = false;
////                    ExitAll.setVisibility(View.VISIBLE);
////                    Clickable();
////                    break;
////                case R.id.report:
////                    visibilityLayout(reportR);
////                    open = false;
////                    ExitAll.setVisibility(View.VISIBLE);
////                    Clickable();
////                    break;
////                case R.id.exit2:
//////                    alertMessageDialog();
////                    visibilityLayout(mainR);
////                    open = false;
////                    ExitAll.setVisibility(View.VISIBLE);
////                    break;
////            }
////        }
////    };
//
//
//    View.OnClickListener mainMenu =new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
//
//                case R.id.collec:
//
//                    break;
//                case R.id.items:
//                    Intent item = new Intent(CollectingData2.this, Item.class);
//                    startActivity(item);
//                    finish();
//                    break;
//                case R.id.report:
//                    Intent report = new Intent(CollectingData2.this, Report.class);
//                    startActivity(report);
//                    finish();
//                    break;
//                case R.id.setting:
//                    Intent tools = new Intent(CollectingData2.this, Tools.class);
//                    startActivity(tools);
//                    finish();
//                    break;
////                case R.id.:
////                    Intent coll = new Intent(MainActivity.this, CllectingData.class);
////                    startActivity(coll);
////                    break;
//                case R.id.exit2:
//                    alertMessageDialog("Exit From App ...", "you are sorry you want to Exit From App ?", 0, "", "");
//                    break;
//            }
//
//            menue.setVisibility(View.INVISIBLE);
//            exit.setVisibility(View.INVISIBLE);
////            main.setVisibility(View.VISIBLE);
////          home.setVisibility(View.VISIBLE);
//
//        }
//    };
//
//
//    View.OnClickListener showDialogOnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.collData:
//                    collDOpen = true;
//                    showCollectDataDialog();
//                    break;
//                case R.id.collByorg:
//
//                    showCollectByOrgDialog();
//                    break;
//                case R.id.collByExp:
//                    collExOpen = true;
//                    showCollectByExpDialog();
////                    Intent collectIntent = new Intent(CollectingData.this,CollectingByExp.class);
////                    collectIntent.putExtra("EXTRA_SESSION_ID", "0");
////                    startActivity(collectIntent);
//                    break;
//                case R.id.collByRecep:
//                    collReceipt = true;
////                    Intent RIntent = new Intent(CollectingData.this,CollectingByExp.class);
////                    RIntent.putExtra("EXTRA_SESSION_ID", "1");
////                    startActivity(RIntent);
//                    showCollectByReceiptDialog();
//                    break;
//                case R.id.transfer:
//                    showTransferDialog();
//                    break;
////                case R.id.password:
////                    showChangePasswordDialog();
////                    break;
////                case R.id.pSetting:
////                    showPrintSettingDialog();
////                    break;
////                case R.id.sendSer:
////                    showSendToServerDialog();
////                    break;
////                case R.id.reciveSer:
////                    showReceiveFromServerDialog();
////                    break;
////                case R.id.shelf:
////                    showPrintShelfTagDialog();
////                    break;
////                case R.id.newItem:
////                    openSave = true;
////                    showNewItemDialog(0);
////                    break;
////                case R.id.impText:
////                    showImportFromTextDialog();
////                    break;
////                case R.id.barcode:
////                    showPrintBarcodeDialog();
////                    break;
////                case R.id.expText:
////                    showExportToTextDialog();
////                    break;
////                case R.id.expTransfer:
////                    showExportTransferItemDialog();
////                    break;
////                case R.id.expExp:
////                    showExportItemDataByExpiryDateDialog();
////                    break;
////                case R.id.expAlternative:
////                    showExportAlternativeCodeDialog();
////                    break;
//            }
//        }
//    };
//
//    void showExportToTextDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.export_item_data_to_text);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void showExportTransferItemDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.export_transfer_item_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void showExportItemDataByExpiryDateDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.export_item_data_by_expiry);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void showExportAlternativeCodeDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.export_alternatev_code);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void showPrintShelfTagDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.print_shelf_tag);
//        dialog.setCanceledOnTouchOutside(true);
//
//        final int[] count1 = {1};
//        final TextView countText;
//        Button exit;
//        ImageButton upCount, downCount;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//        upCount = (ImageButton) dialog.findViewById(R.id.up);
//        downCount = (ImageButton) dialog.findViewById(R.id.down);
//        countText = (TextView) dialog.findViewById(R.id.countT);
//
//        upCount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count1[0]++;
//                countText.setText("" + count1[0]);
//            }
//        });
//        downCount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Integer.parseInt(countText.getText().toString()) != 1) {
//                    count1[0]--;
//                    countText.setText("" + count1[0]);
//                } else
//                    Toast.makeText(CollectingData2.this, "count down under value 1 ", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void showNewItemDialog(final int tr) {
//        final Dialog dialogNew = new Dialog(CollectingData2.this);
//        dialogNew.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogNew.setCancelable(false);
//        dialogNew.setContentView(R.layout.new_item);
//        dialogNew.setCanceledOnTouchOutside(false);
//
//
//        final Button exit, save, clear, serach, deleteItem, deleteAllItem;
//        final EditText itemCodeNew, itemNameNew,itemPrice;
//
//        itemCodeNew = (EditText) dialogNew.findViewById(R.id.itemCNew);
//        itemNameNew = (EditText) dialogNew.findViewById(R.id.itemNameNew);
//        itemPrice =(EditText) dialogNew.findViewById(R.id.itemPrice);
////        ArrayList<ItemCard> itemCardList = new ArrayList<>();
//
//        exit = (Button) dialogNew.findViewById(R.id.exit);
//        save = (Button) dialogNew.findViewById(R.id.saveNew);
//        clear = (Button) dialogNew.findViewById(R.id.clearNew);
//        serach = (Button) dialogNew.findViewById(R.id.searchNew);
//        deleteItem = (Button) dialogNew.findViewById(R.id.deleteItem);
//        deleteAllItem = (Button) dialogNew.findViewById(R.id.deleteAllItem);
//
//
//        itemCodeNew.requestFocus();
//
//        deleteItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!itemCodeNew.getText().toString().equals("")&&!itemNameNew.getText().toString().equals(""))
//                { alertMessageDialog("Delete ... ", "you are sorry you want to Delete this Item ..." +
//                        "\n \n"+"Item Name : " + itemNameNew.getText().toString() + " \n Item Code : " + itemCodeNew.getText().toString() + " \n\n from  Table ?", 2, itemNameNew.getText().toString(), itemCodeNew.getText().toString());
//                }else
//                    Toast.makeText(CollectingData2.this, "please Insert All data in Filed .", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        deleteAllItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertMessageDialog("Delete ... ", "you are sorry you want to Delete All Items in Table ?", 1,"","");
//            }
//        });
//
//
//        serach.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSearch = true;
//                openSave = false;
//                SearchDialog(itemCodeNew, 3);
//            }
//        });
//
//        itemCodeNew.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                boolean isItemFound = false;
//
//                String itemCode = itemCodeNew.getText().toString();
//                String itemName = itemNameNew.getText().toString();
//
//
//                if (!itemCodeNew.getText().toString().equals("") && openSave) {
//                    itemCardsList = InventDB.getAllItemCard();
//
//                    for (int i = 0; i < itemCardsList.size(); i++) {
//                        if (itemCardsList.get(i).getItemCode().equals(itemCode)) {
//                            isItemFound = true;
//                            itemNameNew.setText(itemCardsList.get(i).getItemName());
//                            itemPrice.setText(itemCardsList.get(i).getFDPRC());
//                            break;
//
//                        }
//                    }
//
//                    if (!isItemFound) {
//
////                        new Handler().post(new Runnable() {
////                            @Override
////                            public void run() {
////                                itemNameNew.requestFocus();
////                            }
////                        });
//
//                        save.setClickable(true);
//                    } else {
//                        save.setClickable(false);
//                        showAlertDialog("This item Found please add another item ");
//                    }
//
//
//                }
//
//
//            }
//
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!itemNameNew.getText().toString().equals("")) {
//                    ItemCard itemCard = new ItemCard();
//
//                    itemCard.setItemCode(itemCodeNew.getText().toString());
//                    itemCard.setItemName(itemNameNew.getText().toString());
//                    itemCard.setFDPRC(itemPrice.getText().toString());
//
//                    InventDB.addItemcardTable(itemCard);
//                    progressDialog();
//                    itemCodeNew.setText("");
//                    itemNameNew.setText("");
//                    itemPrice.setText("");
//                    itemCodeNew.requestFocus();
//
//                } else {
//                    Toast.makeText(CollectingData2.this, "Please insert all data", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                itemCodeNew.setText("");
//                itemNameNew.setText("");
//                itemPrice.setText("");
//                itemCodeNew.requestFocus();
//                save.setClickable(true);
//            }
//        });
//
//
////        save.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//////                boolean isItemFound = false;
//////                ArrayList<ItemCard> itemCardList = new ArrayList<>();
//////                String itemCode = itemCodeNew.getText().toString();
//////                String itemName = itemNameNew.getText().toString();
//////
//////                if (!itemCodeNew.getText().toString().equals("") && !itemNameNew.getText().toString().equals("") && openSave) {
//////
//////                    itemCardList = InventDB.getAllItemCard();
//////
//////                    for (int i = 0; i < itemCardList.size(); i++) {
//////                        if (itemCardList.get(i).getItemCode().equals(itemCode)) {
//////
//////                            isItemFound = true;
//////                            break;
//////
//////                        }
//////                    }
//////
//////                    if (!isItemFound) {
////
////                        ItemCard itemCard = new ItemCard();
////
////                        itemCard.setItemCode(itemCode);
////                        itemCard.setItemName(itemName);
////
////                        InventDB.addItemcardTable(itemCard);
////                        progressDialog();
//////                    itemCodes.requestFocus();
//////                    itemCodes.setText("");
////
////
//////                    } else {
//////                        showAlertDialog("This item Found please add another item ");
//////                    }
//////
//////
//////                } else {
//////                    Toast.makeText(CollectingData.this, "Please insert all data", Toast.LENGTH_SHORT).show();
//////                }
////                itemCodeNew.requestFocus();
////                itemCodeNew.setText("");
////                itemNameNew.setText("");
////            }
////        });
//
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSave = false;
//                switch (tr) {
//                    case 0:
//                        break;
//                    case 1:
//                        collDOpen = true;
//                        editText.requestFocus();
//                        editText.setText("");
//                        itemCardsList = InventDB.getAllItemCard();
//                        break;
//                    case 2:
//                        collExOpen = true;
//                        editText.requestFocus();
//                        editText.setText("");
//                        itemCardsList = InventDB.getAllItemCard();
//                        break;
//                    case 3:
//                        collReceipt = true;
//                        editText.requestFocus();
//                        editText.setText("");
//                        itemCardsList = InventDB.getAllItemCard();
//                        break;
//                }
//
//                dialogNew.dismiss();
//            }
//        });
//
//        dialogNew.show();
//    }
//
//    void showImportFromTextDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.import_iteams_from_text_file);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void showPrintBarcodeDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.print_item_barcode);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//
//    void showChangePasswordDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.change_password);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//
//    void showPrintSettingDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.activity_collecting_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//
//    void showSendToServerDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.activity_collecting_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//
//    void showReceiveFromServerDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.activity_collecting_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//
//    void showCollectDataDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.activity_collecting_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//
//        final int[] count = {0};
//        final ArrayList<ItemInfo> itemPreviousScan = new ArrayList<>();
//        ArrayList<ItemInfo> itemLastScan = new ArrayList<>();
//        final String[] oldQty = {"0"};
//
//        itemLastScan = InventDB.getAllItemInfo();
//        final boolean[] noEnterData = {true};
//
//        final boolean[] upDateClick = {false};
//        final Boolean[] isFound = {false};
//
//        final CheckBox upDateCheck = (CheckBox) dialog.findViewById(R.id.updateQ);
//
//        final TextView itemName, itemNameBefore, itemCodeBefore, itemLQtyBefore, itemAQtyBefore;
//        final Button exit, save, clear, update, newButton, search,barcode;
//        final EditText itemCodeText, itemQty, itemLocation;
//
//        itemCodeText = (EditText) dialog.findViewById(R.id.itemCode);
//        itemQty = (EditText) dialog.findViewById(R.id.item_qty);
//        itemLocation = (EditText) dialog.findViewById(R.id.location);
//
//        itemName = (TextView) dialog.findViewById(R.id.item_name);
//        itemNameBefore = (TextView) dialog.findViewById(R.id.itemNameB);
//        itemCodeBefore = (TextView) dialog.findViewById(R.id.itemCodeB);
//        itemLQtyBefore = (TextView) dialog.findViewById(R.id.itemLQtyB);
//        itemAQtyBefore = (TextView) dialog.findViewById(R.id.itemAQtyB);
//
//
//
//
//        if (!itemLastScan.isEmpty()) {
//            int qtyItem = itemLastScan.size();
//            itemNameBefore.setText(itemLastScan.get(qtyItem - 1).getItemName());
//            itemLQtyBefore.setText("" + itemLastScan.get(qtyItem - 1).getItemQty());
//            itemCodeBefore.setText(itemLastScan.get(qtyItem - 1).getItemCode());
//            itemAQtyBefore.setText(InventDB.getTotal(itemLastScan.get(qtyItem - 1).getItemCode(), "ITEMS_INFO"));
//
//        }
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//        save = (Button) dialog.findViewById(R.id.save);
//        clear = (Button) dialog.findViewById(R.id.cler);
//        update = (Button) dialog.findViewById(R.id.updateBu);
//        newButton = (Button) dialog.findViewById(R.id.newBu);
//        search = (Button) dialog.findViewById(R.id.search);
//        barcode=(Button) dialog.findViewById(R.id.barcode);
//
//
//        barcode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collDOpen = false;
//                Log.e("barcode_099","in");
//                IntentIntegrator intentIntegrator = new IntentIntegrator(CollectingData2.this);
//                intentIntegrator.setDesiredBarcodeFormats(intentIntegrator.ALL_CODE_TYPES);
//                intentIntegrator.setBeepEnabled(false);
//                intentIntegrator.setCameraId(1);
//                intentIntegrator.setPrompt("SCAN");
//                intentIntegrator.setBarcodeImageEnabled(false);
//                intentIntegrator.initiateScan();
//
//
//            }
//        });
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSearch = true;
//                collDOpen = false;
//                SearchDialog(itemCodeText, 0);
//            }
//        });
//
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collDOpen = false;
//                itemUpdate = InventDB.getAllItemInfo();
//                updateOpen = true;
//                upDateDialog(itemCodeBefore, 0, itemCodeText, itemAQtyBefore);
//
//            }
//        });
//
//        itemCodeText.requestFocus();
//        itemQty.setEnabled(true);
//        itemCodeText.setEnabled(true);
//
//        save.setClickable(true);
//        itemCodeText.setText("");
//        itemQty.setText("1");
//        itemName.setText("");
//        itemLocation.setText("");
//
//        final int[] serialInfo = {InventDB.getAllItemInfo().size()};
//
//        clear.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//                itemCodeText.requestFocus();
//                itemQty.setEnabled(true);
//                itemCodeText.setEnabled(true);
//
//                save.setClickable(true);
//                itemCodeText.setText("");
//                itemQty.setText("1");
//                itemName.setText("");
//                itemLocation.setText("");
//
////                if (!itemPreviousScan.isEmpty()) {
////                    itemNameBefore.setText(itemPreviousScan.get(count[0] - 1).getItemName());
////                    itemCodeBefore.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
////                    itemLQtyBefore.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
//////                    float AllQty = Float.parseFloat(itemPreviousScan.get(count[0] - 1).getItemLocation()) + itemPreviousScan.get(count[0] - 1).getItemQty();
//////                    itemAQtyBefore.setText("" + AllQty);
////
////                }
//            }
//        });
//
////        ArrayList<ItemCard> itemCardsList = new ArrayList<ItemCard>();
//
//        itemCardsList = InventDB.getAllItemCard();
//
////        final ArrayList<ItemCard> itemCardsList = this.itemCardsList;
//        itemCodeText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count1) {
//
//                String itemCode = itemCodeText.getText().toString();
//                if (!itemCode.equals("") && collDOpen && noEnterData[0]) {
//                    Log.e("itemCardsList.size()", "-->" + itemCardsList.size());
//                    for (int i = 0; i < itemCardsList.size(); i++) {
//                        String itemCodeList = itemCardsList.get(i).getItemCode();
//                        if (itemCode.equals(itemCodeList)) {
//                            isFound[0] = true;
//                            itemName.setText(itemCardsList.get(i).getItemName());
//
//                            break;
//                        } else {
//                            isFound[0] = false;
//                        }
//                    }
//
//                    if (isFound[0]) {
//
//
//                        if (upDateClick[0]) {
//                            save.setClickable(true);
//                            itemCodeText.setEnabled(false);
//                            itemQty.setEnabled(true);
//
//                            new Handler().post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    itemQty.requestFocus();
//                                }
//                            });
//
////                            Toast.makeText(CollectingData.this, "save no auto", Toast.LENGTH_SHORT).show();
//                        } else {
////                            Toast.makeText(CollectingData.this, "save auto", Toast.LENGTH_SHORT).show();
//                            oldQty[0] = InventDB.getTotal(itemCode, "ITEMS_INFO");
//                            itemQty.setText("1");
//                            save.setClickable(false);
//                            itemCodeText.setEnabled(false);
//                            itemQty.setEnabled(false);
//                            ItemInfo item = new ItemInfo();
//
//                            item.setItemCode(itemCodeText.getText().toString());
//                            item.setItemName(itemName.getText().toString());
//                            item.setItemQty(Float.parseFloat(itemQty.getText().toString()));
//
//                            String Lo="";
//                            List<MainSetting> mainSettings=InventDB.getAllMainSetting();
//                            if(mainSettings.size()!=0){
//                                Lo=mainSettings.get(0).getStorNo();
//                            }
//                            item.setItemLocation(Lo);
//                            item.setRowIndex(Float.parseFloat("0.0"));
//                            item.setSerialNo(serialInfo[0]++);
////                            item.setExpDate(itemDate.getText().toString());
//
//                            InventDB.addItemcard(item);
//
//                            item.setItemLocation(oldQty[0]);
//                            Log.e("ol12", "===>" + oldQty[0]);
//                            itemPreviousScan.add(item);
////                            Toast.makeText(CollectingData.this, "Saved Successfully ", Toast.LENGTH_SHORT).show();
//                            count[0]++;
//
//                            progressDialog();
//
//////////////////////////////////CLEAR ////////
//
//                            itemCodeText.requestFocus();
//                            itemQty.setEnabled(true);
//                            itemCodeText.setEnabled(true);
//
//                            save.setClickable(true);
//                            itemCodeText.setText("");
//                            itemQty.setText("1");
//                            itemName.setText("");
//                            itemLocation.setText("");
//
//                            if (!itemPreviousScan.isEmpty()) {
//                                itemNameBefore.setText(itemPreviousScan.get(count[0] - 1).getItemName());
//                                itemCodeBefore.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
//                                itemLQtyBefore.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
//
//                                float AllQty = Float.parseFloat(itemPreviousScan.get(count[0] - 1).getItemLocation()) + itemPreviousScan.get(count[0] - 1).getItemQty();
//                                itemAQtyBefore.setText("" + AllQty);
//
//
//                            }
//
//
//                        }
//
//
//                    } else {
//                        showAlertDialog("This item not found please add this item before ");
////                        Toast.makeText(CollectingData.this, "This item not found please add this item before ", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            }
//
//
//            @Override
//            public void afterTextChanged(Editable s) {
////                itemQty.setText("1");
//            }
//
//        });
//
//
//        newButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collDOpen = false;
//                editText = itemCodeText;
//                openSave = true;
//
//                showNewItemDialog(1);
//            }
//        });
//
//
//        save.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick(View v) {
//
//                oldQty[0] = InventDB.getTotal(itemCodeText.getText().toString(), "ITEMS_INFO");
//
//                if (!itemQty.getText().toString().equals("") && !itemCodeText.getText().toString().equals("") && isFound[0]) {
//
//                    ItemInfo item = new ItemInfo();
//
//                    item.setItemCode(itemCodeText.getText().toString());
//                    item.setItemName(itemName.getText().toString());
//                    item.setItemQty(Float.parseFloat(itemQty.getText().toString()));
//                    item.setItemLocation("12");
//                    item.setRowIndex(Float.parseFloat("0.0"));
//                    item.setSerialNo(serialInfo[0]++);
//
//                    InventDB.addItemcard(item);
//                    item.setItemLocation(oldQty[0]);
//                    itemPreviousScan.add(item);
//                    count[0]++;
//
//                    progressDialog();
//                    ////////CLEAR ///
//
//                    itemCodeText.requestFocus();
//                    itemQty.setEnabled(true);
//                    itemCodeText.setEnabled(true);
//
//                    save.setClickable(true);
//                    itemCodeText.setText("");
//                    itemQty.setText("1");
//                    itemName.setText("");
//                    itemLocation.setText("");
//
//                    if (!itemPreviousScan.isEmpty()) {
//                        itemNameBefore.setText(itemPreviousScan.get(count[0] - 1).getItemName());
//                        itemCodeBefore.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
//                        itemLQtyBefore.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
//                        float AllQty = Float.parseFloat(itemPreviousScan.get(count[0] - 1).getItemLocation()) + itemPreviousScan.get(count[0] - 1).getItemQty();
//                        itemAQtyBefore.setText("" + AllQty);
//
//
//                    }
//
//                } else {
//                    Toast.makeText(CollectingData2.this, "please insert all data in field", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });
//
//        upDateCheck.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick(View v) {
//                if (upDateCheck.isChecked()) {
//                    upDateClick[0] = true;
//                } else {
//                    upDateClick[0] = false;
//                }
//            }
//        });
//
//
//        exit.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick(View v) {
//                collDOpen = false;
//                noEnterData[0] = false;
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//
////   void Clear(EditText itemCodeText,EditText itemQty ,EditText itemName ,TextView itemNameBefore ,TextView itemCodeBefore
////   ,TextView itemLQtyBefore){
////
////       itemCodeText.requestFocus();
////       itemQty.setEnabled(true);
////       itemCodeText.setEnabled(true);
////
////       save.setClickable(true);
////       itemCodeText.setText("");
////       itemQty.setText("1");
////       itemName.setText("");
////       itemLocation.setText("");
////
////       if (!itemPreviousScan.isEmpty()) {
////           itemNameBefore.setText(itemPreviousScan.get(count[0] - 1).getItemName());
////           itemCodeBefore.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
////           itemLQtyBefore.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
////           float AllQty = Float.parseFloat(itemPreviousScan.get(count[0] - 1).getItemLocation()) + itemPreviousScan.get(count[0] - 1).getItemQty();
////           itemAQtyBefore.setText("" + AllQty);
////
////       }
////
////
////   }
//
//
//    void showCollectByOrgDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.activity_collecting_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
//
//    void showCollectByExpDialog() {
//        final Dialog dialog1 = new Dialog(CollectingData2.this);
//        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog1.setCancelable(false);
//        dialog1.setContentView(R.layout.collecting_data_by_expiry_data);
//        dialog1.setCanceledOnTouchOutside(false);
//
////        Toast.makeText(this, "1234567", Toast.LENGTH_SHORT).show();
//        final boolean[] noEnter = {true};
//        final Boolean[] isFoundExp = {false};
//        final int[] count = {0};
//
//
//        final String[] oldQty = {"0"};
//        /////
//        final Button exit, save, clear, update, newButton, search;
//        final CheckBox upDateQty = (CheckBox) dialog1.findViewById(R.id.upDateQyt);//batch
//        final CheckBox BatchNo = (CheckBox) dialog1.findViewById(R.id.batch);
//        ArrayList<ItemInfoExp> itemLastScan = new ArrayList<>();
////        ArrayList<ItemCard> itemCardsList = new ArrayList<ItemCard>();
//        final EditText batchText, itemCodeText1, itemQty;
//        final TextView itemName, itemAvl, itemCodeP, itemSaleP, itemCodeBefor, itemNameBefor,
//                itemAlBe, itemLastBe, itemDate;
//
//
//        exit = (Button) dialog1.findViewById(R.id.exit);
//        save = (Button) dialog1.findViewById(R.id.saveExp);
//        clear = (Button) dialog1.findViewById(R.id.clearExp);
//        update = (Button) dialog1.findViewById(R.id.updateExp);
//        newButton = (Button) dialog1.findViewById(R.id.newBuEx);
//        search = (Button) dialog1.findViewById(R.id.searchExp);
//
//        itemCodeText1 = (EditText) dialog1.findViewById(R.id.items1);
//        itemQty = (EditText) dialog1.findViewById(R.id.item_Qty);
//        batchText = (EditText) dialog1.findViewById(R.id.batchText);
//
//        itemName = (TextView) dialog1.findViewById(R.id.itemNames);
//        itemAvl = (TextView) dialog1.findViewById(R.id.Avl);
//        itemCodeP = (TextView) dialog1.findViewById(R.id.costP);
//        itemSaleP = (TextView) dialog1.findViewById(R.id.saleP);
//        itemCodeBefor = (TextView) dialog1.findViewById(R.id.itemCodeBef);
//        itemNameBefor = (TextView) dialog1.findViewById(R.id.itemNameBef);
//        itemAlBe = (TextView) dialog1.findViewById(R.id.itemAllBef);
//        itemLastBe = (TextView) dialog1.findViewById(R.id.itemLQtyBef);
//        itemDate = (TextView) dialog1.findViewById(R.id.DateItem);
//
//        newButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collExOpen = false;
//                editText = itemCodeText1;
//                openSave = true;
//                showNewItemDialog(2);
//            }
//        });
//
//        itemLastScan = InventDB.getAllItemInfoExp();
//        final int[] serialExp = {itemLastScan.size()};
//
//        itemCardsList = InventDB.getAllItemCard();
//
//
//        itemCodeText1.setEnabled(true);
//        itemCodeText1.requestFocus();
//        itemQty.setEnabled(true);
//
//
//        save.setClickable(true);
//        itemCodeText1.setText("");
//        itemQty.setText("1");
//        itemName.setText("");
//        itemDate.setText(today);
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSearch = true;
//                collExOpen = false;
//                SearchDialog(itemCodeText1, 1);
//            }
//        });
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collExOpen = false;
//                itemUpdateExp = InventDB.getAllItemInfoExp();
//                updateOpen = true;
//                upDateDialog(itemCodeBefor, 1, itemCodeText1, itemAlBe);
//
//            }
//        });
//
//
//        itemDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimeDialog(itemDate);
//            }
//        });
//
//        if (!itemLastScan.isEmpty()) {
//            int qtyItem = itemLastScan.size();
//            itemNameBefor.setText(itemLastScan.get(qtyItem - 1).getItemName());
//            itemLastBe.setText("" + itemLastScan.get(qtyItem - 1).getItemQty());
//            itemCodeBefor.setText(itemLastScan.get(qtyItem - 1).getItemCode());
//            itemAlBe.setText(InventDB.getTotal(itemLastScan.get(qtyItem - 1).getItemCode(), "ITEM_INFO_EXP"));
//        }
//
////        final ArrayList<ItemCard> itemCardsList = itemCardsList;
//        final ArrayList<ItemInfoExp> itemPreviousScan = new ArrayList<>();
//
//        clear.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//                itemCodeText1.requestFocus();
//                itemQty.setEnabled(true);
//                itemCodeText1.setEnabled(true);
//
//                save.setClickable(true);
//                itemCodeText1.setText("");
//                itemQty.setText("1");
//                itemName.setText("");
//                batchText.setText("");
//
////                if (!itemPreviousScan.isEmpty()) {
////                    itemNameBefor.setText(itemPreviousScan.get(count[0] - 1).getItemName());
////                    itemCodeBefor.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
////                    itemLastBe.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
////                    float AllQty = itemPreviousScan.get(count[0] - 1).getRowIndex() + itemPreviousScan.get(count[0] - 1).getItemQty();
////                    itemAlBe.setText("" + AllQty);
////
////                }
//            }
//        });
//
//        itemCodeText1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count2) {
//                String itemCode = itemCodeText1.getText().toString();
//                if (!itemCode.equals("") && collExOpen && noEnter[0]) {
//
//                    for (int i = 0; i < itemCardsList.size(); i++) {
//                        String itemCodeList = itemCardsList.get(i).getItemCode();
//                        if (itemCode.equals(itemCodeList)) {
//                            itemName.setText(itemCardsList.get(i).getItemName());
//                            itemAvl.setText(itemCardsList.get(i).getAVLQty());
//                            itemCodeP.setText(itemCardsList.get(i).getCostPrc());
//                            itemSaleP.setText(itemCardsList.get(i).getFDPRC());
//
//                            isFoundExp[0] = true;
//                            break;
//                        } else {
//                            isFoundExp[0] = false;
//                        }
//                    }
//
//                    if (isFoundExp[0]) {
//
//                        if (upDateQty.isChecked()) {
//                            save.setClickable(true);
//                            itemCodeText1.setEnabled(false);
//                            itemQty.setEnabled(true);
//
//                            new Handler().post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    itemQty.requestFocus();
//                                }
//                            });
//
////                            Toast.makeText(CollectingData.this, "save no auto", Toast.LENGTH_SHORT).show();
//                        } else {
////                            Toast.makeText(CollectingData.this, "save auto", Toast.LENGTH_SHORT).show();
//                            oldQty[0] = InventDB.getTotal(itemCode, "ITEM_INFO_EXP");
//                            itemQty.setText("1");
//                            save.setClickable(false);
//                            itemCodeText1.setEnabled(false);
//                            itemQty.setEnabled(false);
//
//                            if (BatchNo.isChecked()) {
//                                if (!batchText.getText().toString().equals("")) {
//
//                                    count[0]++;
//
//                                    saveFunction(itemCodeText1, itemName, itemQty, itemDate, 1, "--",
//                                            batchText.getText().toString(), itemAvl, itemNameBefor, itemLastBe, itemAlBe,
//                                            itemCodeP, itemSaleP, itemPreviousScan, count[0], save, itemCodeBefor, oldQty[0], serialExp[0]++);
//
////                            if (!batchText.getText().toString().equals("")) {
////
////                                ItemInfoExp item = new ItemInfoExp();
////
////                                item.setItemCode(itemCodeText1.getText().toString());
////                                item.setItemName(itemName.getText().toString());
////                                item.setItemQty(Float.parseFloat(itemQty.getText().toString()));
////                                item.setExpDate(itemDate.getText().toString());
////                                item.setBatchNo(batchText.getText().toString());
////                                item.setRowIndex(Float.parseFloat("0.0"));
////                                item.setAVLQTY(itemAvl.getText().toString());
////                                item.setCostPrc(itemCodeP.getText().toString());
////                                item.setSalePrc(itemSaleP.getText().toString());
////                                item.setReceiptNo("");
////
////                                InventDB.addItemInfoExp(item);
////
////                                item.setRowIndex(Float.parseFloat(oldQty[0]));
////                                itemPreviousScan.add(item);
//////                            Toast.makeText(CollectingData.this, "Saved Successfully ", Toast.LENGTH_SHORT).show();
////                                count[0]++;
////
////                                progressDialog();
////
////////////////////////////////////CLEAR ////////
////
////                                itemCodeText1.requestFocus();
////                                itemQty.setEnabled(true);
////                                itemCodeText1.setEnabled(true);
////
////                                save.setClickable(true);
////                                itemCodeText1.setText("");
////                                itemQty.setText("1");
////                                itemName.setText("");
////                                itemAvl.setText("");
////                                itemCodeP.setText("");
////                                itemSaleP.setText("");
////                                batchText.setText("");
////
////                                if (!itemPreviousScan.isEmpty()) {
////                                    itemNameBefor.setText(itemPreviousScan.get(count[0] - 1).getItemName());
////                                    itemCodeBefor.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
////                                    itemLastBe.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
////
////                                    float AllQty = itemPreviousScan.get(count[0] - 1).getRowIndex() + itemPreviousScan.get(count[0] - 1).getItemQty();
////                                    itemAlBe.setText("" + AllQty);
////
////
////                                }
//
//                                } else {
//                                    showAlertDialog("Batch Filed Empty Please Enter data");
//
//                                    new Handler().post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            batchText.requestFocus();
//                                        }
//                                    });
//                                    save.setClickable(true);
//                                }
//                            } else {
//                                count[0]++;
//                                saveFunction(itemCodeText1, itemName, itemQty, itemDate, 1, "--",
//                                        "--", itemAvl, itemNameBefor, itemLastBe, itemAlBe,
//                                        itemCodeP, itemSaleP, itemPreviousScan, count[0], save, itemCodeBefor, oldQty[0], serialExp[0]++);
//                            }
//
//
//                        }
//
//
//                    } else {
//                        showAlertDialog("This item not found please add this item before ");
////                        Toast.makeText(CollectingData.this, "This item not found please add this item before ", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
//
//
//        save.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick(View v) {
//
//                oldQty[0] = InventDB.getTotal(itemCodeText1.getText().toString(), "ITEM_INFO_EXP");
//
//                if (!itemQty.getText().toString().equals("") && !itemCodeText1.getText().toString().equals("") && isFoundExp[0]) {
//                    if (BatchNo.isChecked()) {
//                        if (!batchText.getText().toString().equals("")) {
//                            count[0]++;
//                            saveFunction(itemCodeText1, itemName, itemQty, itemDate, 1, "--",
//                                    batchText.getText().toString(), itemAvl, itemNameBefor, itemLastBe, itemAlBe,
//                                    itemCodeP, itemSaleP, itemPreviousScan, count[0], save, itemCodeBefor, oldQty[0], serialExp[0]++);
//
////                        ItemInfoExp item = new ItemInfoExp();
////
////                        item.setItemCode(itemCodeText1.getText().toString());
////                        item.setItemName(itemName.getText().toString());
////                        item.setItemQty(Float.parseFloat(itemQty.getText().toString()));
////                        item.setExpDate(itemDate.getText().toString());
////                        item.setBatchNo(batchText.getText().toString());
////                        item.setRowIndex(Float.parseFloat("0.0"));
////                        item.setAVLQTY(itemAvl.getText().toString());
////                        item.setCostPrc(itemCodeP.getText().toString());
////                        item.setSalePrc(itemSaleP.getText().toString());
////                        item.setReceiptNo("");
////
////                        InventDB.addItemInfoExp(item);
////
////                        item.setRowIndex(Float.parseFloat(oldQty[0]));
////                        itemPreviousScan.add(item);
////                        count[0]++;
////
////                        progressDialog();
////                        ////////CLEAR ///
////
////                        itemCodeText1.requestFocus();
////                        itemQty.setEnabled(true);
////                        itemCodeText1.setEnabled(true);
////
////                        save.setClickable(true);
////                        itemCodeText1.setText("");
////                        itemQty.setText("1");
////                        itemName.setText("");
////                        itemAvl.setText("");
////                        itemCodeP.setText("");
////                        itemSaleP.setText("");
////                        batchText.setText("");
////
////                        if (!itemPreviousScan.isEmpty()) {
////                            itemNameBefor.setText(itemPreviousScan.get(count[0] - 1).getItemName());
////                            itemCodeBefor.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
////                            itemLastBe.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
////                            float AllQty = itemPreviousScan.get(count[0] - 1).getRowIndex() + itemPreviousScan.get(count[0] - 1).getItemQty();
////                            itemAlBe.setText("" + AllQty);
////
////
////                        }
//                        } else {
//                            showAlertDialog("Batch Filed Empty Please Enter data");
//
//                            new Handler().post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    batchText.requestFocus();
//                                }
//                            });
//
//
//                        }
//                    } else {
//                        count[0]++;
//                        saveFunction(itemCodeText1, itemName, itemQty, itemDate, 1, "--",
//                                "--", itemAvl, itemNameBefor, itemLastBe, itemAlBe,
//                                itemCodeP, itemSaleP, itemPreviousScan, count[0], save, itemCodeBefor, oldQty[0], serialExp[0]++);
//                    }
//
//                } else {
//                    Toast.makeText(CollectingData2.this, "please insert all data in field", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });
//
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                noEnter[0] = false;
//                dialog1.dismiss();
//            }
//        });
//        dialog1.show();
//    }
//
//
//    void showAlertDialog(String TextMessage) {
//        final Dialog dialogAlert = new Dialog(CollectingData2.this);
//        dialogAlert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogAlert.setCancelable(false);
//        dialogAlert.setContentView(R.layout.alert_dialog_not_found);
//        dialogAlert.setCanceledOnTouchOutside(false);
//        TextView textMessage = (TextView) dialogAlert.findViewById(R.id.alertMessage);
//        Button exitAlert = (Button) dialogAlert.findViewById(R.id.exitAlert);
//        textMessage.setText(TextMessage);
//
//        dialogAlert.show();
//
//        exitAlert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogAlert.dismiss();
//            }
//        });
//    }
//
//
//    void showCollectByReceiptDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.collecting_data_with_receipt);
//        dialog.setCanceledOnTouchOutside(false);
//
//        final boolean[] noEnterR = {true};
//        final Boolean[] isFoundRec = {false};
//        final String[] oldQty = {"0"};
//        final int[] count = {0};
//
//
//        final Button exit, save, clear, update, newButton, search;
//        final TextView itemName, Avl, costPrc, salePrc, dateExp, itemNameBefore, itemCodeBefore, lastQty, allQty;
//        final EditText itemCodeTextReceipt, itemQty, batchNo, receiptNo;
//
//        itemCodeTextReceipt = (EditText) dialog.findViewById(R.id.itemCodes12);
//        itemQty = (EditText) dialog.findViewById(R.id.itemQt);
//        batchNo = (EditText) dialog.findViewById(R.id.batchRecpic);
//        receiptNo = (EditText) dialog.findViewById(R.id.receirtNo);
//
//        itemName = (TextView) dialog.findViewById(R.id.itemName);
//        Avl = (TextView) dialog.findViewById(R.id.avlQty);
//        costPrc = (TextView) dialog.findViewById(R.id.costP);
//        salePrc = (TextView) dialog.findViewById(R.id.saleP);
//        dateExp = (TextView) dialog.findViewById(R.id.dateExp);
//        itemNameBefore = (TextView) dialog.findViewById(R.id.itemNameBe);
//        itemCodeBefore = (TextView) dialog.findViewById(R.id.itemCodeBe);
//        lastQty = (TextView) dialog.findViewById(R.id.itemLastBe);
//        allQty = (TextView) dialog.findViewById(R.id.itemAllBe);
//
//
//        clear = (Button) dialog.findViewById(R.id.clear);
//        save = (Button) dialog.findViewById(R.id.save);
//        exit = (Button) dialog.findViewById(R.id.exit);
//        update = (Button) dialog.findViewById(R.id.updateRec);
//        newButton = (Button) dialog.findViewById(R.id.new1);
//        search = (Button) dialog.findViewById(R.id.searchExpRec);
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSearch = true;
//                collReceipt = false;
//                SearchDialog(itemCodeTextReceipt, 2);
//            }
//        });
//
//        newButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collReceipt = false;
//                editText = itemCodeTextReceipt;
//                openSave = true;
//                showNewItemDialog(3);
//            }
//        });
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collReceipt = false;
//                String itemCode = itemCodeBefore.getText().toString();
//
//                itemUpdateExpRec = InventDB.getAllItemInfoExpRec();
//                updateOpen = true;
//                upDateDialog(itemCodeBefore, 2, itemCodeTextReceipt, allQty);
//
//            }
//        });
//
//
//        final CheckBox upDateQty, batchCheck;
//        upDateQty = (CheckBox) dialog.findViewById(R.id.upDateRecip);
//        batchCheck = (CheckBox) dialog.findViewById(R.id.batchBox);
//
//
//        ArrayList<ItemInfoExp> itemLastScan = new ArrayList<ItemInfoExp>();
////        ArrayList<ItemCard> itemCardsList = new ArrayList<ItemCard>();
//
//        itemLastScan = InventDB.getAllItemInfoExpRec();
//        final int[] serialRec = {itemLastScan.size()};
//
//        itemCodeTextReceipt.setEnabled(true);
//        itemCodeTextReceipt.requestFocus();
//        itemQty.setEnabled(true);
//
//
//        save.setClickable(true);
//        itemCodeTextReceipt.setText("");
//        itemQty.setText("1");
//        itemName.setText("");
//        dateExp.setText(today);
//
//        Log.e("4", "addText");
//        dateExp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimeDialog(dateExp);
//            }
//        });
//
//        if (!itemLastScan.isEmpty()) {
//            int qtyItem = itemLastScan.size();
//            itemNameBefore.setText(itemLastScan.get(qtyItem - 1).getItemName());
//            lastQty.setText("" + itemLastScan.get(qtyItem - 1).getItemQty());
//            itemCodeBefore.setText(itemLastScan.get(qtyItem - 1).getItemCode());
//            allQty.setText(InventDB.getTotal(itemLastScan.get(qtyItem - 1).getItemCode(), "ITEM_INFO_EXP_REC"));
//        }
//
//
//        final ArrayList<ItemInfoExp> itemPreviousScan = new ArrayList<>();
//        itemCardsList = InventDB.getAllItemCard();
//
////        final ArrayList<ItemCard> itemCardsList = itemCardsList;
//
//        itemCodeTextReceipt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count3) {
//
//                String itemCode = itemCodeTextReceipt.getText().toString();
//                if (!itemCode.equals("") && collReceipt && noEnterR[0]) {
//
//                    for (int i = 0; i < itemCardsList.size(); i++) {
//                        String itemCodeList = itemCardsList.get(i).getItemCode();
//                        if (itemCode.equals(itemCodeList)) {
//                            itemName.setText(itemCardsList.get(i).getItemName());
//                            Avl.setText(itemCardsList.get(i).getAVLQty());
//                            costPrc.setText(itemCardsList.get(i).getCostPrc());
//                            salePrc.setText(itemCardsList.get(i).getFDPRC());
//
//                            isFoundRec[0] = true;
//                            break;
//                        } else {
//                            isFoundRec[0] = false;
//                        }
//                    }
//
//                    if (isFoundRec[0]) {
//
//                        if (upDateQty.isChecked()) {
//                            save.setClickable(true);
//                            itemCodeTextReceipt.setEnabled(false);
//                            itemQty.setEnabled(true);
//
//                            new Handler().post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    itemQty.requestFocus();
//                                }
//                            });
//
//                        } else {
//                            oldQty[0] = InventDB.getTotal(itemCode, "ITEM_INFO_EXP_REC");
//                            itemQty.setText("1");
//                            save.setClickable(false);
//                            itemCodeTextReceipt.setEnabled(false);
//                            itemQty.setEnabled(false);
//
//                            if (batchCheck.isChecked()) {
//                                if (!batchNo.getText().toString().equals("")) {
//
//                                    count[0]++;
//
//                                    saveFunction(itemCodeTextReceipt, itemName, itemQty, dateExp, 2, receiptNo.getText().toString(),
//                                            batchNo.getText().toString(), Avl, itemNameBefore, lastQty, allQty,
//                                            costPrc, salePrc, itemPreviousScan, count[0], save, itemCodeBefore, oldQty[0], serialRec[0]++);
//
//                                } else {
//                                    showAlertDialog("Batch Filed Empty Please Enter data");
//
//                                    new Handler().post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            batchNo.requestFocus();
//                                        }
//                                    });
//                                    save.setClickable(true);
//                                }
//                            } else {
//                                count[0]++;
//                                saveFunction(itemCodeTextReceipt, itemName, itemQty, dateExp, 2, receiptNo.getText().toString(),
//                                        "--", Avl, itemNameBefore, lastQty, allQty,
//                                        costPrc, salePrc, itemPreviousScan, count[0], save, itemCodeBefore, oldQty[0], serialRec[0]++);
//                            }
//
//
//                        }
//
//
//                    } else {
//                        showAlertDialog("This item not found please add this item before ");
////                        Toast.makeText(CollectingData.this, "This item not found please add this item before ", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
//
//
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                itemCodeTextReceipt.requestFocus();
//                itemQty.setEnabled(true);
//                itemCodeTextReceipt.setEnabled(true);
//
//                save.setClickable(true);
//                itemCodeTextReceipt.setText("");
//                itemQty.setText("1");
//                itemName.setText("");
//                batchNo.setText("");
//                receiptNo.setText("");
//
////                if (!itemPreviousScan.isEmpty()) {
////                    itemNameBefore.setText(itemPreviousScan.get(count[0] - 1).getItemName());
////                    itemCodeBefore.setText(itemPreviousScan.get(count[0] - 1).getItemCode());
////                    lastQty.setText("" + itemPreviousScan.get(count[0] - 1).getItemQty());
////                    float AllQty = itemPreviousScan.get(count[0] - 1).getRowIndex() + itemPreviousScan.get(count[0] - 1).getItemQty();
////                    allQty.setText("" + AllQty);
////
////                }
//            }
//        });
//
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                oldQty[0] = InventDB.getTotal(itemCodeTextReceipt.getText().toString(), "ITEM_INFO_EXP_REC");
//
//                if (!itemQty.getText().toString().equals("") && !itemCodeTextReceipt.getText().toString().equals("") && isFoundRec[0]) {
//                    if (batchCheck.isChecked()) {
//                        if (!batchNo.getText().toString().equals("")) {
//                            count[0]++;
//                            saveFunction(itemCodeTextReceipt, itemName, itemQty, dateExp, 2, receiptNo.getText().toString(),
//                                    "--", Avl, itemNameBefore, lastQty, allQty,
//                                    costPrc, salePrc, itemPreviousScan, count[0], save, itemCodeBefore, oldQty[0], serialRec[0]++);
//
//                        } else {
//                            showAlertDialog("Batch Filed Empty Please Enter data");
//
//                            new Handler().post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    batchNo.requestFocus();
//                                }
//                            });
//
//
//                        }
//                    } else {
//                        count[0]++;
//                        saveFunction(itemCodeTextReceipt, itemName, itemQty, dateExp, 2, receiptNo.getText().toString(),
//                                "--", Avl, itemNameBefore, lastQty, allQty,
//                                costPrc, salePrc, itemPreviousScan, count[0], save, itemCodeBefore, oldQty[0], serialRec[0]++);
//                    }
//
//                } else {
//                    Toast.makeText(CollectingData2.this, "please insert all data in field", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });
//
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                collReceipt = false;
//                noEnterR[0] = false;
//                dialog.dismiss();
//
//            }
//        });
//
//        dialog.show();
//    }
//
//
//    void showTransferDialog() {
//        dialog = new Dialog(CollectingData2.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.transfer_data);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button exit;
//
//        exit = (Button) dialog.findViewById(R.id.exit);
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    void saveFunction(EditText itemCodeText1, TextView itemName, EditText itemQty, TextView itemDate, int switches, String receiptNo,
//                      String batchText, TextView itemAvl, TextView itemNameBefor, TextView itemLastBe, TextView itemAlBe,
//                      TextView itemCodeP, TextView itemSaleP, ArrayList<ItemInfoExp> itemPreviousScan, int count, Button save, TextView itemCodeBefor, String oldQty, int serial) {
//
//
//        ItemInfoExp item = new ItemInfoExp();
//
//
//        item.setItemCode(itemCodeText1.getText().toString());
//        item.setItemName(itemName.getText().toString());
//        item.setItemQty(Float.parseFloat(itemQty.getText().toString()));
//        item.setExpDate(itemDate.getText().toString());
//        item.setBatchNo(batchText);
//        item.setRowIndex(Float.parseFloat("0.0"));
//        item.setAVLQTY(itemAvl.getText().toString());
//        item.setCostPrc(itemCodeP.getText().toString());
//        item.setSalePrc(itemSaleP.getText().toString());
//        item.setReceiptNo(receiptNo);
//
//        switch (switches) {
//            case 1:
//
//                item.setSerialNo(serial);
//                InventDB.addItemInfoExp(item);
//                break;
//            case 2:
//                serial = InventDB.getAllItemInfoExpRec().size();
//                item.setSerialNo(serial);
//                InventDB.addItemInfoReceipt(item);
//                break;
//        }
//
//        item.setRowIndex(Float.parseFloat(oldQty));
//        itemPreviousScan.add(item);
//
//        progressDialog();
//
//////////////////////////////////CLEAR ////////
//
//        itemCodeText1.requestFocus();
//        itemQty.setEnabled(true);
//        itemCodeText1.setEnabled(true);
//
//        save.setClickable(true);
//        itemCodeText1.setText("");
//        itemQty.setText("1");
//        itemName.setText("");
//        itemAvl.setText("");
//        itemCodeP.setText("");
//        itemSaleP.setText("");
//
//
//        if (!itemPreviousScan.isEmpty()) {
//            itemNameBefor.setText(itemPreviousScan.get(count - 1).getItemName());
//            itemCodeBefor.setText(itemPreviousScan.get(count - 1).getItemCode());
//            itemLastBe.setText("" + itemPreviousScan.get(count - 1).getItemQty());
//
//            float AllQty = itemPreviousScan.get(count - 1).getRowIndex() + itemPreviousScan.get(count - 1).getItemQty();
//            itemAlBe.setText("" + AllQty);
//
//
//        }
//
//
//    }
//
//
//    void upDateDialog(final TextView edit1, final int switches, final EditText edit, final TextView AllQty) {
//        final Dialog dialogUpdate = new Dialog(CollectingData2.this);
//        dialogUpdate.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogUpdate.setCancelable(false);
//        dialogUpdate.setContentView(R.layout.update_layout);
//        dialogUpdate.setCanceledOnTouchOutside(false);
//        final TableLayout recipeTable = (TableLayout) dialogUpdate.findViewById(R.id.Table);
//
//        final EditText ItemCodeT;
//        ItemCodeT = (EditText) dialogUpdate.findViewById(R.id.itemCodeUp);
//
//        ItemCodeT.requestFocus();
//        edit.setEnabled(false);
//
//        final String ItemCode = ItemCodeT.getText().toString();
//
//        Button done, exit;
//        exit = (Button) dialogUpdate.findViewById(R.id.exit);
//        done = (Button) dialogUpdate.findViewById(R.id.done);
//
//        ///////////////////////////////////////////////////////////////////////////
//
//        TextWatcher item = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                recipeTable.removeAllViews();
//                if (updateOpen && !ItemCodeT.getText().toString().equals("")) {
//
//                    switch (switches) {
//                        case 0:
//                            for (int i = 0; i < itemUpdate.size(); i++) {
//                                if (itemUpdate.get(i).getItemCode().contains(ItemCodeT.getText().toString()) || itemUpdate.get(i).getItemName().contains(ItemCodeT.getText().toString())) {
//                                    insertRowUpdate(itemUpdate.get(i).getItemCode(), itemUpdate.get(i).getItemName(), String.valueOf(itemUpdate.get(i).getSerialNo()),
//                                            String.valueOf(itemUpdate.get(i).getItemQty()), recipeTable);
//                                }
//
//                            }
//                            break;
//                        case 1:
//
//                            for (int i = 0; i < itemUpdateExp.size(); i++) {
//                                if (itemUpdateExp.get(i).getItemCode().contains(ItemCodeT.getText().toString()) || itemUpdateExp.get(i).getItemName().contains(ItemCodeT.getText().toString())) {
//                                    insertRowUpdate(itemUpdateExp.get(i).getItemCode(), itemUpdateExp.get(i).getItemName(), String.valueOf(itemUpdateExp.get(i).getSerialNo()),
//                                            String.valueOf(itemUpdateExp.get(i).getItemQty()), recipeTable);
//                                }
//
//                            }
//
//                            break;
//                        case 2:
//                            for (int i = 0; i < itemUpdateExpRec.size(); i++) {
//                                if (itemUpdateExpRec.get(i).getItemCode().contains(ItemCodeT.getText().toString()) || itemUpdateExpRec.get(i).getItemName().contains(ItemCodeT.getText().toString())) {
//                                    insertRowUpdate(itemUpdateExpRec.get(i).getItemCode(), itemUpdateExpRec.get(i).getItemName(), String.valueOf(itemUpdateExpRec.get(i).getSerialNo()),
//                                            String.valueOf(itemUpdateExpRec.get(i).getItemQty()), recipeTable);
//                                }
//
//                            }
//                            break;
//
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//
//            }
//        };
//
//        ItemCodeT.addTextChangedListener(item);
//        ItemCodeT.setText(edit1.getText().toString());
//
//
//        ///////////////////////////////////////////////////////////////////////////
//
//
////        ItemCodeT.addTextChangedListener(new TextWatcher() {
////            @Override
////            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
////
////            }
////
////            @Override
////            public void onTextChanged(CharSequence s, int start, int before, int count) {
////                recipeTable.removeAllViews();
////                if (updateOpen && !ItemCodeT.getText().toString().equals("")) {
////
////                    switch (switches) {
////                        case 0:
////                            for (int i = 0; i < itemUpdate.size(); i++) {
////                                if (itemUpdate.get(i).getItemCode().contains(ItemCodeT.getText().toString()) || itemUpdate.get(i).getItemName().contains(ItemCodeT.getText().toString())) {
////                                    insertRowUpdate(itemUpdate.get(i).getItemCode(), itemUpdate.get(i).getItemName(), String.valueOf(itemUpdate.get(i).getSerialNo()),
////                                            String.valueOf(itemUpdate.get(i).getItemQty()), recipeTable);
////                                }
////
////                            }
////                            break;
////                        case 1:
////
////                            for (int i = 0; i < itemUpdateExp.size(); i++) {
////                                if (itemUpdateExp.get(i).getItemCode().contains(ItemCodeT.getText().toString()) || itemUpdateExp.get(i).getItemName().contains(ItemCodeT.getText().toString())) {
////                                    insertRowUpdate(itemUpdateExp.get(i).getItemCode(), itemUpdateExp.get(i).getItemName(), String.valueOf(itemUpdateExp.get(i).getSerialNo()),
////                                            String.valueOf(itemUpdateExp.get(i).getItemQty()), recipeTable);
////                                }
////
////                            }
////
////                            break;
////                        case 2:
////                            for (int i = 0; i < itemUpdateExpRec.size(); i++) {
////                                if (itemUpdateExpRec.get(i).getItemCode().contains(ItemCodeT.getText().toString()) || itemUpdateExpRec.get(i).getItemName().contains(ItemCodeT.getText().toString())) {
////                                    insertRowUpdate(itemUpdateExpRec.get(i).getItemCode(), itemUpdateExpRec.get(i).getItemName(), String.valueOf(itemUpdateExpRec.get(i).getSerialNo()),
////                                            String.valueOf(itemUpdateExpRec.get(i).getItemQty()), recipeTable);
////                                }
////
////                            }
////                            break;
////
////                    }
////                }
////            }
////
////            @Override
////            public void afterTextChanged(Editable s) {
////
////            }
////        });
//
//
//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Serial, newValue, itemCode;
//                boolean AllTrue = false;
//
//                for (int i = 0; i < recipeTable.getChildCount(); i++) {
//                    TableRow t = (TableRow) recipeTable.getChildAt(i);
//                    TextView ItemCode = (TextView) t.getChildAt(0);
//                    TextView upQty = (TextView) t.getChildAt(3);
//                    if (!upQty.getText().toString().equals("") && !upQty.getText().toString().equals("0")) {
//                        Serial = ItemCode.getTag().toString();
//                        newValue = upQty.getText().toString();
//                        itemCode = ItemCode.getText().toString();
//                        switch (switches) {
//                            case 0:
//                                InventDB.updateExpTable("ITEMS_INFO", newValue, Serial, itemCode);
////                                allQty.setText(InventDB.getTotal(itemCode, "ITEMS_INFO"));
//                                break;
//                            case 1:
//                                InventDB.updateExpTable("ITEM_INFO_EXP", newValue, Serial, itemCode);
////                                allQty.setText(InventDB.getTotal(itemCode, "ITEM_INFO_EXP"));
//                                break;
//                            case 2:
//                                InventDB.updateExpTable("ITEM_INFO_EXP_REC", newValue, Serial, itemCode);
////                                allQty.setText(InventDB.getTotal(itemCode, "ITEM_INFO_EXP_REC"));
//                                break;
//                        }
//
//                        if (edit1.getText().toString().equals(itemCode)) {
//                            AllTrue = true;
//                        }
//
//                    }
//
//                }
//
//                switch (switches) {
//                    case 0:
//                        collDOpen = true;
//                        if (AllTrue) {
//                            AllQty.setText(InventDB.getTotal(edit1.getText().toString(), "ITEMS_INFO"));
//                        }
//                        break;
//                    case 1:
//                        collExOpen = true;
//                        if (AllTrue) {
//                            AllQty.setText(InventDB.getTotal(edit1.getText().toString(), "ITEM_INFO_EXP"));
//                        }
//                        break;
//                    case 2:
//                        collReceipt = true;
//                        if (AllTrue) {
//                            AllQty.setText(InventDB.getTotal(edit1.getText().toString(), "ITEM_INFO_EXP_REC"));
//                        }
//                        break;
//                }
//
//                updateOpen = false;
//                edit.requestFocus();
//                edit.setEnabled(true);
//                edit.setText("");
//                dialogUpdate.dismiss();
//            }
//        });
//
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (switches) {
//                    case 0:
//                        collDOpen = true;
//                        break;
//                    case 1:
//                        collExOpen = true;
//                        break;
//                    case 2:
//                        collReceipt = true;
//                        break;
//                }
//                updateOpen = false;
//                edit.requestFocus();
//                edit.setEnabled(true);
//                edit.setText("");
//                dialogUpdate.dismiss();
//            }
//        });
//
//        dialogUpdate.show();
//
//
//    }
//
//    void insertRowUpdate(String itemCodes, String itemName, String serial, String itemQty, TableLayout recipeTable) {
//
//
//        row = new TableRow(CollectingData2.this);
//        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
//        row.setLayoutParams(lp);
//
//        for (int i = 0; i < 4; i++) {
//            final EditText editText = new EditText(CollectingData2.this);
//            final TextView textView = new TextView(CollectingData2.this);
//            if (i == 3) {
//                editText.setTextColor(ContextCompat.getColor(CollectingData2.this, R.color.ExitButton));
//                editText.setGravity(Gravity.CENTER);
//                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
//                TableRow.LayoutParams lp2 = new TableRow.LayoutParams(100, 100, 1.0f);
//                editText.setLayoutParams(lp2);
//                editText.setText("0");
////                editText.setBackgroundColor(getResources().getColor(R.color.freeButton));
//                //                editText.setId(Integer.parseInt(textId + "3"));
//                row.addView(editText);
//
//            } else {
//                switch (i) {
//                    case 0:
//                        textView.setText(itemCodes);
//                        textView.setTag(serial);
//                        break;
//                    case 1:
//                        textView.setText(itemName);
//                        break;
//                    case 2:
//                        textView.setText(itemQty);
//                        break;
//
//
//                }
//                textView.setTextColor(ContextCompat.getColor(CollectingData2.this, R.color.textColor));
//                textView.setGravity(Gravity.CENTER);
//
////                textView.setId(Integer.parseInt(textId + "" + i));
//
//                TableRow.LayoutParams lp2 = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
//                textView.setLayoutParams(lp2);
//
//
//                row.addView(textView);
//
//            }
//
//        }
////        row.setId(textId);
//        recipeTable.addView(row);
////        textId++;
//
//
//    }
//
//    void SearchDialog(final EditText itemCodeText, final int swSearch) {
//        final Dialog dialogSearch = new Dialog(CollectingData2.this);
//        dialogSearch.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogSearch.setCancelable(false);
//        dialogSearch.setContentView(R.layout.search_dialog);
//        dialogSearch.setCanceledOnTouchOutside(false);
//
//        Button exit = (Button) dialogSearch.findViewById(R.id.exitsearch);
//        final EditText itemCodeSearch = (EditText) dialogSearch.findViewById(R.id.itemCodeSearch);
//        final TableLayout tabeSearch = (TableLayout) dialogSearch.findViewById(R.id.tableSearch);
//
//
//        ArrayList<ItemCard> itemCodeCard = new ArrayList<>();
//        itemCodeCard = InventDB.getAllItemCard();
//
//        final ArrayList<ItemCard> finalItemCodeCard = itemCodeCard;
//        itemCodeSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String itemCodeReader = itemCodeSearch.getText().toString();
//                if (!itemCodeReader.equals("") && openSearch) {
//                    textId = 0;
//                    tabeSearch.removeAllViews();
//                    for (int i = 0; i < finalItemCodeCard.size(); i++) {
//                        if (finalItemCodeCard.get(i).getItemCode().contains(itemCodeReader) || finalItemCodeCard.get(i).getItemName().contains(itemCodeReader)) {
//                            insertRowSearch(finalItemCodeCard.get(i).getItemName(), finalItemCodeCard.get(i).getItemCode(), tabeSearch, dialogSearch, itemCodeText, swSearch);
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogSearch.dismiss();
//                openSearch = false;
//                switch (swSearch) {
//                    case 0:
//                        collDOpen = true;
//                        break;
//                    case 1:
//                        collExOpen = true;
//                        break;
//                    case 2:
//                        collReceipt = true;
//                        break;
//                    case 3:
//                        openSave = true;
//                        break;
//                }
//                itemCodeText.requestFocus();
//                itemCodeText.setText("");
//                textId = 0;
//            }
//        });
//
//
//        dialogSearch.show();
//
//    }
//
//    void insertRowSearch(String itemName, String itemCode, TableLayout recipeTable, final Dialog dialogFinsh, final EditText itemCodeText, final int swSearch) {
//
//
//        row = new TableRow(CollectingData2.this);
//        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
//        row.setLayoutParams(lp);
//        row.setPadding(0, 5, 0, 20);
//
//        for (int i = 0; i < 2; i++) {
//            final TextView textView = new TextView(CollectingData2.this);
//            switch (i) {
//                case 0:
//                    textView.setText(itemCode);
//                    break;
//                case 1:
//                    textView.setText(itemName);
//                    break;
//
//
//            }
//            textView.setTextColor(ContextCompat.getColor(CollectingData2.this, R.color.textColor));
//            textView.setGravity(Gravity.CENTER);
//
//            textView.setId(Integer.parseInt(textId + "" + i));
//
//            TableRow.LayoutParams lp2 = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
//            textView.setLayoutParams(lp2);
//
//            row.addView(textView);
//
//
//        }
//        row.setId(textId);
//        row.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                TableRow rows = (TableRow) v.findViewById(v.getId());
//                TextView text = (TextView) rows.getChildAt(0);
//                openSearch = false;
//                switch (swSearch) {
//                    case 0:
//                        collDOpen = true;
//                        break;
//                    case 1:
//                        collExOpen = true;
//                        break;
//                    case 2:
//                        collReceipt = true;
//                        break;
//                    case 3:
//                        openSave = true;
//                        break;
//                }
//
//                Log.e("rowid,", "...." + "" + v.getId() + "----->" + text.getText().toString());
//
//                itemCodeText.setText(text.getText().toString());
//                textId = 0;
//                dialogFinsh.dismiss();
//            }
//        });
//
//
//        recipeTable.addView(row);
//        textId++;
//    }
//
//
//    public void Clickable() {
//
//        collectData.setClickable(true);
//        collectByORG.setClickable(true);
//        transferData.setClickable(true);
//        collectingByExpiry.setClickable(true);
//        collectByReceipt.setClickable(true);
//
////        pSetting.setClickable(true);
////        changePassword.setClickable(true);
////        sendServer.setClickable(true);
////        receiveServer.setClickable(true);
////
////        newItem.setClickable(true);
////        importText.setClickable(true);
////        pBarcode.setClickable(true);
////        pShelfTag.setClickable(true);
////
////        exportText.setClickable(true);
////        ExportTransfer.setClickable(true);
////        exportExpDate.setClickable(true);
////        ExportAlternative.setClickable(true);
//    }
//
//    public void notClickable() {
//        collectData.setClickable(false);
//        collectByORG.setClickable(false);
//        transferData.setClickable(false);
//        collectingByExpiry.setClickable(false);
//        collectByReceipt.setClickable(false);
//
////        pSetting.setClickable(false);
////        changePassword.setClickable(false);
////        sendServer.setClickable(false);
////        receiveServer.setClickable(false);
////
////        newItem.setClickable(false);
////        importText.setClickable(false);
////        pBarcode.setClickable(false);
////        pShelfTag.setClickable(false);
////
////        exportText.setClickable(false);
////        ExportTransfer.setClickable(false);
////        exportExpDate.setClickable(false);
////        ExportAlternative.setClickable(false);
//    }
//
//    void alertMessageDialog(String title, String message, final int swith, final String itemName , final String ItemCode) {
//        AlertDialog.Builder dialog = new AlertDialog.Builder(CollectingData2.this);
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
//                                moveTaskToBack(true);
//
//                                break;
//                            case 1:
//                                InventDB.deleteAllItem("ITEM_CARD");
//                                Toast.makeText(CollectingData2.this, "All Item Delete ", Toast.LENGTH_SHORT).show();
////                             progressDialog();
//                                break;
//                            case 2:
//                                InventDB.delete(ItemCode,itemName);
//                                break;
//
//                        }
//                    }
//                }).show();
//    }
//
////    public void visibilityLayout(RelativeLayout ins) {
////        main.setVisibility(View.VISIBLE);
////        mainR.setVisibility(View.VISIBLE);
////        secondR.setVisibility(View.INVISIBLE);
////        collectR.setVisibility(View.INVISIBLE);
////        itemR.setVisibility(View.INVISIBLE);
////        reportR.setVisibility(View.INVISIBLE);
////        toolsR.setVisibility(View.INVISIBLE);
////
////        ins.setVisibility(View.VISIBLE);
////
////    }
//
//
//    void progressDialog() {
//
//        final ProgressDialog progressDialog = new ProgressDialog(CollectingData2.this);
//        progressDialog.setMessage("Saving Success ..."); // Setting Message
//        progressDialog.setTitle("Saving ..."); // Setting Title
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
//        progressDialog.show(); // Display Progress Dialog
//
//        progressDialog.setCancelable(true);
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(980);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                progressDialog.dismiss();
//            }
//        }).start();
//    }
//
//
//    void TimeDialog(final TextView itemExpDate) {
//
//        Calendar mcurrentDate = Calendar.getInstance();
//        int mYear = mcurrentDate.get(Calendar.YEAR);
//        int mMonth = mcurrentDate.get(Calendar.MONTH);
//        int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog mDatePicker;
//        mDatePicker = new DatePickerDialog(CollectingData2.this, new DatePickerDialog.OnDateSetListener() {
//            public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
//
//                selectedMonth = selectedMonth + 1;
//                itemExpDate.setText("" + selectedDay + "-" + selectedMonth + "-" + selectedYear);
//            }
//        }, mYear, mMonth, mDay);
//        mDatePicker.setTitle("Select Date");
//        mDatePicker.show();
//    }
//
//
////    void addDialog(final TableLayout recipeTable) {
////        final Dialog dialogAdd = new Dialog(CollectingData.this);
////        dialogAdd.requestWindowFeature(Window.FEATURE_NO_TITLE);
////        dialogAdd.setCancelable(false);
////        dialogAdd.setContentView(R.layout.add_dialog);
////        dialogAdd.setCanceledOnTouchOutside(false);
////
////        Button done, exit, delete;
////        final EditText message = (EditText) dialogAdd.findViewById(R.id.Message);
////        done = (Button) dialogAdd.findViewById(R.id.don2Add);
////        exit = (Button) dialogAdd.findViewById(R.id.exitAdd);
////
////        done.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String messsage = message.getText().toString();
////
////                row = new TableRow(CollectingData.this);
////                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
////                row.setLayoutParams(lp);
////                row.setPadding(0, 5, 0, 20);
////
////                final CheckBox textView = new CheckBox(CollectingData.this);
////                textView.setTextColor(ContextCompat.getColor(CollectingData.this, R.color.textColor));
////                TableRow.LayoutParams lp2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
////
////                textView.setLayoutParams(lp2);
////                textView.setText(messsage);
////                row.addView(textView);
////                recipeTable.addView(row);
////                //
////                dialogAdd.dismiss();
////
////
////            }
////        });
////        exit.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                dialogAdd.dismiss();
////            }
////        });
////
////        dialogAdd.show();
////
////    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        IntentResult Result = IntentIntegrator.parseActivityResult(requestCode , resultCode ,data);
//        if(Result != null){
//            if(Result.getContents() == null){
//                Log.d("MainActivity" , "cancelled scan");
//                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                Log.d("MainActivity" , "Scanned");
//                Toast.makeText(this,"Scanned -> " + Result.getContents(), Toast.LENGTH_SHORT).show();
//            }
//        }
//        else {
//            super.onActivityResult(requestCode , resultCode , data);
//        }
//    }
//
//
//
//    void initialization() {
//
////        date = (TextView) findViewById(R.id.date);
////        UserName=(TextView) findViewById(R.id.userName1);
//
////        main = (Button) findViewById(R.id.mainB);
////        main2 = (Button) findViewById(R.id.mainB2);
////        collectButton = (Button) findViewById(R.id.coll);
////        item = (Button) findViewById(R.id.item);
////        tools = (Button) findViewById(R.id.tools);
////        report = (Button) findViewById(R.id.report);
////        ExitAll = (Button) findViewById(R.id.exitALL);
////        exit = (Button) findViewById(R.id.exit2);
//
//
////        home =(Button)findViewById(R.id.home);
////        main=(Button)findViewById(R.id.men2);
//
//        exitAll2 = (Button) findViewById(R.id.exit2);
//        item= (Button) findViewById(R.id.items);
//        setting= (Button) findViewById(R.id.setting);
//        report= (Button) findViewById(R.id.report);
//
//        menue = (LinearLayout) findViewById(R.id.main);
//        exit = (Button) findViewById(R.id.exi);
//        collecting = (Button) findViewById(R.id.collec);
//
//        collecting.setOnClickListener(mainMenu);
//        exitAll2.setOnClickListener(mainMenu);
//        item.setOnClickListener(mainMenu);
//        setting.setOnClickListener(mainMenu);
//        report.setOnClickListener(mainMenu);
//
//
//
//
//        collectData = (Button) findViewById(R.id.collData);
//        collectByORG = (Button) findViewById(R.id.collByorg);
//        transferData = (Button) findViewById(R.id.transfer);
//        collectingByExpiry = (Button) findViewById(R.id.collByExp);
//        collectByReceipt = (Button) findViewById(R.id.collByRecep);
//
////        pSetting = (Button) findViewById(R.id.pSetting);
////        changePassword = (Button) findViewById(R.id.password);
////        sendServer = (Button) findViewById(R.id.sendSer);
////        receiveServer = (Button) findViewById(R.id.reciveSer);
//
////        newItem = (Button) findViewById(R.id.newItem);
////        importText = (Button) findViewById(R.id.impText);
////        pBarcode = (Button) findViewById(R.id.barcode);
////        pShelfTag = (Button) findViewById(R.id.shelf);
//
////        exportText = (Button) findViewById(R.id.expText);
////        ExportTransfer = (Button) findViewById(R.id.expTransfer);
////        exportExpDate = (Button) findViewById(R.id.expExp);
////        ExportAlternative = (Button) findViewById(R.id.expAlternative);
////        add = (Button) findViewById(R.id.add);
//
////        noteTable = (TableLayout) findViewById(R.id.Table2);
//
//
////        mainR = (RelativeLayout) findViewById(R.id.main);
////        secondR = (RelativeLayout) findViewById(R.id.second);
////        collectR = (RelativeLayout) findViewById(R.id.collectingR);
////        itemR = (RelativeLayout) findViewById(R.id.itemR);
////        reportR = (RelativeLayout) findViewById(R.id.reportR);
////        toolsR = (RelativeLayout) findViewById(R.id.ToolsR);
//
////        collectButton.setOnClickListener(showOnClick);
////        item.setOnClickListener(showOnClick);
////        tools.setOnClickListener(showOnClick);
////        report.setOnClickListener(showOnClick);
////        exit.setOnClickListener(showOnClick);
//
//        collectData.setOnClickListener(showDialogOnClick);
//        collectByORG.setOnClickListener(showDialogOnClick);
//        transferData.setOnClickListener(showDialogOnClick);
//        collectingByExpiry.setOnClickListener(showDialogOnClick);
//        collectByReceipt.setOnClickListener(showDialogOnClick);
//
////        pSetting.setOnClickListener(showDialogOnClick);
////        changePassword.setOnClickListener(showDialogOnClick);
////        sendServer.setOnClickListener(showDialogOnClick);
////        receiveServer.setOnClickListener(showDialogOnClick);
////
////        newItem.setOnClickListener(showDialogOnClick);
////        importText.setOnClickListener(showDialogOnClick);
////        pBarcode.setOnClickListener(showDialogOnClick);
////        pShelfTag.setOnClickListener(showDialogOnClick);
////
////        exportText.setOnClickListener(showDialogOnClick);
////        ExportTransfer.setOnClickListener(showDialogOnClick);
////        exportExpDate.setOnClickListener(showDialogOnClick);
////        ExportAlternative.setOnClickListener(showDialogOnClick);
//
////        visibilityLayout(mainR);
////        secondR.setVisibility(View.VISIBLE);
////        ExitAll.setVisibility(View.INVISIBLE);
//        Clickable();
//
////        main.setOnClickListener(mainClick);
////        main2.setOnClickListener(mainClick);
//    }
//
//    private BoomMenuButton initBmb(int res) {
//        BoomMenuButton bmb = (BoomMenuButton) findViewById(res);
//        assert bmb != null;
//        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
//            bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());
//
//        bmb.setOnBoomListener(new OnBoomListener() {
//            @Override
//            public void onClicked(int index, BoomButton boomButton) {
//
//                switch (index){
//                    case 0:
////                        Intent coll = new Intent(CollectingData.this, CollectingData.class);
////                        startActivity(coll);
//                        break;
//                    case 1:
//                        Intent item = new Intent(CollectingData2.this, Item.class);
//                        startActivity(item);
//
//                        break;
//                    case 2:
//                        Intent report = new Intent(CollectingData2.this, Report.class);
//                        startActivity(report);
//                        break;
//                    case 3:
//                        Intent tools = new Intent(CollectingData2.this, Tools.class);
//                        startActivity(tools);
//                        break;
//                    case 4:
//                        Toast.makeText(CollectingData2.this, "index"+index, Toast.LENGTH_SHORT).show();
//
//                        break;
//                    case 5:
//                        alertMessageDialog("Exit From App ...", "you are sorry you want to Exit From App ?", 0, "", "");
//                        break;
//
//                }
//
//
//            }
//
//            @Override
//            public void onBackgroundClick() {
//
//            }
//
//            @Override
//            public void onBoomWillHide() {
//
//            }
//
//            @Override
//            public void onBoomDidHide() {
//
//            }
//
//            @Override
//            public void onBoomWillShow() {
//
//            }
//
//            @Override
//            public void onBoomDidShow() {
//
//            }
//        });
//        return bmb;
//    }
//
//
//}
