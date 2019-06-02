# widget
some customized widget
[TOC]
## 圆形ImageView：RoundImageView
<img src="https://github.com/zjfcabbage/widget/blob/master/images/roundimageview.png" alt="GitHub" title="GitHub,RoungImageView" width="30%" height="30%" />

```xml
<com.zjf.widget.widget.RoundImageView
     android:layout_width="80dp"
     android:layout_height="80dp"
     android:layout_marginEnd="10dp"
     android:src="@drawable/zhushu"
     app:type="circle" />

<com.zjf.widget.widget.RoundImageView
     android:layout_width="80dp"
     android:layout_height="80dp"
     android:layout_marginEnd="10dp"
     android:src="@drawable/zhushu"
     app:radius="8dp"
     app:type="rectangle" />

<com.zjf.widget.widget.RoundImageView
     android:layout_width="80dp"
     android:layout_height="80dp"
     android:src="@drawable/zhushu"
     app:left_top_radius="10dp"
     app:type="rectangle" />

<!--radius和其他单独四个角设置的话，radius属性会覆盖其他属性-->
     <!--<com.zjf.widget.widget.RoundImageView-->
      <!--android:layout_width="80dp"-->
      <!--android:layout_height="80dp"-->
      <!--app:type="rectangle"-->
      <!--app:radius="8dp"-->
      <!--android:src="@drawable/zhushu"-->
      <!--app:left_bottom_radius="8dp"/>-->

<com.zjf.widget.widget.RoundImageView
      android:layout_width="80dp"
      android:layout_height="80dp"
      android:layout_marginEnd="10dp"
      android:src="@drawable/zhushu"
      app:right_top_radius="10dp"
      app:type="rectangle" />

<com.zjf.widget.widget.RoundImageView
      android:layout_width="80dp"
      android:layout_height="80dp"
      android:layout_marginEnd="10dp"
      android:src="@drawable/zhushu"
      app:left_bottom_radius="10dp"
      app:type="rectangle" />

<com.zjf.widget.widget.RoundImageView
      android:layout_width="80dp"
      android:layout_height="80dp"
      android:src="@drawable/zhushu"
      app:right_bottom_radius="10dp"
      app:type="rectangle" />
```
## 带清除文本的EditText: SearchEditText
<img src="https://github.com/zjfcabbage/widget/blob/master/images/gifeditor_20190602_195646.gif" alt="GitHub" title="SearchEditText" width="30%" height="30%" />
xml正常引用```SearchEdittext```，可以添加一个清除文本的监听器

```java
SearchEditText editText = findViewById(R.id.et);
editText.setOnClearTextListener(new SearchEditText.OnClearTextListener() {
      @Override
      public void onClearTextListener() {
          //点击清除文本的监听
                Toast.makeText(MainActivity.this, "清除文本", Toast.LENGTH_SHORT).show();
      }
});
```



