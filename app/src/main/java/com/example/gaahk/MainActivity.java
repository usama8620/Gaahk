package com.example.gaahk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.MenuItem;

import com.example.gaahk.Activities.AboutAppActivity;
import com.example.gaahk.Activities.FeatureActivity;
import com.example.gaahk.Activities.LoginActivity;
import com.example.gaahk.Activities.RecieptActivity;
import com.example.gaahk.Activities.SettingsActivity;
import com.example.gaahk.Activities.WalletActivity;
import com.example.gaahk.Activities.WishlistActivity;
import com.example.gaahk.Fragments.AlertFragment;
import com.example.gaahk.Fragments.NegotiationFragment;
import com.example.gaahk.Fragments.HomeFragment;
import com.example.gaahk.Fragments.PostFragment;
import com.example.gaahk.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import static com.example.gaahk.Activities.LoginActivity.PREFERENCE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_HOME = "home";
    public static String CURRENT_TAG = TAG_HOME;
    private Handler mHandler;

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    private ActionBarDrawerToggle drawerToggle;

    SharedPreferences mSharedPreferences;
    public static Activity login;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    loadHomeFragment(1);
                    return true;

                case R.id.navigation_negotiation:
                    loadHomeFragment(2);
                    return true;

                case R.id.navigation_cam:
                    loadHomeFragment(3);
                    return true;

                case R.id.navigation_bell:
                    loadHomeFragment(4);
                    return true;

                case R.id.navigation_store:
                    loadHomeFragment(5);
                    return true;


            }

            return false;
        }
    };

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener1 = new NavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.nav_e_wallet:
                    Intent ew = new Intent(MainActivity.this, WalletActivity.class);
                    startActivity(ew);
                    return true;

                case R.id.nav_wishlist:
                    Intent w = new Intent(MainActivity.this, WishlistActivity.class);
                    startActivity(w);
                    return true;

                case R.id.nav_feature:
                    Intent f = new Intent(MainActivity.this, FeatureActivity.class);
                    startActivity(f);
                    return true;

                case R.id.nav_settings:
                    Intent e = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(e);
                    return true;

                case R.id.nav_reciept:
                    Intent s = new Intent(MainActivity.this, RecieptActivity.class);
                    startActivity(s);
                    return true;

                case R.id.nav_aboutapp:
                    Intent a = new Intent(MainActivity.this, AboutAppActivity.class);
                    startActivity(a);
                    return true;

                case R.id.nav_logout:
                    finish();
                    Intent l = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(l);
                    // Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                    return true;

            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set a Toolbar to replace the ActionBar.





        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        if (Build.VERSION.SDK_INT > 21) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);


        navigation.getChildAt(0);

//        for (int i = 0; i < navigation.getChildCount(); i++) {
//            final View iconView = navigation.getChildAt(i).findViewById(R.id.icon);
//
//            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
//
//            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//            if (i == 2){
//                // set your height here
//                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, displayMetrics);
//                // set your width here
//                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, displayMetrics);
//            }
//            else {
//                // set your height here
//                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
//                // set your width here
//                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
//            }
//            iconView.setLayoutParams(layoutParams);
//        }

        mHandler = new Handler();

        NavigationView navigation1 = findViewById(R.id.nav_view);
        navigation1.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener1);
        navigation1.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
            }
        }).check();

        loadHomeFragment(0);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadHomeFragment(final int i) {
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment(i);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.disallowAddToBackStack();
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
    }


    @Override
    public void onBackPressed() {
    }

    @SuppressLint("SetTextI18n")
    private Fragment getHomeFragment(int i) {
        switch (i) {
            case 1:
//                mTextMessage.setText("Home");
//                mTextMessage.setVisibility(View.VISIBLE);
                 return new HomeFragment();
            case 2:
//                mTextMessage.setText("Categories");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new NegotiationFragment();
            case 3:
//                mTextMessage.setText("About");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new PostFragment();

            case 4:
//                mTextMessage.setText("Contact");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new AlertFragment();

            case 5:
//                mTextMessage.setText("Contact");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new ProfileFragment();



            default:
                return new HomeFragment();
        }
    }

}
