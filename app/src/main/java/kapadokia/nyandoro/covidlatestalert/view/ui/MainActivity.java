package kapadokia.nyandoro.covidlatestalert.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        // making home the default fragment
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new HomeFragment()).commit();


        bottomNavigationView = binding.navigation;
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment newFragment = null;
                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            newFragment = new HomeFragment();
                            break;
                        case R.id.navigation_countries:
                            newFragment = new CountriesFragment();
                            break;
                        case R.id.navigation_stories:
                            newFragment = new NewsFragment();
                            break;
                        case R.id.navigation_health:
                            Toast.makeText(MainActivity.this, "Working on health ", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    if (newFragment !=null){
                        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content, newFragment)
                                .commit();

                        return true;
                    }

                    return false;
                }
            };
}