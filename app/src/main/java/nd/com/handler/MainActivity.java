package nd.com.handler;

/**
 * Created by Administrator on 2016/7/23 0023.
 */
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static  final int update_message = 1;
    private Button btn_update_ui;
    private TextView tv_update_ui;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case update_message:
                    tv_update_ui.setText("Nice to meet you!!!");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_update_ui = (Button) findViewById(R.id.btn_update_ui);
        tv_update_ui = (TextView) findViewById(R.id.tv);
        btn_update_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = update_message;
                        handler.sendMessage(message);

                    }
                }).start();
            }
        });
    }
}
