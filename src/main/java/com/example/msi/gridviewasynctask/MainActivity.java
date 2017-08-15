package com.example.msi.gridviewasynctask;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] abc = {"một","hai","ba"};
    ImageApdater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.image_view);

        new ShowImageTask(imageView).execute(getLink().get(0));

        gridView = (GridView) findViewById(R.id.grid_view);
        /*adapter = new ImageApdater(
                this,getLink()
        );*/

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this,R.layout.grid_view_items2,R.id.text_view1,abc
        );

        gridView.setAdapter(adapter1);

    }

    public ArrayList<String> getLink(){
        String[] link = {
                "http://img.f8.bdpcdn.net/Assets/Media/2017/05/05/38/buoi-tap-sang-cua-doi-tuyen-u22-3-.jpg",
                "http://znews-photo-td.zadn.vn/w660/Uploaded/BzcwvoBL/2017_08_13/2_zing.JPG",
                "http://baomoi-photo-2.zadn.vn/17/08/13/111/23003308/1_111431.jpg",
                "http://image-us.24h.com.vn/upload/2-2017/images/2017-05-14/1494703821-1494518194-069a5759.jpg",
                "http://imgs.vietnamnet.vn/Images/2017/08/14/19/20170814194624-u22-viet-nam-tap-1.jpg",
                "http://imgs.vietnamnet.vn/Images/2017/08/13/19/20170813193356-u22-huuthang-13-8-2.jpg",
                "http://static.bongda24h.vn/medias/standard/2017/5/6/HLV-Huu-Thang-he-lo-doi-hinh-U22-Viet-Nam-truoc-dan-em-Messi-hinh-anh.jpg",
                "http://media.thethao247.vn/upload/namnv/2017/08/09/am.jpg",
                "https://vcdn-thethao.vnecdn.net/2017/08/14/3-1502713673_680x0.jpg",
                "http://imgs.vietnamnet.vn/Images/2017/05/14/22/20170514224653-u22-viet-nam.JPG"
        };

        ArrayList<String> links = new ArrayList<>(Arrays.asList(link));
        return  links;
    }
}
