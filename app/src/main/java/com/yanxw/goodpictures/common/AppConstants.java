package com.yanxw.goodpictures.common;

import java.util.ArrayList;

/**
 * Created by yanxinwei on 16/8/3.
 */

public interface AppConstants {

    int TYPE_PIC = 10000;
    int TYPE_JOKE = 20000;

    int PIC_BAIDU = 100001;

    //String[] PIC_CATEGORY_BAIDU = {" 丝袜 ", " 美腿 ", " 性感 ", " 清纯 ", " 制服 ", " 萝莉 ", " 校花 "};
    ArrayList<String> PIC_CATEGORY_BAIDU = new ArrayList<String>() {{
        add(" 丝袜 ");
        add(" 美腿 ");
        add(" 性感 ");
        add(" 清纯 ");
        add(" 制服 ");
        add(" 萝莉 ");
        add(" 校花 ");
    }};

}
