package supportpage.classic.app.supportpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.gc.materialdesign.views.ButtonFloat;
import com.mingle.sweetpick.CustomDelegate;
import com.mingle.sweetpick.SweetSheet;

public class SplashScreenActivity extends AppCompatActivity {
    private SweetSheet sweetSheetLogin;
    private RelativeLayout sweetSheetSplash;
    private ButtonFloat buttonFloatAdmin, buttonFloatGuest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_main);

        sweetSheetSplash = (RelativeLayout) findViewById(R.id.sweet_sheet_splash);
        setupCustomView();

        buttonFloatAdmin = (ButtonFloat)findViewById(R.id.buttonFloat_cont_admin);
        buttonFloatGuest = (ButtonFloat)findViewById(R.id.buttonFloat_cont_guest);



        buttonFloatAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sweetSheetLogin.toggle();
            }
        });

        buttonFloatGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sweetSheetLogin.isShow()) {
                    sweetSheetLogin.dismiss();
                }
            }
        });

    }

    private void setupCustomView() {

        sweetSheetLogin = new SweetSheet(sweetSheetSplash);
        CustomDelegate customDelegate = new CustomDelegate(true,
                CustomDelegate.AnimationType.DuangLayoutAnimation);
        View view = LayoutInflater.from(this).inflate(R.layout.splash_client_login, null, false);
        customDelegate.setCustomView(view);
        sweetSheetLogin.setDelegate(customDelegate);

        view.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clientMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(clientMain);
            }
        });

    }
}
