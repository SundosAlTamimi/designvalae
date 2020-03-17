package com.example.user54.InventoryApp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.user54.InventoryApp.Model.MainSetting;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class ExportJeson {

    private Context context;
    private ProgressDialog progressDialog;
    private ProgressDialog progressDialogSave;
    private JSONObject obj;
    InventoryDatabase dbHandler;

   ;
    public ExportJeson(Context context,JSONObject object) {//, JSONObject obj
        this.obj = object;
        this.context = context;
        dbHandler = new InventoryDatabase(context);
//        progressDialog = new ProgressDialog(context,R.style.MyTheme);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setProgress(0);





    }

    public void startSending(String flag) {
//        Log.e("check",flag);

        if (flag.equals("ExportData"))
            new ExportData().execute();

        if (flag.equals("ExportTransferData"))
            new ExportTransferData().execute();


    }

    private class ExportData extends AsyncTask<String, String, String> {
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
            pdItem.getProgressHelper().setBarColor(Color.parseColor("#FDD835"));
            pdItem.setTitleText(context.getResources().getString(R.string.exportiteminfo));
            pdItem.setCancelable(false);
            pdItem.show();


        }

        @Override
        protected String doInBackground(String... params) {///GetModifer?compno=736&compyear=2019
            try {
                final List<MainSetting> mainSettings=dbHandler.getAllMainSetting();
                String ip="";
                if(mainSettings.size()!=0) {
                    ip= mainSettings.get(0).getIP();
                }
                String link = "http://"+ip + "/ExportData";
//
                String data = "JSONSTR=" + URLEncoder.encode(obj.toString(), "UTF-8") ;
                Log.e("tag_link", "ExportData -->" + link);
                Log.e("tag_data", "ExportData -->" + data);

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

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                while ((JsonResponse = bufferedReader.readLine()) != null) {
                    stringBuffer.append(JsonResponse + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.e("tag", "ExportData -->" + stringBuffer.toString());

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

            if (JsonResponse != null && JsonResponse.contains("Saved Successfully")) {
                Log.e("ExportData", "****Success");
                dbHandler.updateIsExport();
                pdItem.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pdItem.setTitleText(context.getResources().getString(R.string.exportriteminfosuc));
                if(pdItem!=null){
                    pdItem.dismissWithAnimation();

                    new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText(context.getResources().getString(R.string.sucess))
                        .setContentText(context.getResources().getString(R.string.exportiteminfosucess))
                        .show();

            }


            } else {
                Log.e("ExportData", "****Failed to export data");
//                Toast.makeText(context, "Failed to ExportData", Toast.LENGTH_SHORT).show();

                if(pdItem!=null){
                pdItem.dismissWithAnimation();

                    new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText(context.getResources().getString(R.string.ops))
                            .setContentText(context.getResources().getString(R.string.faildexport_iteminfo))
                            .show();

                }

            }

        }



    }

    private class ExportTransferData extends AsyncTask<String, String, String> {
        private String JsonResponse = null;
        private HttpURLConnection urlConnection = null;
        private BufferedReader reader = null;
        SweetAlertDialog TransferDialog =null;
        @Override
        protected void onPreExecute() {

            TransferDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            TransferDialog.getProgressHelper().setBarColor(Color.parseColor("#FDD835"));
            TransferDialog.setTitleText(context.getResources().getString(R.string.ex_item_transfer));
            TransferDialog.setCancelable(false);
            TransferDialog.show();
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {///GetModifer?compno=736&compyear=2019
            try {
                final List<MainSetting> mainSettings=dbHandler.getAllMainSetting();
                String ip="";
                if(mainSettings.size()!=0) {
                    ip= mainSettings.get(0).getIP();
                }
                String link = "http://"+ip + "/ExportTransfer";
//
                String data = "JSONSTR=" + URLEncoder.encode(obj.toString(), "UTF-8") ;
                Log.e("tag_link", "ExportData -->" + link);
                Log.e("tag_data", "ExportData -->" + data);

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

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                while ((JsonResponse = bufferedReader.readLine()) != null) {
                    stringBuffer.append(JsonResponse + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.e("tag", "ExportData -->" + stringBuffer.toString());

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

            if (JsonResponse != null && JsonResponse.contains("Saved Successfully")) {
                Log.e("ExportData", "****Success");
                dbHandler.updateIsExportTransfer();

                if(TransferDialog !=null){
                    TransferDialog.dismissWithAnimation();

                    new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText(context.getResources().getString(R.string.sucess))
                            .setContentText(context.getResources().getString(R.string.exporttransfersucess))
                            .show();

                }

            } else {
                Log.e("ExportData", "****Failed to export data");
                Toast.makeText(context, "Failed to ExportData", Toast.LENGTH_SHORT).show();

                if(TransferDialog !=null){
                    TransferDialog.dismissWithAnimation();

                    new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText(context.getResources().getString(R.string.ops))
                            .setContentText(context.getResources().getString(R.string.faildExportTransfer))
                            .show();

                }
            }

        }



    }



}
