package supportpage.classic.app.supportpage;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView rvFeed;
    private LeftDrawerLayout mLeftDrawerLayout;
    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private ViewPagerAdapter mainViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_main);
        setupToolbar();
        
        mLeftDrawerLayout = (LeftDrawerLayout) findViewById(R.id.id_drawerlayout);

        FragmentManager fm = getSupportFragmentManager();
        ClientNavbarFragment clientNavbarFragment = (ClientNavbarFragment) fm.findFragmentById(R.id.id_container_menu);
        FlowingView mFlowingView = (FlowingView) findViewById(R.id.sv);

        if (clientNavbarFragment == null) {
            fm.beginTransaction().add(R.id.id_container_menu, clientNavbarFragment = new ClientNavbarFragment()).commit();
        }
        mLeftDrawerLayout.setFluidView(mFlowingView);
        mLeftDrawerLayout.setMenuFragment(clientNavbarFragment);

        //profile.setText("Profile");
        //usage.setText("Usage");
        //account.setText("Account");

       // mainTabLayout.addTab(profile, 0);
        //mainTabLayout.addTab(usage, 1);
        //mainTabLayout.addTab(account, 2);

        mainViewPager = (ViewPager) findViewById(R.id.viewpager_client);
        this.setupViewPager(mainViewPager);

        //mainViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //mainViewPager.setAdapter(mainViewPagerAdapter);
        // mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabLayout));

        mainTabLayout = (TabLayout ) findViewById(R.id.tablayout_client);
        mainTabLayout.setupWithViewPager(mainViewPager);


         mainTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mainViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
        });


    }

    private void setupViewPager(final ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new ProfileFragment(), "Usage");
        adapter.addFragment(new ProfileFragment(), "Account");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabLayout));

    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.ct_menu_white);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });
    }


}
