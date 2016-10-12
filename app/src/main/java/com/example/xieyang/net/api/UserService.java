package com.example.xieyang.net.api;

import com.example.xieyang.respmodule.FestivalRespData;
import com.example.xieyang.respmodule.PictureDirectRespData;
import com.example.xieyang.respmodule.PushedFestivalRespData;
import com.example.xieyang.respmodule.ReplyRespData;
import com.example.xieyang.respmodule.RespData;
import com.example.xieyang.respmodule.RespDataStr;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/9.
 */
public interface UserService {

    @FormUrlEncoded
    @POST("HHoliday/login")
    Observable<RespData> userLogin(@FieldMap Map<String, String> body);

    @FormUrlEncoded
    @POST("HHoliday/register")
    Observable<RespDataStr> userRegister(@FieldMap Map<String, String> body);


    @FormUrlEncoded
    @POST("HHoliday/update")
    Observable<RespData> userUpdate(@FieldMap Map<String, String> body);

    @FormUrlEncoded
    @POST("HHoliday/showfestival")
    Observable<FestivalRespData> festivalShow(@FieldMap Map<String, String> body);

    @POST("HHoliday/showpushedfestival")
    Observable<PushedFestivalRespData> showPushedFestival();

    @FormUrlEncoded
    @POST("HHoliday/showonepushedfestival")
    Observable<PushedFestivalRespData> showonePushedFestival(@FieldMap Map<String, String> body);

    @FormUrlEncoded
    @POST("HHoliday/showreplyList")
    Observable<ReplyRespData> replylistShow(@FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST("HHoliday/showreplyCount")
    Observable<RespDataStr> replycountShow(@FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST("HHoliday/updateLike")
    Observable<RespDataStr> updatelikecountShow(@FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST("HHoliday/cancelupdateLike")
    Observable<RespDataStr> cancelupdatelikecountShow(@FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST("HHoliday/addReplyContent")
    Observable<RespDataStr> addReplyContentShow(@FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST("HHoliday/checkUser")
    Observable<RespDataStr> checkTokens(@FieldMap Map<String, String> body);

    @Multipart
    @POST("HHoliday/updateUserHeadPicture")
    Observable<RespDataStr> updateUserHeadPicture(@Part MultipartBody.Part file1, @Part("user.userEmail") RequestBody userEmail, @Part("user.token") RequestBody token);

    @FormUrlEncoded
    @POST("HHoliday/sendCode")
    Observable<RespDataStr> sendCode(@FieldMap Map<String, String> body);

    @FormUrlEncoded
    @POST("HHoliday/forgetPwd")
    Observable<RespDataStr> forgetPwd(@FieldMap Map<String, String> body);

    @POST("HHoliday/getPictureDirectContent")
    Observable<PictureDirectRespData> pictureshow();

}
