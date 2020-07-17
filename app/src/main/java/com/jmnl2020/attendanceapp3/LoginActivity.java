package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.exception.KakaoException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.helper.Utility.getPackageInfo;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //로그인에 성공한 적이 있으면
        afterLoginSendNext();

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //키해시값 얻어와서 Logcat 창에 출력
        String keyHash = getKeyHash(this);
        Log.i("keyHash", keyHash);

        //카카오 로그인 버튼은 별도의 클릭 이벤트 처리 없이도 자동으로 웹뷰를 실행하여 로그인 페이지를 보여줌.
        //그 웹페이지의 로그인 응답결과를 받기위한 세션(카카오와 연결하는 통로)을 연결
        Session.getCurrentSession().addCallback(sessionCallback);

    }


    //카카오 로그인 서버와 연결을 시도하는 세션작업의 결과를 듣는 리스너
    ISessionCallback sessionCallback = new ISessionCallback() {
        @Override
        public void onSessionOpened() {
            Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
            //로그인 된 사용자의 정보들 얻어오기
            requestUserInfo();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Toast.makeText(LoginActivity.this, "로그인 세션 실패", Toast.LENGTH_SHORT).show();
        }
    };//ISessionCallback end.


    //로그인 사용자 정보 받기
    void requestUserInfo(){
        UserManagement.getInstance().me(new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {

            }

            @Override
            public void onSuccess(MeV2Response result) {

                //로그인에 성공!!
                G.isLogin = true;

                //사용자 정보객체 받아옴.
                UserAccount userAccount = result.getKakaoAccount();

                //기본 프로필 정보 (닉네임, 이미지, 섬네일 이미지)
                Profile profile = userAccount.getProfile();
                if(profile == null ) return;

                G.nickName = profile.getNickname();
                G.profileUrl = profile.getProfileImageUrl();
                String thumbnailImgUrl = profile.getThumbnailImageUrl();

                //받아온 정보를 MainActivity - Setting fragment 로 전달.
                // -> G 클래스를 이용해서 모든 Activity 에서 정보 사용할 수 있도록 쉐어
                // 로그인에 성공하면 다른 액티비티로 넘어갈 수 있도록 도와주는 메소드 호출
                afterLoginSendNext();

            }
        });
    }// requestUserInfo end.

    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.w("TAG", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }//keyHash method end.


    //다음 페이지를 둘러볼 수 있는 로그인 버튼
    public void clickLogin(View view) {
        G.isLogin = true;
        afterLoginSendNext();
    }//clickLogin end.



    //로그인 성공시 MainActivity로 넘겨주는 메소드
    public void afterLoginSendNext(){

        if (G.isLogin == true){
            Intent intent = new Intent(this, SelectionActivity.class);
            startActivity(intent);
        }else return;
    }

}
