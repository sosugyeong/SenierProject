package com.rec.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ApiExplorer {

    public static void main(String[] args){
        StringBuilder urlBuilder = new StringBuilder("https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?collection=kmdb_new2&detail=N&ServiceKey=JI12CKN72H6M7HB25S01");

        try{
            String jsonData = fetchJsonData(urlBuilder);
            // JSON 데이터 파싱
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray resultArray = jsonObject.getJSONArray("Result");

            for(int i = 0; i < resultArray.length(); i++){
                JSONObject movieObject = resultArray.getJSONObject(i);
                String movieSeq = movieObject.getString("movieSeq");
                String title = movieObject.getString("title");
                String prodYear = movieObject.getString("prodYear");

                JSONObject directorsObject = movieObject.getJSONObject("directors");
                JSONArray directorArray = directorsObject.getJSONArray("director");
                JSONObject directorObject = directorArray.getJSONObject(0);
                String directorName = directorObject.getString("directorNm");// 감독 정보 파싱

                JSONObject actorsObject = movieObject.getJSONObject("actors");
                JSONArray actorArray = actorsObject.getJSONArray("actor");
                JSONObject actor1Object = actorArray.getJSONObject(0);
                String actor1Name = actor1Object.getString("actorNm");// 배우 정보 파싱

                String nation = movieObject.getString("nation");
                // 플롯 정보 파싱
                JSONObject plotsObject = movieObject.getJSONObject("plots");
                JSONArray plotArray = plotsObject.getJSONArray("plot");
                JSONObject plotObject = plotArray.getJSONObject(0);
                String plotText = plotObject.getString("plotText");

                String runtime = movieObject.getString("runtime");//런타임
                String rating = movieObject.getString("rating");//관람등급
                String genre = movieObject.getString("genre");//장르
                String posters = movieObject.getString("posters");//이미지주소
            }
        }catch (JSONException | IOException e){
            e.printStackTrace();
        }
    }

    private static String fetchJsonData(StringBuilder urlBulider) throws IOException {
        URL url = new URL(urlBulider.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();
        return sb.toString();
    }
}