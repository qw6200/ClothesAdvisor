package csc214.project3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by leew15 on 4/22/2017.
 */

public class DBFunctions {
    private Context context;
    private SuitableClothesFragment mActivity;
    public static String type, color, brand;
    List<Clothing> clothes;

    public DBFunctions(Context context, SuitableClothesFragment activity){
        this.context=context;
        mActivity = activity;
    }


    public void getType(String type2){
        type = type2;
    }
    public void getBrand(String brand2){
        brand = brand2;
    }
    public void getColor(String color2){
        color = color2;
    }
    // add clothes
    public void addClothes(){
        DatabaseHelper myDb = new DatabaseHelper(context);
        if (type != null && brand != null && color != null) {
            boolean isInserted = myDb.addClothes(type, color, brand);
            if (isInserted){
                Toast.makeText(context, "Clothing added!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Clothing NOT added!", Toast.LENGTH_LONG).show();
            }
        }
    }
    // create list from clothes
    public List<Clothing> createClothesList(String clothesString){
        DatabaseHelper myDb = new DatabaseHelper(context);

        int count = myDb.getClothingCount();

        clothes = new ArrayList<>();
        String[] elements = clothesString.split("SPLIT");

        for (int i = 0; i < count; i++){
            String line = elements[i];
            String[] part = line.split(" ");
            String type = part[0];
            String color = part[1];
            String brand = part[2];

            Clothing piece = new Clothing(type, color, brand);
            clothes.add(piece);
        }

        determineClothing(clothes);
        return clothes;
    }
    public void determineClothing(List<Clothing> clothes){
        Random r = new Random();
        Resources res = context.getResources();

        // conditionals to get suitable clothes depending on weather conditions

        // T-shirt and shorts if cloudy
        if (IntroActivity.mLowTemp >= 65){
            if (IntroActivity.mCondition.contains("Clear") || IntroActivity.mCondition.contains("Clouds")) {
                if (!getTShirts(clothes).isEmpty() && !getShorts(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getTShirts(clothes).size());
                    int randomBottom = r.nextInt(getShorts(clothes).size());
                    Clothing topAttire = getTShirts(clothes).get(randomTop);
                    Clothing bottomAttire = getShorts(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // Long sleeves and shorts if rain
        if (IntroActivity.mLowTemp >= 65){
            if (IntroActivity.mCondition.contains("Rain") || IntroActivity.mCondition.contains("Drizzle")) {
                if (!getLongSleeves(clothes).isEmpty() && !getShorts(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getLongSleeves(clothes).size());
                    int randomBottom = r.nextInt(getShorts(clothes).size());
                    Clothing topAttire = getLongSleeves(clothes).get(randomTop);
                    Clothing bottomAttire = getShorts(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // jacket and longpants if extreme conditions
        if (IntroActivity.mLowTemp >= 65){
            if (IntroActivity.mCondition.contains("Snow") || IntroActivity.mCondition.contains("Thunderstorm") || IntroActivity.mCondition.contains("Extreme") || IntroActivity.mCondition.contains("Atmosphere")) {
                if (!getLongSleeves(clothes).isEmpty() && !getLongPants(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getLongSleeves(clothes).size());
                    int randomBottom = r.nextInt(getLongPants(clothes).size());
                    Clothing topAttire = getLongSleeves(clothes).get(randomTop);
                    Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // long sleeves and shorts if 50 <= x < 65
        if (IntroActivity.mLowTemp < 65 && IntroActivity.mLowTemp >= 50){
            if (IntroActivity.mCondition.contains("Clear") || IntroActivity.mCondition.contains("Clouds")) {
                if (!getLongSleeves(clothes).isEmpty() && !getShorts(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getLongSleeves(clothes).size());
                    int randomBottom = r.nextInt(getShorts(clothes).size());
                    Clothing topAttire = getLongSleeves(clothes).get(randomTop);
                    Clothing bottomAttire = getShorts(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // long sleeves and jeans if rain
        if (IntroActivity.mLowTemp < 65 && IntroActivity.mLowTemp >= 50){
            if (IntroActivity.mCondition.contains("Rain") || IntroActivity.mCondition.contains("Drizzle")) {
                if (!getLongSleeves(clothes).isEmpty() && !getJeans(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getLongSleeves(clothes).size());
                    int randomBottom = r.nextInt(getJeans(clothes).size());
                    Clothing topAttire = getLongSleeves(clothes).get(randomTop);
                    Clothing bottomAttire = getJeans(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        if (IntroActivity.mLowTemp < 50 && IntroActivity.mLowTemp >= 30){
            if (IntroActivity.mCondition.contains("Clear") || IntroActivity.mCondition.contains("Clouds")) {
                if (!getHoodies(clothes).isEmpty() && !getLongPants(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getHoodies(clothes).size());
                    int randomBottom = r.nextInt(getLongPants(clothes).size());
                    Clothing topAttire = getHoodies(clothes).get(randomTop);
                    Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        if (IntroActivity.mLowTemp < 50 && IntroActivity.mLowTemp >= 30){
            if (IntroActivity.mCondition.contains("Rain") || IntroActivity.mCondition.contains("Drizzle")) {
                if (!getJackets(clothes).isEmpty() && !getLongPants(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getJackets(clothes).size());
                    int randomBottom = r.nextInt(getLongPants(clothes).size());
                    Clothing topAttire = getJackets(clothes).get(randomTop);
                    Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // extreme conditions
        if (IntroActivity.mLowTemp < 50 && IntroActivity.mLowTemp >= 30){
            if (IntroActivity.mCondition.contains("Snow") || IntroActivity.mCondition.contains("Thunderstorm") || IntroActivity.mCondition.contains("Extreme") || IntroActivity.mCondition.contains("Atmosphere")) {
                if (!getHoodies(clothes).isEmpty() && !getLongPants(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getHoodies(clothes).size());
                    int randomBottom = r.nextInt(getLongPants(clothes).size());
                    Clothing topAttire = getHoodies(clothes).get(randomTop);
                    Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // cloudy/rain
        if ((IntroActivity.mLowTemp < 30 && IntroActivity.mLowTemp >= 20)){
            if (IntroActivity.mCondition.contains("Clear") || IntroActivity.mCondition.contains("Clouds") || IntroActivity.mCondition.contains("Drizzle") || IntroActivity.mCondition.contains("Rain")) {
                if (!getJackets(clothes).isEmpty() && !getLongPants(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getJackets(clothes).size());
                    int randomBottom = r.nextInt(getLongPants(clothes).size());
                    Clothing topAttire = getJackets(clothes).get(randomTop);
                    Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // extreme
        if (IntroActivity.mLowTemp < 30 && IntroActivity.mLowTemp >= 20){
            if (IntroActivity.mCondition.contains("Snow") || IntroActivity.mCondition.contains("Thunderstorm") || IntroActivity.mCondition.contains("Extreme") || IntroActivity.mCondition.contains("Atmosphere")) {
                if (!getParkas(clothes).isEmpty() && !getLongPants(clothes).isEmpty()) {
                    int randomTop = r.nextInt(getParkas(clothes).size());
                    int randomBottom = r.nextInt(getLongPants(clothes).size());
                    Clothing topAttire = getParkas(clothes).get(randomTop);
                    Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                    String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                    String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                    int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                    int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                    mActivity.updateTopIV(topResID);
                    mActivity.updateBottomIV(bottomResID);
                } else {
                    mActivity.showMessage();
                }
            }

        }
        // if most cold
        if (IntroActivity.mLowTemp < 20){
            if (!getParkas(clothes).isEmpty() && !getLongPants(clothes).isEmpty()){
                int randomTop = r.nextInt(getParkas(clothes).size());
                int randomBottom = r.nextInt(getLongPants(clothes).size());
                Clothing topAttire = getParkas(clothes).get(randomTop);
                Clothing bottomAttire = getLongPants(clothes).get(randomBottom);

                String topDrawable = topAttire.getColor() + "_" + topAttire.getType();
                String bottomDrawable = bottomAttire.getColor() + "_" + bottomAttire.getType();

                int topResID = res.getIdentifier(topDrawable, "drawable", context.getPackageName());
                int bottomResID = res.getIdentifier(bottomDrawable, "drawable", context.getPackageName());

                mActivity.updateTopIV(topResID);
                mActivity.updateBottomIV(bottomResID);
            } else {
                mActivity.showMessage();
            }

        }

    }
    public List<Clothing> getHoodies(List<Clothing> clothes){
        List<Clothing> hoodies = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("hoodie")){
                hoodies.add(clothes.get(i));
            }

        }
        return hoodies;
    }
    public List<Clothing> getTShirts(List<Clothing> clothes){
        List<Clothing> tShirts = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("tshirt")){
                tShirts.add(clothes.get(i));
            }

        }
        return tShirts;
    }
    public List<Clothing> getLongSleeves(List<Clothing> clothes){
        List<Clothing> longSleeves = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("longsleeves")){
                longSleeves.add(clothes.get(i));
            }

        }
        return longSleeves;
    }
    public List<Clothing> getJackets(List<Clothing> clothes){
        List<Clothing> jackets = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("jacket")){
                jackets.add(clothes.get(i));
            }

        }
        return jackets;
    }
    public List<Clothing> getParkas(List<Clothing> clothes){
        List<Clothing> parkas = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("parka")){
                parkas.add(clothes.get(i));
            }

        }
        return parkas;
    }
    public List<Clothing> getShorts(List<Clothing> clothes){
        List<Clothing> shorts = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("shorts")){
                shorts.add(clothes.get(i));
            }

        }
        return shorts;
    }
    public List<Clothing> getJeans(List<Clothing> clothes){
        List<Clothing> jeans = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("jeans")){
                jeans.add(clothes.get(i));
            }

        }
        return jeans;
    }
    public List<Clothing> getLongPants(List<Clothing> clothes){
        List<Clothing> longPants = new ArrayList<>();

        for (int i = 0; i < clothes.size(); i++){
            String type = clothes.get(i).getType();
            if (type.equals("longpants")){
                longPants.add(clothes.get(i));
            }

        }
        return longPants;
    }



}
