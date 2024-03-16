package com.example.oauthjwt.service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiExamMemberProfile {


    public static void main(String[] args) {
        // 네이버
        String token = "AAAAN_iWR--X92w99QNBe6rHViORS6BZzW106q7cVBwCOamDescb6ZNCfdIiC3Dxbewh44mIkVMZflAmurkNZlwuu1w";// 네아로 접근 토큰 값";
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                System.out.println("Response Code : " + responseCode);
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        // 카카오
        String K_accessToken = "0nKMTRLgvDXxLICW70vaCLrQbwErFhL9Z_EKKclgAAABjfsJisHmTYKY7N6ACw";
        try {
            URL url = new URL("https://kapi.kakao.com/v2/user/me");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 요청 방식 선택 (GET)
            conn.setRequestMethod("GET");
            // 요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + K_accessToken);

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 결과 출력
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 구글
        String G_accessToken = "ya29.a0AfB_byAmKTu8ir1v9Mxk8xJXGTrMcn2jGJRoXBvqkpP5GC4CQFV6lGs-PSnhTe8xA09R5YmNJqO-txHWqX6u_9CMFikGTIyxOkwlTpE_tgXHOXftLbOhCbPuZ9F9R-zFcH7oe-GfxQlH_-nEyRJjW5q-1K876NhBL_pHaCgYKAcwSARMSFQHGX2MicMZgNehmqan-YwXJJmSB3Q0171";
        try {
            URL url = new URL("https://www.googleapis.com/oauth2/v3/userinfo");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 요청 방식 선택 (GET)
            conn.setRequestMethod("GET");
            // 요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + G_accessToken);

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 결과 출력
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
