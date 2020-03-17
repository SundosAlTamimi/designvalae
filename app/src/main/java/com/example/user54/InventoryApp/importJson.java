package com.example.user54.InventoryApp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.user54.InventoryApp.Model.ItemCard;
import com.example.user54.InventoryApp.Model.ItemSwitch;
import com.example.user54.InventoryApp.Model.MainSetting;
import com.example.user54.InventoryApp.Model.Stk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.example.user54.InventoryApp.Item.textItemName;
import static com.example.user54.InventoryApp.Item.textView;
import static com.example.user54.InventoryApp.LogIn.intentControl;
import static java.net.Proxy.Type.HTTP;

public class importJson {

    private Context context;
    private ProgressDialog progressDialog;
    private ProgressDialog progressDialogSave;
    private JSONObject obj;
    InventoryDatabase dbHandler;
    String itemCode;
    String JsonResponseSave;
    String JsonResponseSaveSwitch;
    SweetAlertDialog pd = null;



    public importJson(Context context,String itemCodes,int is) {//, JSONObject obj
//        this.obj = obj;
        this.context = context;
        dbHandler = new InventoryDatabase(context);
        this.itemCode=itemCodes;
        if(is!=0) {
            pd = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            pd.getProgressHelper().setBarColor(Color.parseColor("#FDD835"));
            pd.setTitleText(context.getResources().getString(R.string.importData));
            pd.setCancelable(false);
            pd.show();
        }
//        progressDialog = new ProgressDialog(context,R.style.MyTheme);
//            progressDialog.setCancelable(false);
//            progressDialog.setMessage("Loading...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setProgress(0);

    }

    public void startSending(String flag) {
//        Log.e("check",flag);

        if (flag.equals("ItemCard"))
            new SyncItemCard().execute();

        if (flag.equals("ItemSwitch"))
            new SyncItemSwitch().execute();

        if (flag.equals("ItemPrice"))
            new SyncItemPrice().execute();
        if (flag.equals("GetStory"))
            new SyncGetStor().execute();


    }

    private class SyncItemCard extends AsyncTask<String, String, String> {
        private String JsonResponse = null;
        private HttpURLConnection urlConnection = null;
        private BufferedReader reader = null;

