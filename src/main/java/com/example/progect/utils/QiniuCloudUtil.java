package com.example.progect.utils;

import com.qiniu.cdn.CdnManager;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class QiniuCloudUtil {

    private static final String ACCESS_KEY = "DwZMUh5Wq2uJR3342o-o1FGIFkvg54oOdYbt7N0Y";

    private static final String SECRET_KEY = "ADJXLiogIYWnxnW1g9AlTxn-3YLyKo3Ax0b40Cz1";

    // 要上传的空间
    private static final String bucketname = "anao";

    // 密钥

    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static final String DOMAIN = "qblgv435h.bkt.clouddn.com";

    private static final String style = "imageView2/0/q/75";

    public String getUpToken() {
        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
    }

    //base64方式上传
    public String put64image(byte[] base64, String key) throws Exception{
        String file64 = Base64.encodeToString(base64, 0);
        Integer l = base64.length;
        String url = "http://upload-z2.qiniup.com/putb64/" + l + "/key/"+ UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println(response);
        //如果不需要添加图片样式，使用以下方式
        return DOMAIN +"/"+ key;
//        return DOMAIN + key + "?" + style;
    }

    //删除文件
    public void delete(String fileName) throws QiniuException {
        String key = fileName;
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucketname, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }


    //刷新文件
    public void refresh(String url) throws QiniuException{
        String [] urls = {url};
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        CdnManager c = new CdnManager(auth);
        Response response = c.refreshUrls(urls);
    }
}
