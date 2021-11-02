package com.publicicat.restapi;

import static androidx.annotation.InspectableProperty.ValueType.RESOURCE_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout1;
    private ViewPager2 viewPager2;
    private final int[] tabIcons = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_connect_without_contact_24
    };
    TextView tvF3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Barra menu declarar botons 1/2
        ImageView rightIcon = findViewById(R.id.right_icon);
        registerForContextMenu(rightIcon);

        ImageView leftIcon = findViewById(R.id.left_icon);
        leftIcon.setVisibility(View.GONE);

        //TabLayout with a couple of tabs i ViewPager 1/2
        tabLayout1 = findViewById(R.id.tabLayout1);
        setupTabIcons();

        viewPager2 = findViewById(R.id.viewPager2);

        viewPager2.setAdapter(new AdaptadorFragment(getSupportFragmentManager(), getLifecycle()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout1.selectTab(tabLayout1.getTabAt(position));

            }
        });

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    /* Enllaça amb fragment_three Bundle i xequeja si ve null
    Aquest mètode està pensat per enviar fragments d'elements
    no strings o dades soles
    A més, un cop pots enviar l'objecte xml amb les dads inscrites
    Cal que el contenidor receptor sigui semblant o d'una forma determinada
    però no un View. I un view és just el què configurem per mostrar la pantalla del fragment_three
    UNALIADAPARDA si segueixes l'exercici.
    Bundle user = getIntent().getExtras();
    if (user != null){
        String var = user.getString("fullNameInternet");
        switch(var){
            case "Publicicat_":
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentThree fragment = FragmentThree.newInstance("fullNameInternet", var);
                fragmentTransaction.replace(R.id.tv_f3_title, fragment, var);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Toast.makeText(this, "Is " + var + " who did you query?", Toast.LENGTH_SHORT).show();
                break;
        }
    } else {
        Toast.makeText(this, "Sorry, Intent is null", Toast.LENGTH_SHORT).show();
    }*/


    } //onCreate: end

    private void setupTabIcons() {
        tabLayout1.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout1.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout1.getTabAt(2).setIcon(tabIcons[2]);
    }
    //TabLayout with a couple of tabs i ViewPager 2/2
    class AdaptadorFragment extends FragmentStateAdapter {
        public AdaptadorFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch(position) {
                case 0: return new FragmentOne();
                case 1: return new FragmentTwo();
                default: return new FragmentThree();
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }

    }

    //Barra menu declarar botons 2/2
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_option, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.About:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
                break;

            case R.id.Form:
                Intent form = new Intent (MainActivity.this, FormActivity.class);
                startActivity(form);
                break;
            case R.id.ChangeUser:
                Intent changeUser = new Intent(MainActivity.this, ChangeUserActivity.class);
                startActivity(changeUser);
                break;

        }

        return super.onContextItemSelected(item);
    }
}