        @Override
        protected void onPreExecute() {

//            progressDialog = new ProgressDialog(context,R.style.MyTheme);
//            progressDialog.setCancelable(false);
//            progressDialog.setMessage("Loading...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setProgress(0);
//            progressDialog.show();
//            pd = ProgressDialog.show(context, "title", "loading", true);
            pd.getProgressHelper().setBarColor(Color.parseColor("#FDD835"));
            pd.setTitleText(context.getResources().getString(R.string.importitemcard));


            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {///GetModifer?compno=736&compyear=2019
            try {
                final List<MainSetting>mainSettings=dbHandler.getAllMainSetting();
                String ip="";
                if(mainSettings.size()!=0) {
                    ip= mainSettings.get(0).getIP();
                }

//
                String link = "http://"+ip + "/GetJRDITEMS";
                // ITEM_CARD
                String max=dbHandler.getMaxInDate("ITEM_CARD");

                String maxInDate="";
                if(max.equals("-1")) {
                    maxInDate="05/03/1991";
                }else{
                    maxInDate=max.substring(0,10);
                    String date[]=maxInDate.split("-");
                    maxInDate=date[2]+"/"+date[1]+"/"+date[0];
                    Log.e("split ",""+maxInDate);
                }
                String data = "MAXDATE=" + URLEncoder.encode(maxInDate, "UTF-8")  ;
////

                URL url = new URL(link);
                Log.e("urlString = ",""+url.toString());

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");



                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(data);
                wr.flush();
                wr.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                while ((JsonResponse = bufferedReader.readLine()) != null) {
                    stringBuffer.append(JsonResponse + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.e("tag", "ItemOCode -->" + stringBuffer.toString());

                return stringBuffer.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("tag", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String JsonResponse) {
            super.onPostExecute(JsonResponse);

            if (JsonResponse != null && JsonResponse.contains("ItemOCode")) {
                Log.e("tag_ItemOCode", "****Success");
//                progressDialog.dismiss();
                JsonResponseSave=JsonResponse;
                 new SaveItemCard().execute();
//                try {
//
//                    JSONArray parentArray = new JSONArray(JsonResponse);
//
//
//                    List<ItemCard> itemCard=new ArrayList<>();
//
//                    for (int i = 0; i < parentArray.length(); i++) {
//                        JSONObject finalObject = parentArray.getJSONObject(i);
//// "ItemOCode": "0829274512282",
////    "ItemNameA": "MEOW MIX CUPS PATE WHITE FISH & SALMON 78G*12",
////    "ItemNameE": "MEOW MIX CUPS PATE WHITE FISH & SALMON 78G*12",
////    "ItemG": "Grocery-(بقالة)",
////    "TAXPERC": "16",
////    "SalePrice": "0",
////    "LLCPrice": "0.73",
////    "AVLQTY": "0",
////    "F_D": "1",
////    "ItemK": "مستلزمات الحيوانات",
////    "ItemL": "",
////    "ITEMDIV": "",
////    "ITEMGS": ""
//
//
//
//                        ItemCard obj = new ItemCard();
//                        obj.setItemCode(finalObject.getString("ItemOCode"));
//                        obj.setItemName(finalObject.getString("ItemNameA"));
////                        obj.setit(finalObject.getString("ItemNameE"));
//                        obj.setItemG(finalObject.getString("ItemG"));
////                        obj.set(finalObject.getString("TAXPERC"));
//                        obj.setSalePrc(finalObject.getString("SalePrice"));
////
//
////                        obj.set(finalObject.getString("LLCPrice"));
//                        obj.setAVLQty(finalObject.getString("AVLQTY"));
//                        obj.setFDPRC(finalObject.getString("F_D"));
//
//                        obj.setItemK(finalObject.getString("ItemK"));
//                        obj.setItemL(finalObject.getString("ItemL"));
//                        obj.setItemDiv(finalObject.getString("ITEMDIV"));
//
//                        obj.setItemGs(finalObject.getString("ITEMGS"));
//
//
//                        itemCard.add(obj);
//
//                    }
//
////
//                    dbHandler.deleteAllItem("ITEM_CARD");
//                    for (int i = 0; i < itemCard.size(); i++) {
//                        dbHandler.addItemcardTable(itemCard.get(i));
//                    }
//
//Log.e("tag_itemCard", "****saveSuccess");
////                    intentControl.setText("@");
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }else if (JsonResponse != null && JsonResponse.contains("No Data Found.")){
                new SyncItemSwitch().execute();
            }
            else {
                Log.e("tag_itemCard", "****Failed to export data");
//                Toast.makeText(context, "Failed to Get data", Toast.LENGTH_SHORT).show();
                if(pd!=null) {
                    pd.dismiss();
                    new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText(context.getResources().getString(R.string.ops))
                            .setContentText(context.getResources().getString(R.string.fildtoimportitemswitch))
                            .show();
                }


            }

        }
    }

    private class SyncItemSwitch extends AsyncTask<String, String, String> {
        private String JsonResponse = null;
        private HttpURLConnection urlConnection = null;
        private BufferedReader reader = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialog = new ProgressDialog(context,R.style.MyTheme);
//            progressDialog.setCancelable(false);
//            progressDialog.setMessage("Loading...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setProgress(0);
//            progressDialog.show();

            pd.getProgressHelper().setBarColor(Color.parseColor("#FDD835"));
            pd.setTitleText(context.getResources().getString(R.string.importitemswitch));

        }

        @Override
        protected String doInBackground(String... params) {
            try {


                final List<MainSetting>mainSettings=dbHandler.getAllMainSetting();
                String ip="";
                if(mainSettings.size()!=0) {
                    ip=mainSettings.get(0).getIP();
                }
                String link = "http://"+ip + "/GetJRDITEMSWICH";

                // ITEM_CARD
                String max=dbHandler.getMaxInDate("ITEM_SWITCH");
                String maxInDate="";
                if(max.equals("-1")) {
                    maxInDate="05/03/2020";
                }else{
                    maxInDate=max.substring(0,10);
                    String date[]=maxInDate.split("-");
                    maxInDate=date[2]+"/"+date[1]+"/"+date[0];
                    Log.e("splitSwitch ",""+maxInDate);
                }
                String data = "MAXDATE=" + URLEncoder.encode(maxInDate, "UTF-8");
////
                URL url = new URL(link);


                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(data);
                wr.flush();
                wr.close();
                Log.e("url____",""+link+data);

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                while ((JsonResponse = bufferedReader.readLine()) != null) {
                    stringBuffer.append(JsonResponse + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.e("tag", "TAG_itemSwitch -->" + stringBuffer.toString());

                return stringBuffer.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("tag", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String JsonResponse) {
            super.onPostExecute(JsonResponse);

            if (JsonResponse != null && JsonResponse.contains("ItemOCode")) {
                Log.e("TAG_itemSwitch", "****Success");

                JsonResponseSaveSwitch=JsonResponse;
                new SaveItemSwitch().execute();

            }
            else if (JsonResponse != null && JsonResponse.contains("No Data Found.")){
                new SyncGetStor().execute();
            }else {
                Log.e("TAG_itemSwitch", "****Failed to export data");
//                progressDialog.dismiss();
                if(pd!=null) {
                    pd.dismiss();
                    new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText(context.getResources().getString(R.string.ops))
                            .setContentText(context.getResources().getString(R.string.faildtoimport))
                            .show();
                }
            }

        }
    }

    private class SyncItemPrice extends AsyncTask<String, String, String> {
        private String JsonResponse = null;
        private HttpURLConnection urlConnection = null;
        private BufferedReader reader = null;
        SweetAlertDialog pdItem=null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialog = new ProgressDialog(context,R.style.MyTheme);
//            progressDialog.setCancelable(false);
//            progressDialog.setMessage("Loading...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setProgress(0);
//            progressDialog.show();

             pdItem = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            pdItem.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pdItem.setTitleText(context.getResources().getString(R.string.itemprice));
            pdItem.setCancelable(false);
            pdItem.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                final List<MainSetting>mainSettings=dbHandler.getAllMainSetting();
                String ip="";
                if(mainSettings.size()!=0) {
                    ip= mainSettings.get(0).getIP();
                }
                String link = "http://"+ip + "/GetJRDITEMPRICE";
//                String link = controll.URL + "GetJRDITEMPRICE";
//
                String data = "ITEMCODE=" + URLEncoder.encode(itemCode, "UTF-8") ;

//
                URL url = new URL(link);
                Log.e("TAG_itemPrice", "link -->" +link);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(data);
                wr.flush();
                wr.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                while ((JsonResponse = bufferedReader.readLine()) != null) {
                    stringBuffer.append(JsonResponse + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.e("tag", "TAG_itemPrice -->" + stringBuffer.toString());

                return stringBuffer.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("tag", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String JsonResponse) {
            super.onPostExecute(JsonResponse);

            if (JsonResponse != null && JsonResponse.contains("F_D")) {
                Log.e("TAG_itemPrice", "****Success");

                try {

                    JSONArray parentArray = new JSONArray(JsonResponse);

                    Log.e("TAG_itemPrice", " "+parentArray.toString());
                    Log.e("TAG_itemPriceR", " "+JsonResponse);
                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);


                        controll.F_D= finalObject.getString("F_D");
                        controll.Item_name= finalObject.getString("ItemNameA");
                        textView.setText(controll.F_D);
                        textItemName.setText(controll.Item_name);
                                Log.e("TAG_itemPrice", "****getSuccess"+controll.F_D+"name= "+ controll.Item_name);

                    }

                    if(pdItem !=null) {
                        pdItem.dismissWithAnimation();
//                        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
//                                .setTitleText(context.getResources().getString(R.string.save_SUCCESS))
//                                .setContentText(context.getResources().getString(R.string.importSuc))
//                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if(JsonResponse != null && JsonResponse.contains("No Parameter Found.")){
                Log.e("TAG_itemPrice", "****No Parameter Found.");

                if(pdItem !=null) {
                    pdItem.dismissWithAnimation();
                }

                textView.setText("*");



            } else {
                Log.e("TAG_itemPrice", "****Failed to export data");

                if(pdItem !=null) {
                    pdItem.dismissWithAnimation();
                }

                textView.setText("-1");
            }
//            progressDialog.dismiss();
        }
    }


    private class SyncGetStor extends AsyncTask<String, String, String> {
        private String JsonResponse = null;
        private HttpURLConnection urlConnection = null;
        private BufferedReader reader = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialog = new ProgressDialog(context,R.style.MyTheme);
//            progressDialog.setCancelable(false);
//            progressDialog.setMessage("Loading...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setProgress(0);
//            progressDialog.show();

            pd.getProgressHelper().setBarColor(Color.parseColor("#FDD835"));
            pd.setTitleText(context.getResources().getString(R.string.importstor));

        }

        @Override
        protected String doInBackground(String... params) {
            try {


                final List<MainSetting>mainSettings=dbHandler.getAllMainSetting();
                String ip="";
                if(mainSettings.size()!=0) {
                    ip=mainSettings.get(0).getIP();
                }
                String link = "http://"+ip + "/GetSore";

                //
//                String data = "compno=" + URLEncoder.encode("736", "UTF-8") + "&" +
//                        "compyear=" + URLEncoder.encode("2019", "UTF-8") ;
////
                URL url = new URL(link);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");

//                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
//                wr.writeBytes(data);
//                wr.flush();
//                wr.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                while ((JsonResponse = bufferedReader.readLine()) != null) {
                    stringBuffer.append(JsonResponse + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.e("tag", "TAG_GetStor -->" + stringBuffer.toString());

                return stringBuffer.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("tag", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String JsonResponse) {
            super.onPostExecute(JsonResponse);

            if (JsonResponse != null && JsonResponse.contains("STORENO")) {
                Log.e("TAG_GetStor", "****Success");

                pd.getProgressHelper().setBarColor(Color.parseColor("#1F6381"));
                pd.setTitleText(context.getResources().getString(R.string.storesave));
                try {

                    JSONArray parentArray = new JSONArray(JsonResponse);


                    List<Stk> stks=new ArrayList<>();

                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);

                        Stk obj = new Stk();

                        obj.setStkNo(finalObject.getString("STORENO"));
                        obj.setStkName(finalObject.getString("STORENAME"));


                        stks.add(obj);

                    }

//
                    dbHandler.deleteAllItem("STK");
                    for (int i = 0; i < stks.size(); i++) {
                        dbHandler.addStory(stks.get(i));
                    }

                    Log.e("TAG_GetStor", "****SaveSuccess");
                    pd.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pd.setTitleText(context.getResources().getString(R.string.storeSave));

                    if(pd!=null) {
                        pd.dismiss();

                        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText(context.getResources().getString(R.string.save_SUCCESS))
                                .setContentText(context.getResources().getString(R.string.importSuc))
                                .show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Log.e("TAG_GetStor", "****Failed to export data");
                if(pd!=null) {
                    pd.dismiss();
                    new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText(context.getResources().getString(R.string.ops))
                            .setContentText(context.getResources().getString(R.string.faildstore))
                            .show();
                }
            }
//            progressDialog.dismiss();

        }
    }


    private class SaveItemCard extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialogSave = new ProgressDialog(context,R.style.MyTheme);
//            progressDialogSave.setCancelable(false);
//            progressDialogSave.setMessage("Loading Save in DataBase...");
//            progressDialogSave.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialogSave.setProgress(0);
//            progressDialogSave.show();

            pd.getProgressHelper().setBarColor(Color.parseColor("#1F6381"));
            pd.setTitleText(context.getResources().getString(R.string.savingindb));

        }

        @Override
        protected String doInBackground(String... params) {///GetModifer?compno=736&compyear=2019

            try {
                Log.e("tag_itemCard", "****inDataBaseSave");
                JSONArray parentArray = new JSONArray(JsonResponseSave);


                List<ItemCard> itemCard=new ArrayList<>();
                List<ItemCard> itemCard2=dbHandler.getAllItemCard();
//                boolean stopBollen=true;
//if(itemCard2.size()==0){
//    dbHandler.deleteAllItem("ITEM_CARD");
//    stopBollen=false;
//}


                for (int i = 0; i < parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);

                    ItemCard obj = new ItemCard();
                    obj.setItemCode(finalObject.getString("ItemOCode"));
                    obj.setItemName(finalObject.getString("ItemNameA"));
//                        obj.setit(finalObject.getString("ItemNameE"));
                    obj.setItemG(finalObject.getString("ItemG"));
//                        obj.set(finalObject.getString("TAXPERC"));
                    obj.setSalePrc(finalObject.getString("SalePrice"));
//

//                        obj.set(finalObject.getString("LLCPrice"));
                    obj.setAVLQty(finalObject.getString("AVLQTY"));
                    obj.setFDPRC(finalObject.getString("F_D"));

                    obj.setItemK(finalObject.getString("ItemK"));
                    obj.setItemL(finalObject.getString("ItemL"));
                    obj.setItemDiv(finalObject.getString("ITEMDIV"));

                    obj.setItemGs(finalObject.getString("ITEMGS"));
                    obj.setInDate(finalObject.getString("InDate"));

                    itemCard.add(obj);
//                    if(stopBollen){
                        dbHandler.deleteItemCardByItemCode(itemCard.get(i).getItemCode());
//                    }

//                    dbHandler.addItemcardTable(itemCard.get(i));



                }
                dbHandler.addItemcardTableTester(itemCard);

//
//                dbHandler.deleteAllItem("ITEM_CARD");
//
//                for (int i = 0; i < itemCard.size(); i++) {
//                    dbHandler.deleteItemCardByItemCode(itemCard.get(i).getItemCode());
//                    dbHandler.addItemcardTable(itemCard.get(i));
//
//                }
//                dbHandler.addItemcardTableTest(itemCard);

                Log.e("tag_itemCard", "****saveSuccess");


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String JsonResponse) {
            super.onPostExecute(JsonResponse);
            Toast.makeText(context, "Save Item Card Success", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "Start Import Item Switch", Toast.LENGTH_SHORT).show();
            pd.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pd.setTitleText(context.getResources().getString(R.string.saveitemcard));

            new SyncItemSwitch().execute();

//            progressDialog.dismiss();
        }
    }



    private class SaveItemSwitch extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialogSave = new ProgressDialog(context,R.style.MyTheme);
//            progressDialogSave.setCancelable(false);
//            progressDialogSave.setMessage("Loading Save in DataBase...");
//            progressDialogSave.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialogSave.setProgress(0);
//            progressDialogSave.show();
            pd.getProgressHelper().setBarColor(Color.parseColor("#1F6381"));
            pd.setTitleText(context.getResources().getString(R.string.savingitemswitch));

        }

        @Override
        protected String doInBackground(String... params) {///GetModifer?compno=736&compyear=2019


                Log.e("TAG_itemSwitch", "****Success");

                try {

                    JSONArray parentArray = new JSONArray(JsonResponseSaveSwitch);


                    List<ItemSwitch> itemCard=new ArrayList<>();

                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);

                        ItemSwitch obj = new ItemSwitch();
//                        obj.se(finalObject.getString("CoNo"));
                        obj.setItemOCode(finalObject.getString("ItemOCode"));
                        obj.setItemNCode(finalObject.getString("ItemNCode"));
                        obj.setItemNameA(finalObject.getString("ItemNameA"));
                        obj.setItemNameE(finalObject.getString("ItemNameE"));
                        obj.setInDate(finalObject.getString("INDATE"));

                        itemCard.add(obj);
                        dbHandler.deleteItemSwitchByItemCode(itemCard.get(i).getItemOCode(),itemCard.get(i).getItemNCode());

                    }
//                    dbHandler.deleteAllItem("ITEM_SWITCH");
                    dbHandler.addItemSwitchTester(itemCard);
//
//                    dbHandler.deleteAllItem("ITEM_SWITCH");
//                    for (int i = 0; i < itemCard.size(); i++) {
//                        dbHandler.deleteItemSwitchByItemCode(itemCard.get(i).getItemOCode(),itemCard.get(i).getItemNCode());
//                        dbHandler.addItemSwitch(itemCard.get(i));
//                    }

                    Log.e("TAG_itemSwitch", "****SaveSuccess");



                } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String JsonResponse) {
            super.onPostExecute(JsonResponse);
//            Toast.makeText(context, "Save Item Card Success", Toast.LENGTH_SHORT).show();
//            Toast.makeText(context, "Start Import Item Switch", Toast.LENGTH_SHORT).show();
//
            pd.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pd.setTitleText(context.getResources().getString(R.string.saveitemswitch));
            new SyncGetStor().execute();
//            progressDialog.dismiss();
        }
    }

}

//
//
////
//
//
//    public boolean isInternetAvailable() {
//        try {
//            final InetAddress address = InetAddress.getByName("www.google.com");
//            return !address.equals("");
//        } catch (UnknownHostException e) {
//            // Log error
//        }
//        return false;
//    }
//
//}






