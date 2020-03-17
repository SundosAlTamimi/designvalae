package com.example.user54.InventoryApp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user54.InventoryApp.Model.ItemCard;
import com.example.user54.InventoryApp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Item2 extends AppCompatActivity {

    private static final int READ_REQUEST_CODE = 42;

    Button main, home, newItem, importText, pBarcode, pShelfTag,
            item, tools, report,exit,exitAll2,setting,collecting;
    boolean updateOpen = false, openSearch = false, openSave = false;
    int textId = 0;
    String today;
    InventoryDatabase InventDB;
    ArrayList<ItemCard> itemCardsList = new ArrayList<ItemCard>();
    Dialog dialog;

    TextView pathNameFr;
    TableRow row;
    LinearLayout menue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_menu);

        InventDB = new InventoryDatabase(Item2.this);

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


        Date currentTimeAndDate = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        today = df.format(currentTimeAndDate);

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
                    Intent item = new Intent(Item2.this, CollectingData.class);
                    startActivity(item);
                    finish();
                    break;
                case R.id.items:

                    break;
                case R.id.report:
                    Intent report = new Intent(Item2.this, Report.class);
                    startActivity(report);
                    finish();
                    break;
                case R.id.setting:
                    Intent tools = new Intent(Item2.this, Tools.class);
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
//
                case R.id.shelf:
                    showPrintShelfTagDialog();
                    break;
                case R.id.newItem:
                    openSave = true;
                    showNewItemDialog(0);
                    break;
                case R.id.impText:
                    showImportFromTextDialog();
                    break;
                case R.id.barcode:
                    showPrintBarcodeDialog();
                    break;
//
            }
        }
    };


    void showImportFromTextDialog() {
        dialog = new Dialog(Item2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.import_iteams_from_text_file);
        dialog.setCanceledOnTouchOutside(false);

        Button exit,open ;
        TextView pathName;

        exit = (Button) dialog.findViewById(R.id.exit);
        open = (Button) dialog.findViewById(R.id.openPath);

        pathName=(TextView)dialog.findViewById(R.id.path1);
        pathNameFr=pathName;
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();


            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    void showPrintBarcodeDialog() {
        dialog = new Dialog(Item2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.print_item_barcode);
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


    void showPrintShelfTagDialog() {
        dialog = new Dialog(Item2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.print_shelf_tag);
        dialog.setCanceledOnTouchOutside(true);

        final int[] count1 = {1};
        final TextView countText;
        Button exit;
        ImageButton upCount, downCount;

        exit = (Button) dialog.findViewById(R.id.exit);
        upCount = (ImageButton) dialog.findViewById(R.id.up);
        downCount = (ImageButton) dialog.findViewById(R.id.down);
        countText = (TextView) dialog.findViewById(R.id.countT);

        upCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1[0]++;
                countText.setText("" + count1[0]);
            }
        });
        downCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(countText.getText().toString()) != 1) {
                    count1[0]--;
                    countText.setText("" + count1[0]);
                } else
                    Toast.makeText(Item2.this, "count down under value 1 ", Toast.LENGTH_SHORT).show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    void showNewItemDialog(final int tr) {
        final Dialog dialogNew = new Dialog(Item2.this);
        dialogNew.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogNew.setCancelable(false);
        dialogNew.setContentView(R.layout.new_item);
        dialogNew.setCanceledOnTouchOutside(false);


        final Button exit, save, clear, serach, deleteItem, deleteAllItem;
        final EditText itemCodeNew, itemNameNew,itemPrice;

        itemCodeNew = (EditText) dialogNew.findViewById(R.id.itemCNew);
        itemNameNew = (EditText) dialogNew.findViewById(R.id.itemNameNew);
        itemPrice=(EditText) dialogNew.findViewById(R.id.itemPrice);
//        ArrayList<ItemCard> itemCardList = new ArrayList<>();

        exit = (Button) dialogNew.findViewById(R.id.exit);
        save = (Button) dialogNew.findViewById(R.id.saveNew);
        clear = (Button) dialogNew.findViewById(R.id.clearNew);
        serach = (Button) dialogNew.findViewById(R.id.searchNew);
        deleteItem = (Button) dialogNew.findViewById(R.id.deleteItem);
        deleteAllItem = (Button) dialogNew.findViewById(R.id.deleteAllItem);


        itemCodeNew.requestFocus();

        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!itemCodeNew.getText().toString().equals("") && !itemNameNew.getText().toString().equals("")) {
                    alertMessageDialog("Delete ... ", "you are sorry you want to Delete this Item ..." +
                            "\n \n" + "Item Name : " + itemNameNew.getText().toString() + " \n Item Code : " + itemCodeNew.getText().toString() + " \n\n from  Table ?", 2, itemNameNew.getText().toString(), itemCodeNew.getText().toString());
                } else
                    Toast.makeText(Item2.this, "please Insert All data in Filed .", Toast.LENGTH_SHORT).show();
            }
        });

        deleteAllItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessageDialog("Delete ... ", "you are sorry you want to Delete All Items in Table ?", 1, "", "");
            }
        });


        serach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch = true;
                openSave = false;
                SearchDialog(itemCodeNew, 3);
            }
        });

        itemCodeNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean isItemFound = false;

                String itemCode = itemCodeNew.getText().toString();
                String itemName = itemNameNew.getText().toString();


                if (!itemCodeNew.getText().toString().equals("") && openSave) {
                    itemCardsList = InventDB.getAllItemCard();

                    for (int i = 0; i < itemCardsList.size(); i++) {
                        if (itemCardsList.get(i).getItemCode().equals(itemCode)) {
                            isItemFound = true;
                            itemNameNew.setText(itemCardsList.get(i).getItemName());
                            itemPrice.setText(itemCardsList.get(i).getFDPRC());
                            break;

                        }
                    }

                    if (!isItemFound) {

//                        new Handler().post(new Runnable() {
//                            @Override
//                            public void run() {
//                                itemNameNew.requestFocus();
//                            }
//                        });

                        save.setClickable(true);
                    } else {
                        save.setClickable(false);
                        showAlertDialog("This item Found please add another item ");
                    }


                }


            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!itemNameNew.getText().toString().equals("")) {
                    ItemCard itemCard = new ItemCard();

                    itemCard.setItemCode(itemCodeNew.getText().toString());
                    itemCard.setItemName(itemNameNew.getText().toString());
                    itemCard.setFDPRC(itemPrice.getText().toString());

                    InventDB.addItemcardTable(itemCard);
                    progressDialog();
                    itemCodeNew.setText("");
                    itemNameNew.setText("");
                    itemPrice.setText("");
                    itemCodeNew.requestFocus();

                } else {
                    Toast.makeText(Item2.this, "Please insert all data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCodeNew.setText("");
                itemNameNew.setText("");
                itemPrice.setText("");
                itemCodeNew.requestFocus();
                save.setClickable(true);
            }
        });


