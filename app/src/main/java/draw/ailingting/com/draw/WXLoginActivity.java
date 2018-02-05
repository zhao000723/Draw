package draw.ailingting.com.draw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXLoginActivity extends AppCompatActivity {
    private String APP_ID = "wxb9d393c375106810";

    private IWXAPI mWXApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxlogin);

        regToWX();
        sendAuth();
    }

    private void regToWX() {
        mWXApi = WXAPIFactory.createWXAPI(getApplicationContext(), APP_ID, true);
        mWXApi.registerApp(APP_ID);
    }

    private void sendAuth() {
        // send oauth request
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        mWXApi.sendReq(req);
    }
}
