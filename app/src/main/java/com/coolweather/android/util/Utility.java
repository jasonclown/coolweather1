package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces = new JSONArray(response);
                int length=allProvinces.length();
                for (int i=0;i<length;++i){
                    JSONObject provincesJSONObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provincesJSONObject.getInt("id"));
                    province.setProvinceName(provincesJSONObject.getString("name"));
                    //写入数据库中
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return  false;
    }


    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCitys = new JSONArray(response);
                int length = allCitys.length();
                for (int i = 0; i < length; i++) {
                    JSONObject cityJSONObject = allCitys.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityJSONObject.getInt("id"));
                    city.setCityName(cityJSONObject.getString("name"));
                    city.setProvinceId(provinceId);
                    //保存进数据库中
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 解析和处理服务器返回的县级数据
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                int length = allCounties.length();
                for (int i = 0; i < length; i++) {
                    JSONObject countyJSONObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountryName(countyJSONObject.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(countyJSONObject.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
