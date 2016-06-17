package supportpage.classic.app.supportpage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFeed;
    private LeftDrawerLayout mLeftDrawerLayout;
    private TabLayout mainTabLayout;

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


        mainTabLayout = (TabLayout ) findViewById(R.id.tablayout_client);

        final TabLayout.Tab home = mainTabLayout.newTab();
        final TabLayout.Tab inbox = mainTabLayout.newTab();
        final TabLayout.Tab star = mainTabLayout.newTab();

        home.setText("Home");
        inbox.setText("Inbox");
        star.setText("Star");

        mainTabLayout.addTab(home, 0);
        mainTabLayout.addTab(inbox, 1);
        mainTabLayout.addTab(star, 2);


    }


    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ct_menu_white);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });
    }
}
