package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void btnHe(View view) {
        String cur_lang = LocaleManager.getLocale(getResources()).toString();
        if (cur_lang.equals("my")){
            setNewLocale(this, LocaleManager.ENGLISH);
        }
        else
            setNewLocale(this, LocaleManager.MYANMAR);


        Toast.makeText(this, cur_lang, Toast.LENGTH_SHORT).show();

    }

    private void setNewLocale(BaseActivity mContext, @LocaleManager.LocaleDef String language) {
        LocaleManager.setNewLocale(this, language);
        Intent intent = mContext.getIntent();
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

    }
}
