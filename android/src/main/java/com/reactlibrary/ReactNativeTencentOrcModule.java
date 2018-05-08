
package com.reactlibrary;

import com.qcloud.image.ImageClient;
import com.qcloud.image.request.FaceAddFaceRequest;
import com.qcloud.image.request.FaceAddGroupIdsRequest;
import com.qcloud.image.request.FaceCompareRequest;
import com.qcloud.image.request.FaceDelFaceRequest;
import com.qcloud.image.request.FaceDelGroupIdsRequest;
import com.qcloud.image.request.FaceDelPersonRequest;
import com.qcloud.image.request.FaceDetectRequest;
import com.qcloud.image.request.FaceGetFaceIdsRequest;
import com.qcloud.image.request.FaceGetFaceInfoRequest;
import com.qcloud.image.request.FaceGetGroupIdsRequest;
import com.qcloud.image.request.FaceGetInfoRequest;
import com.qcloud.image.request.FaceGetPersonIdsRequest;
import com.qcloud.image.request.FaceIdCardCompareRequest;
import com.qcloud.image.request.FaceIdCardLiveDetectFourRequest;
import com.qcloud.image.request.FaceIdentifyRequest;
import com.qcloud.image.request.FaceLiveDetectFourRequest;
import com.qcloud.image.request.FaceLiveDetectPictureRequest;
import com.qcloud.image.request.FaceLiveGetFourRequest;
import com.qcloud.image.request.FaceMultiIdentifyRequest;
import com.qcloud.image.request.FaceNewPersonRequest;
import com.qcloud.image.request.FaceSetInfoRequest;
import com.qcloud.image.request.FaceShapeRequest;
import com.qcloud.image.request.FaceVerifyRequest;
import com.qcloud.image.request.GeneralOcrRequest;
import com.qcloud.image.request.IdcardDetectRequest;
import com.qcloud.image.request.NamecardDetectRequest;
import com.qcloud.image.request.OcrBankCardRequest;
import com.qcloud.image.request.OcrBizLicenseRequest;
import com.qcloud.image.request.OcrDrivingLicenceRequest;
import com.qcloud.image.request.OcrPlateRequest;
import com.qcloud.image.request.PornDetectRequest;
import com.qcloud.image.request.TagDetectRequest;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;


public class ReactNativeTencentOrcModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public ReactNativeTencentOrcModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

  }

  @Override
  public String getName() {
    return "ReactNativeTencentOrc";
  }

  @ReactMethod
  public String ocrIdCard(final Callback callback) {
    String ret;
    ImageClient imageClient = new ImageClient(appId, secretId, secretKey);
    String[] idcardUrlList = new String[2];
    IdcardDetectRequest idReq = new IdcardDetectRequest(bucketName, idcardUrlList, 0);
    ret = imageClient.idcardDetect(idReq);
    callback.invoke("ret"+ret);
    return "ReactNativeTencentOrc";
  }
}