//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                boolean isItemFound = false;
////                ArrayList<ItemCard> itemCardList = new ArrayList<>();
////                String itemCode = itemCodeNew.getText().toString();
////                String itemName = itemNameNew.getText().toString();
////
////                if (!itemCodeNew.getText().toString().equals("") && !itemNameNew.getText().toString().equals("") && openSave) {
////
////                    itemCardList = InventDB.getAllItemCard();
////
////                    for (int i = 0; i < itemCardList.size(); i++) {
////                        if (itemCardList.get(i).getItemCode().equals(itemCode)) {
////
////                            isItemFound = true;
////                            break;
////
////                        }
////                    }
////
////                    if (!isItemFound) {
//
//                        ItemCard itemCard = new ItemCard();
//
//                        itemCard.setItemCode(itemCode);
//                        itemCard.setItemName(itemName);
//
//                        InventDB.addItemcardTable(itemCard);
//                        progressDialog();
////                    itemCodes.requestFocus();
////                    itemCodes.setText("");
//
//
////                    } else {
////                        showAlertDialog("This item Found please add another item ");
////                    }
////
////
////                } else {
////                    Toast.makeText(CollectingData.this, "Please insert all data", Toast.LENGTH_SHORT).show();
////                }
//                itemCodeNew.requestFocus();
//                itemCodeNew.setText("");
//                itemNameNew.setText("");
//            }
//        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSave = false;
                switch (tr) {
                    case 0:
                        break;
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
                }

                dialogNew.dismiss();
            }
        });

        dialogNew.show();
    }


    void alertMessageDialog(String title, String message, final int swith, final String itemName, final String ItemCode) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Item2.this);
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
                            case 1:
                                InventDB.deleteAllItem("ITEM_CARD");
                                Toast.makeText(Item2.this, "All Item Delete ", Toast.LENGTH_SHORT).show();
