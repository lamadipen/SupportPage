package supportpage.classic.app.supportpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mxn.soul.flowingdrawer_core.MenuFragment;
import com.squareup.picasso.Picasso;


/**
 * Created by Dipen on 6/8/2016.
 * This class helps to create left navbar for the applicaiton
 */
public class ClientNavbarFragment extends MenuFragment{
    private ImageView ivNavUserProfilePhoto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.ct_client_navbar_menu,container,false);

        ivNavUserProfilePhoto = (ImageView) view.findViewById(R.id.ivMenuUserProfilePhoto);

        return setupReveal(view);
    }

    private void setupHeader(){
        int avatarSize = getResources().getDimensionPixelSize(R.dimen.global_menu_avatar_size);
        //String profilePhoto = getResources().getString(R.string.user_profile_photo);
        //R.drawable.admin_user

        Picasso.with(getActivity())
        .load(R.drawable.admin_user)
        .placeholder(R.drawable.img_profile_circle_placeholder)
        .resize(avatarSize,avatarSize)
        .centerCrop()
        .transform(new CircleTransformation());

    }
}
