//package com.example.stu_share;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//
//    protected BottomNavigationView navigationView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(getLayoutId());
//
//        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
//        navigationView.setOnNavigationItemSelectedListener(this);
//    }
//
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        updateNavigationBarState();
//    }
//
//    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
//    @Override
//    public void onPause() {
//        super.onPause();
//        overridePendingTransition(0, 0);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
//        navigationView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                int itemId = item.getItemId();
//                if (itemId == R.id.action_home) {
//                    BaseActivity.this.startActivity(new Intent(BaseActivity.this, MainMenu.class));
//                } else if (itemId == R.id.action_profile) {
//                    BaseActivity.this.startActivity(new Intent(BaseActivity.this, MyProfile.class));
//                } else if (itemId == R.id.action_message) {
//                    BaseActivity.this.startActivity(new Intent(BaseActivity.this, MessageList.class));
//                } else if (itemId == R.id.action_myevents) {
//                    BaseActivity.this.startActivity(new Intent(BaseActivity.this, EventMyEvents.class));
//                }
//                BaseActivity.this.finish();
//            }
//        }, 0);
//        return true;
//    }
//
//    private void updateNavigationBarState() {
//        int actionId = getBottomNavigationMenuItemId();
//        selectBottomNavigationBarItem(actionId);
//    }
//
//    void selectBottomNavigationBarItem(int itemId) {
//        MenuItem item = navigationView.getMenu().findItem(itemId);
//        item.setChecked(true);
//    }
//
//    abstract int getLayoutId(); // this is to return which layout(activity) needs to display when clicked on tabs.
//
//    abstract int getBottomNavigationMenuItemId();//Which menu item selected and change the state of that menu item
//}
