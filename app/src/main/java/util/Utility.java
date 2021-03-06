package util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import db.City;
import db.County;
import db.Province;

/**
 * 作者：created by chulei on 2021/5/24 11:06
 * 邮箱：clshijie168@163.com
 */
public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces = new JSONArray(response);
                for(int i=0; i < allProvinces.length(); i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId){
        try{
            JSONArray allCities = new JSONArray(response);
            for(int i=0; i < allCities.length(); i++){
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean handleCountyResponse(String response, int cityId){
        try{
            JSONArray allCounties = new JSONArray(response);
            for(int i=0; i < allCounties.length(); i++){
                JSONObject countyObject = allCounties.getJSONObject(i);
                County county = new County();
                county.setCountyName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
