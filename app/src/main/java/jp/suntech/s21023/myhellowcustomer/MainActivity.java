package jp.suntech.s21023.myhellowcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.bt_click);
        HellowListener listener = new HellowListener(); //リスナのインスタンス作成
        btClick.setOnClickListener(listener);   //ボタンにリスナを組み込む

        Button btClear = findViewById(R.id.bt_clear);
        btClear.setOnClickListener(listener);

        Button osumaiClear = findViewById(R.id.osumai_clear);
        osumaiClear.setOnClickListener(listener);
    }

    private class HellowListener implements View.OnClickListener{

        //イベントハンドラ　<= イベント発生時の処理
        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトの作成
            EditText input = findViewById(R.id.osumaiName);
            EditText a = findViewById(R.id.Name);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOutput);

            int id = view.getId();
            switch (id){
                case R.id.bt_click:
                    //入力された名前文字列を取得
                    String inputStr = input.getText().toString();
                    String aStr = a.getText().toString();
                    //メッセージを表示
                    output.setText(inputStr + "にお住いの" + aStr + "さん、こんにちは");
                    break;
                case R.id.bt_clear:
                    a.setText("");
                    output.setText("");
                    break;
                case R.id.osumai_clear:
                    input.setText("");
                    output.setText("");
                    break;//ブレイク
            }

        }
    }
}