//                             progressDialog();
                                break;
                            case 2:
                                InventDB.delete(ItemCode, itemName);
                                break;

                        }
                    }
                }).show();
    }

    void progressDialog() {

        final ProgressDialog progressDialog = new ProgressDialog(Item2.this);
        progressDialog.setMessage("Saving Success ..."); // Setting Message
        progressDialog.setTitle("Saving ..."); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog

        progressDialog.setCancelable(true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(980);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }



    void SearchDialog(final EditText itemCodeText, final int swSearch) {
        final Dialog dialogSearch = new Dialog(Item2.this);
        dialogSearch.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSearch.setCancelable(false);
        dialogSearch.setContentView(R.layout.search_dialog);
        dialogSearch.setCanceledOnTouchOutside(false);

        Button exit = (Button) dialogSearch.findViewById(R.id.exitsearch);
        final EditText itemCodeSearch = (EditText) dialogSearch.findViewById(R.id.itemCodeSearch);
        final TableLayout tabeSearch = (TableLayout) dialogSearch.findViewById(R.id.tableSearch);


        ArrayList<ItemCard> itemCodeCard = new ArrayList<>();
        itemCodeCard = InventDB.getAllItemCard();

        final ArrayList<ItemCard> finalItemCodeCard = itemCodeCard;
        itemCodeSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String itemCodeReader = itemCodeSearch.getText().toString();
                if (!itemCodeReader.equals("") && openSearch) {
                    textId = 0;
                    tabeSearch.removeAllViews();
                    for (int i = 0; i < finalItemCodeCard.size(); i++) {
                        if (finalItemCodeCard.get(i).getItemCode().contains(itemCodeReader) || finalItemCodeCard.get(i).getItemName().contains(itemCodeReader)) {
                            insertRowSearch(finalItemCodeCard.get(i).getItemName(), finalItemCodeCard.get(i).getItemCode(), tabeSearch, dialogSearch, itemCodeText, swSearch);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSearch.dismiss();
                openSearch = false;
                switch (swSearch) {
                    case 3:
                        openSave = true;
                        break;
                }
                itemCodeText.requestFocus();
                itemCodeText.setText("");
                textId = 0;
            }
        });


        dialogSearch.show();

    }

    void insertRowSearch(String itemName, String itemCode, TableLayout recipeTable, final Dialog dialogFinsh, final EditText itemCodeText, final int swSearch) {


        row = new TableRow(Item2.this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
        row.setLayoutParams(lp);
        row.setPadding(0, 5, 0, 20);

        for (int i = 0; i < 2; i++) {
            final TextView textView = new TextView(Item2.this);
            switch (i) {
                case 0:
                    textView.setText(itemCode);
                    break;
                case 1:
                    textView.setText(itemName);
                    break;


            }
            textView.setTextColor(ContextCompat.getColor(Item2.this, R.color.textColor));
            textView.setGravity(Gravity.CENTER);

            textView.setId(Integer.parseInt(textId + "" + i));

            TableRow.LayoutParams lp2 = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
            textView.setLayoutParams(lp2);

            row.addView(textView);


        }
        row.setId(textId);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TableRow rows = (TableRow) v.findViewById(v.getId());
                TextView text = (TextView) rows.getChildAt(0);
                openSearch = false;
                switch (swSearch) {
                    case 3:
                        openSave = true;
                        break;
                }

                Log.e("rowid,", "...." + "" + v.getId() + "----->" + text.getText().toString());

                itemCodeText.setText(text.getText().toString());
                textId = 0;
                dialogFinsh.dismiss();
            }
        });


        recipeTable.addView(row);
        textId++;
    }


    void showAlertDialog(String TextMessage) {
        final Dialog dialogAlert = new Dialog(Item2.this);
        dialogAlert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogAlert.setCancelable(false);
        dialogAlert.setContentView(R.layout.alert_dialog_not_found);
        dialogAlert.setCanceledOnTouchOutside(false);
        TextView textMessage = (TextView) dialogAlert.findViewById(R.id.alertMessage);
        Button exitAlert = (Button) dialogAlert.findViewById(R.id.exitAlert);
        textMessage.setText(TextMessage);

        dialogAlert.show();

        exitAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAlert.dismiss();
            }
        });
    }



    public void openFolder(){
        Intent chooser = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(Environment.getDownloadCacheDirectory().getPath().toString());
        chooser.addCategory(Intent.CATEGORY_OPENABLE);
        chooser.setDataAndType(uri, "*/*");
// startActivity(chooser);
        try {
            startActivityForResult(chooser, READ_REQUEST_CODE);
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("123*", "Uri: " + uri.toString());

                pathNameFr.setText( uri.toString());

            }
        }
    }


    public void Clickable() {

        newItem.setClickable(true);
        importText.setClickable(true);
        pBarcode.setClickable(true);
        pShelfTag.setClickable(true);


    }

    public void notClickable() {

        newItem.setClickable(false);
        importText.setClickable(false);
        pBarcode.setClickable(false);
        pShelfTag.setClickable(false);

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



        home = (Button) findViewById(R.id.home);
        main = (Button) findViewById(R.id.men2);


        newItem = (Button) findViewById(R.id.newItem);
        importText = (Button) findViewById(R.id.impText);
        pBarcode = (Button) findViewById(R.id.barcode);
        pShelfTag = (Button) findViewById(R.id.shelf);

        newItem.setOnClickListener(showDialogOnClick);
        importText.setOnClickListener(showDialogOnClick);
        pBarcode.setOnClickListener(showDialogOnClick);
        pShelfTag.setOnClickListener(showDialogOnClick);

        Clickable();

    }


}
