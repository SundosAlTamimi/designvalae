package com.example.user54.InventoryApp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.user54.InventoryApp.R;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

//        import android.content.Intent;
//        import android.graphics.Color;
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.widget.Toast;
//
//        import com.hitomi.cmlibrary.CircleMenu;
//        import com.hitomi.cmlibrary.OnMenuSelectedListener;
//        import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class boom extends AppCompatActivity {

    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boom);
        initBmb(R.id.bmb1);
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon_home)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon_search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon_setting)
                .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             ConnectivityManager manager =(ConnectivityManager) getApplicationContext()
                                                                     .getSystemService(Context.CONNECTIVITY_SERVICE);
                                                             NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
                                                             if (null != activeNetwork) {
                                                                 if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                                                                     //we have WIFI
                                                                     Log.e("net ","wifi"+ activeNetwork.getDetailedState());
                                                                     activeNetwork.getDetailedState();
                                                                 }
                                                                 if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                                                                     //we have cellular data
                                                                     Log.e("net ","phone"+ activeNetwork.getDetailedState());
                                                                 }
                                                             } else{
                                                                 //we have no connection :(
                                                                 Log.e("net ","no connection ");
                                                             }
                                                             Toast.makeText(boom.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 1:
                                                             Toast.makeText(boom.this, "Search button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 2:
                                                             Toast.makeText(boom.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 3:
                                                             Toast.makeText(boom.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
//                                                             startActivity(new Intent(MainActivity.this, ThankYouActivity.class));
                                                             break;
                                                         case 4:
                                                             Toast.makeText(boom.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                     }
                                                 }
                                             }

        );

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {

                                                     }

                                                     @Override
                                                     public void onMenuClosed() {

                                                     }
                                                 }
        );
    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
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
                        Toast.makeText(boom.this, "index"+index, Toast.LENGTH_SHORT).show();
Intent int1=new Intent(boom.this, CollectingData.class);
startActivity(int1);
                        break;
                    case 1:
                        Toast.makeText(boom.this, "index"+index, Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(boom.this, "index"+index, Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        Toast.makeText(boom.this, "index"+index, Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        Toast.makeText(boom.this, "index"+index, Toast.LENGTH_SHORT).show();

                        break;
                    case 5:
                        Toast.makeText(boom.this, "index"+index, Toast.LENGTH_SHORT).show();

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
