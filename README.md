# widget
some customized widget

* [widget](#widget)
  * [圆形ImageView：RoundImageView](#%E5%9C%86%E5%BD%A2imageviewroundimageview)
  * [带清除文本的EditText: SearchEditText](#%E5%B8%A6%E6%B8%85%E9%99%A4%E6%96%87%E6%9C%AC%E7%9A%84edittext-searchedittext)
  * [隐私EditText: PrivacyEditText](#%E9%9A%90%E7%A7%81edittext-privacyedittext)
  
## 圆形ImageView：RoundImageView
>圆角ImageView，可以单独设置角的不同弧度，当设置为圆形的时候，就不需要设置radius

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
> 搜索框，默认有清除文本的图标，左侧还有“放大镜”的小图标，默认是隐藏的，放大镜和清除图标可以使用默认自带的，也可以通过属性更换布标，
可以通过设置监听器监听清除文本的动作

<img src="https://github.com/zjfcabbage/widget/blob/master/images/gifeditor_20190602_195646.gif" alt="GitHub" title="SearchEditText" width="30%" height="30%" />
<img src="https://github.com/zjfcabbage/widget/blob/master/images/searchEditText.png" alt="GitHub" title="SearchEditText" width="30%" height="30%" />

| 属性或方法 | 作用 |
| :-------:| :---:|
| setOnClearTextListener | 设置当点击清除文本时的监听器 |
| showSearchDrawable | 显示默认的左侧图标 |
| searchDrawable | 设置左侧图标 |
| clearDrawable | 设置右侧清除文本的图标 |

```xml
<com.zjf.widget.widget.SearchEditText
    android:id="@+id/et"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp" />

<!--更换右侧的图标-->
<com.zjf.widget.widget.SearchEditText
    app:clear_drawable="@drawable/icon_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp" />

<!--项目中带有默认的图标-->
<com.zjf.widget.widget.SearchEditText
    app:show_search_drawable="true"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp" />

<!--更换左侧的图标-->
<com.zjf.widget.widget.SearchEditText
    app:search_drawable="@drawable/icon_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp" />
```
```java
SearchEditText editText = findViewById(R.id.et);
//editText.setClearDrawable(R.drawable.icon_view);
editText.setOnClearTextListener(new SearchEditText.OnClearTextListener() {
      @Override
      public void onClearTextListener() {
          //点击清除文本的监听
                Toast.makeText(MainActivity.this, "清除文本", Toast.LENGTH_SHORT).show();
      }
});
```

## 隐私EditText: PrivacyEditText
> 隐藏和显示文本的EditText, 类似于密码输入框

<img src="https://github.com/zjfcabbage/widget/blob/master/images/privacyEditText.gif" alt="GitHub" title="GitHub,PrivacyEditText"/>

| 属性或方法 | 作用 |
| :-------:| :---:|
| viewDrawable | 显示文本的图标 |
| viewOffDrawable | 隐藏文本的图标 |




