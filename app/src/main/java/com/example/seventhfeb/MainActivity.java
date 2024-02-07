package com.example.seventhfeb;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.seventhfeb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.forthTab)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        final int[] TAB_TITLES = new int[]{R.string.title_home, R.string.title_dashboard, R.string.title_notifications, R.string.nastya};
        getItem(TAB_TITLES.length);
    }

    public Fragment getItem(int position)
    {
        if (position == 0)
        {
            FirstTab tab1 = new FirstTab();
            return tab1;
        }
        if (position == 1)
        {
            SecondTab tab2 = new SecondTab();
            return tab2;
        }
        if (position == 2)
        {
            ThirdTab tab3 = new ThirdTab();
            return tab3;
        }
        if (position == 3)
        {
            ForthTab tab4 = new ForthTab();
            return tab4;
        }
        return null;
    }


}