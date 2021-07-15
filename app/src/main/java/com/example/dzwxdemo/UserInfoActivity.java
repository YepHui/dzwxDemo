package com.example.dzwxdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileWithBitmapCallback;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends BaseActivity {

    //调取系统摄像头的请求码
    private static final int MY_ADD_CASE_CALL_PHONE = 6;
    //打开相册的请求码
    private static final int MY_ADD_CASE_CALL_PHONE2 = 7;

    private Toolbar toolbar;
    private CircleImageView headPhoto;
    private EditText name;
    private EditText nickname;
    private EditText phone;
    private EditText idcard;
    private TextView tvNickName;
    private ImageButton ibNickname;
    private RelativeLayout changePhoto;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private LayoutInflater inflater;
    private View layout;
    private TextView takePhotoTV;
    private TextView choosePhotoTV;
    private TextView cancelTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_layout);
        init();
        initToolbar(toolbar);
        nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUpdateNickname();
            }
        });
        tvNickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUpdateNickname();
            }
        });
        ibNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUpdateNickname();
            }
        });
       /* changePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initTakePhoto();

            }
        });*/
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_uil_title);
        headPhoto = findViewById(R.id.civ_uil_photo);
        name = findViewById(R.id.et_uil_name);
        nickname = findViewById(R.id.et_uil_nickname);
        phone = findViewById(R.id.et_uil_phone);
        idcard = findViewById(R.id.et_uil_idcard);
        tvNickName = findViewById(R.id.tv_uil_nickname);
        ibNickname = findViewById(R.id.ib_uil_nickname);
        changePhoto = findViewById(R.id.rl_uil_photo);
    }

    @Override
    protected void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("nickname", nickname.getText().toString());
                intent.putExtras(bundle);
                setResult(201, intent);
                finish();
            }
        });
    }

    public void updatePhoto(View view) {
        initTakePhoto();
    }

    private void initTakePhoto() {
        builder = new AlertDialog.Builder(UserInfoActivity.this);//创建对话框
        inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.dialog_select_photo, null);//获取自定义布局
        builder.setView(layout);//设置对话框的布局
        dialog = builder.create();//生成最终的对话框
        dialog.show();//显示对话框

        takePhotoTV = layout.findViewById(R.id.photograph);
        choosePhotoTV = layout.findViewById(R.id.photo);
        cancelTV = layout.findViewById(R.id.cancel);
        //设置监听
        takePhotoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //"点击了照相";
                //  6.0之后动态申请权限 摄像头调取权限,SD卡写入权限
                //判断是否拥有权限，true则动态申请
                if (ContextCompat.checkSelfPermission(UserInfoActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        && ContextCompat.checkSelfPermission(UserInfoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(UserInfoActivity.this,
                            new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_ADD_CASE_CALL_PHONE);
                } else {
                    try {
                        //有权限,去打开摄像头
                        takePhoto();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
            }
        });
        choosePhotoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //"点击了相册";
                //  6.0之后动态申请权限 SD卡写入权限
                if (ContextCompat.checkSelfPermission(UserInfoActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(UserInfoActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_ADD_CASE_CALL_PHONE2);

                } else {
                    //打开相册
                    choosePhoto();
                }
                dialog.dismiss();
            }
        });
        cancelTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();//关闭对话框
            }
        });
    }

    private void toUpdateNickname() {
        Intent intent = new Intent(UserInfoActivity.this, UpdateNicknameActivity.class);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 201:
                Bundle bundle = data.getExtras();
                nickname.setText(bundle.get("nickname").toString());
                break;
            default:
                break;
        }
        if (requestCode == 1 && resultCode != Activity.RESULT_CANCELED) {
            //拍照
            String state = Environment.getExternalStorageState();
            if (!state.equals(Environment.MEDIA_MOUNTED)) return;
            // 把原图显示到界面上
            Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
            Tiny.getInstance().source(readpic()).asFile().withOptions(options).compress(new FileWithBitmapCallback() {
                @Override
                public void callback(boolean isSuccess, Bitmap bitmap, String outfile, Throwable t) {
                    saveImageToServer(bitmap, outfile);//显示图片到imgView上
                }
            });
        } else if (requestCode == 2 && resultCode == Activity.RESULT_OK
                && null != data) {
            //相册
            try {
                Uri selectedImage = data.getData();//获取路径
                Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
                Tiny.getInstance().source(selectedImage).asFile().withOptions(options).compress(new FileWithBitmapCallback() {
                    @Override
                    public void callback(boolean isSuccess, Bitmap bitmap, String outfile, Throwable t) {
                        saveImageToServer(bitmap, outfile);
                    }
                });
            } catch (Exception e) {
                //"上传失败");
            }
        }
    }

    private void takePhoto() throws IOException {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        // 获取文件
        File file = createFileIfNeed("UserIcon.png");
        //拍照后原图回存入此路径下
        Uri uri;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            uri = Uri.fromFile(file);
        } else {
            /**
             * 7.0 调用系统相机拍照不再允许使用Uri方式，应该替换为FileProvider
             * 并且这样可以解决MIUI系统上拍照返回size为0的情况
             */
            uri = FileProvider.getUriForFile(this, "com.example.dzwxdemo.fileprovider", file);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, 1);
    }

    // 在sd卡中创建一保存图片（原图和缩略图共用的）文件夹
    private File createFileIfNeed(String fileName) throws IOException {
        String fileA = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/nbinpic";
        File fileJA = new File(fileA);
        if (!fileJA.exists()) {
            fileJA.mkdirs();
        }
        File file = new File(fileA, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * 打开相册
     */
    private void choosePhoto() {
        //这是打开系统默认的相册(就是你系统怎么分类,就怎么显示,首先展示分类列表)
        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picture, 2);
    }

    /**
     * 申请权限回调方法
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == MY_ADD_CASE_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                try {
                    takePhoto();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "拒绝了你的请求", Toast.LENGTH_SHORT).show();
                //"权限拒绝");
                // TODO: 2018/12/4 这里可以给用户一个提示,请求权限被拒绝了
            }
        }


        if (requestCode == MY_ADD_CASE_CALL_PHONE2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                choosePhoto();
            } else {
                //"权限拒绝");
                // TODO: 2018/12/4 这里可以给用户一个提示,请求权限被拒绝了
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 从保存原图的地址读取图片
     */
    private String readpic() {
        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/nbinpic/" + "UserIcon.png";
        return filePath;
    }

    private void saveImageToServer(final Bitmap bitmap, String outfile) {
        File file = new File(outfile);

        // TODO: 2018/12/4  这里就可以将图片文件 file 上传到服务器,上传成功后可以将bitmap设置给你对应的图片展示
        headPhoto.setImageBitmap(bitmap);
    }
}