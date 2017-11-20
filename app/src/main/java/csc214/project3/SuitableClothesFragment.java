package csc214.project3;


import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuitableClothesFragment extends Fragment {

    ImageView IVtop;
    ImageView IVbottom;
    DatabaseHelper myDb;
    DBFunctions dbf;
    TextView noclothesTV;
    MediaPlayer sunnyMP;
    MediaPlayer extremeMP;
    MediaPlayer rainyMP;

    public SuitableClothesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myDb = new DatabaseHelper(getActivity());
        dbf = new DBFunctions(getActivity(), this);

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_suitable_clothes, container, false);


        // playing tones with MediaPlayer
        sunnyMP = MediaPlayer.create(getActivity(), R.raw.sunny_sound);
        rainyMP = MediaPlayer.create(getActivity(), R.raw.rain_sound);
        extremeMP = MediaPlayer.create(getActivity(), R.raw.winter_sound);
        getSound();

        IVtop = (ImageView)view.findViewById(R.id.IV_suitable_top);
        IVbottom = (ImageView)view.findViewById(R.id.IV_suitable_bottom);
        noclothesTV = (TextView)view.findViewById(R.id.TV_suitable_noClothes);
        getAllTypes();

        return view;
    }
    public void getSound(){
        if (IntroActivity.mCondition.contains("Cloudy") || IntroActivity.mCondition.contains("Clear")){
            sunnyMP.start();
        } else if (IntroActivity.mCondition.contains("Rain") || IntroActivity.mCondition.contains("Drizzle")){
            rainyMP.start();
        } else if (IntroActivity.mCondition.contains("Snow") || IntroActivity.mCondition.contains("Thunderstorm") || IntroActivity.mCondition.contains("Extreme") || IntroActivity.mCondition.contains("Atmosphere")){
            extremeMP.start();
        }
    }
    // get all data and send to DBFunctions to create list from it
    public void getAllTypes() {
        Cursor cursor = myDb.getAllData();
        dbf = new DBFunctions(getActivity(), this);
        if (cursor.getCount() == 0) {
            Log.i("Error", "No Data Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            buffer.append(cursor.getString(1) + " ");
            buffer.append(cursor.getString(2) + " ");
            buffer.append(cursor.getString(3) + "SPLIT");
        }
        dbf.createClothesList(buffer.toString());
    }
    public void updateTopIV(int resID){
        IVtop.setImageResource(resID);
    }
    public void updateBottomIV(int resID){
        IVbottom.setImageResource(resID);
    }
    public void showMessage(){
        noclothesTV.setText("No suitable clothes.");
    }


}
