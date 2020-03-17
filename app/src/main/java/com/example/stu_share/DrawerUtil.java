package com.example.stu_share;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class DrawerUtil {
    public static void getDrawer(final Activity activity, Toolbar toolbar) {
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem drawerEmptyItem= new PrimaryDrawerItem().withIdentifier(0).withName("");
        drawerEmptyItem.withEnabled(false);

        PrimaryDrawerItem drawerItemManagePlayers = new PrimaryDrawerItem().withIdentifier(1)
                .withName(R.string.price).withIcon(R.drawable.placeholder);
        PrimaryDrawerItem drawerItemManagePlayersTournaments = new PrimaryDrawerItem()
                .withIdentifier(2).withName(R.string.author).withIcon(R.drawable.jif);


        SecondaryDrawerItem drawerItemSettings = new SecondaryDrawerItem().withIdentifier(3)
                .withName(R.string.logout).withIcon(R.drawable.ic_join);
        SecondaryDrawerItem drawerItemAbout = new SecondaryDrawerItem().withIdentifier(4)
                .withName(R.string.home).withIcon(R.drawable.ic_join);
        SecondaryDrawerItem drawerItemHelp = new SecondaryDrawerItem().withIdentifier(5)
                .withName(R.string.bookEdition).withIcon(R.drawable.placeholder);
        SecondaryDrawerItem drawerItemDonate = new SecondaryDrawerItem().withIdentifier(6)
                .withName(R.string.Details).withIcon(R.drawable.ic_profile);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withCloseOnClick(true)
                .withSelectedItem(-1)
                .addDrawerItems(
                        drawerEmptyItem,drawerEmptyItem,drawerEmptyItem,
                        drawerItemManagePlayers,
                        drawerItemManagePlayersTournaments,
                        new DividerDrawerItem(),
                        drawerItemAbout,
                        drawerItemSettings,
                        drawerItemHelp,
                        drawerItemDonate
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 2 && !(activity instanceof MainActivity)) {
                            // load tournament screen
                            Intent intent = new Intent(activity, MainActivity.class);
                            view.getContext().startActivity(intent);
                        }
                        return true;
                    }
                })
                .build();
    }
}
